package com.Tienda.service;

import java.io.IOException;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface IReporteService {
    
    public ResponseEntity<Resource>
            generaReporte(String reporte, //El nombre del archivo llamado .jasper
                    Map<String, Object> parametros, //Los parámetros del reporte..si tiene parámetros
                    String tipo) throws IOException;//El tipo de reporte.... Pdf, Xls, Csv...
    
}
