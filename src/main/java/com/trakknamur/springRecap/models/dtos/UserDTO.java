package com.trakknamur.springRecap.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    Long idUser;

    String username;

    String password;

    String email;

    String address;

    String deliveryAddress;

    List<String> roles = new ArrayList<>();

    boolean isAccountNonExpired;

    boolean isAccountNonLocked;

    boolean isCredentialsNonExpired;

    boolean isEnabled;
}
