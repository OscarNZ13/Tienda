package com.Tienda.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tienda.entities.Venta;

public interface IVentaRepository extends JpaRepository <Venta,Long> {

}
