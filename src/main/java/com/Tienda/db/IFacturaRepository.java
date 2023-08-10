package com.Tienda.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Tienda.entities.Factura;

public interface IFacturaRepository extends JpaRepository <Factura,Long>{

}
