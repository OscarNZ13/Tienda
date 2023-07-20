package com.Tienda.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUsuarioService {

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
