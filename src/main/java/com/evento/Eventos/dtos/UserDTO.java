package com.evento.Eventos.dtos;

import com.evento.Eventos.enums.Profile;
import com.evento.Eventos.models.User;
import java.time.LocalDate;
import java.util.List;

public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private LocalDate birthDate;
    private String profile;
    private boolean verified;
    private List<Profile> profiles;

    public UserDTO() {}

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.cpf = user.getCpf();
        this.birthDate = user.getBirthDate();
        this.verified = user.getVerified();
        this.profiles = user.getProfiles();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }
    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}