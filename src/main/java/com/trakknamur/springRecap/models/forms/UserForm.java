package com.trakknamur.springRecap.models.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserForm {

    String username;

    String password;

    String email;

    String address;

    String deliveryAddress;

    List<String> roles = new ArrayList<>();

}
