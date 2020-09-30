package com.trakknamur.springRecap.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserServ {
    public UserDetails loadUserByUsername(String username);
}
