package com.report_service.ports.repository.mongo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document("ReporteVenta")
public class ReporteVentaEntity {
    @Id
    private String correoUsuario;
    private LocalDateTime fechaCompra;
    private Double costoTotal;
    private List<ArticulosEntity> articulosComprados;
}
