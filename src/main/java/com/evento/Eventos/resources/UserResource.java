package com.evento.Eventos.resources;

import com.evento.Eventos.dtos.UserDTO;
import com.evento.Eventos.models.User;
import com.evento.Eventos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserbyId(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(userService.changeUserToUserDTO(user));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<UserDTO>> getUserByEmail(@RequestParam String email) {
        UserDTO userDTO = userService.getUserByEmail(email);
        return ResponseEntity.ok(List.of(userDTO));
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> criarUsuario(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }
}
