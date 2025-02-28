package com.evento.Eventos.services;

import com.evento.Eventos.dtos.UserDTO;
import com.evento.Eventos.models.User;
import com.evento.Eventos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /*public void saveUser(UserDTO userDTO) {
        User user = new User(userDTO);
        return new UserDTO(userRepository.save(user));
    }*/

    public UserDTO saveUser(UserDTO userDTO) {
        User user = changeUserDTOToUser(userDTO);
        user = userRepository.save(user);
        return changeUserToUserDTO(user);
    }

    public UserDTO changeUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setCpf(user.getCpf());
        userDTO.setBirthDate(user.getBirthDate());
        userDTO.setProfile(user.getProfile());
        userDTO.setVerified(user.getVerified());
        return userDTO;
    }

    public User changeUserDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setCpf(userDTO.getCpf());
        user.setBirthDate(userDTO.getBirthDate());
        user.setProfile(userDTO.getProfile());
        user.setVerified(userDTO.isVerified());
        return user;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public UserDTO getUserByEmail(String email) {
        return changeUserToUserDTO(userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found")));
    }

    public UserDTO updateUser(UserDTO userDTO) {
        if (isNull(userDTO.getId())) {
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        User user = userRepository.findById(userDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuário não encontrado"));
        user = new User(userDTO);
        userRepository.save(user);
        return new UserDTO(user);
    }

    public void deleteUser(Long id) {
    }
}