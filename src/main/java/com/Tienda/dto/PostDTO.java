package com.Tienda.dto;

import lombok.Data;

//La etiqueta data es de Loombok y ayuda a generar automaticamente los getter y setter.
@Data
public class PostDTO {
    private String id, tittle, content;

}
