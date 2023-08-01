package com.Tienda.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tienda.entities.Rol;

public interface IRolRepository extends JpaRepository<Rol, Long> {

}
