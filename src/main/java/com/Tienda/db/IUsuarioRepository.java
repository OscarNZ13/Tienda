package com.Tienda.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tienda.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    Usuario findByUsernameAndPassword(String username, String Password);

    Usuario findByUsernameOrCorreo(String username, String correo);

    boolean existsByUsernameOrCorreo(String username, String correo);
}