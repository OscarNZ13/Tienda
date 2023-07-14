package com.Tienda.dto;

import lombok.Data;

//La etiqueta data es de Loombok y ayuda a generar automaticamente los getter y setter.
@Data
public class ProductFB {
    private String id;
    private String nombre, category, descripcion, detalle;
    private int precio, existencias;
    private String ruta_imagen;
    private boolean activo;
}
