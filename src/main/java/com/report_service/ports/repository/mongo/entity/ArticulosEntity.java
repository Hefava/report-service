package com.report_service.ports.repository.mongo.entity;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticulosEntity {
    private String nombreArticulo;
    private Long cantidadComprada;
    private Double precioUnitario;
}
