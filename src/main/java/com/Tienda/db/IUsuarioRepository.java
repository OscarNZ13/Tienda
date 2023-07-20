package com.Tienda.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tienda.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);

}
