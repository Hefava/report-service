package com.report_service.ports.repository.mongo.adapter;

import com.report_service.domain.model.ReporteVenta;
import com.report_service.domain.spi.IReporteVentaPersistencePort;
import com.report_service.ports.repository.mongo.entity.ArticulosEntity;
import com.report_service.ports.repository.mongo.entity.ReporteVentaEntity;
import com.report_service.ports.repository.mongo.persistency.ReporteVentaMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReporteVentaAdapter implements IReporteVentaPersistencePort {
    private final ReporteVentaMongoRepository reporteVentaMongoRepository;

    @Override
    public void saveReporteVenta(ReporteVenta reporteVenta) {
        ReporteVentaEntity reporteVentaEntity = ReporteVentaEntity.builder()
                .correoUsuario(reporteVenta.getCorreoUsuario())
                .fechaCompra(reporteVenta.getFechaCompra())
                .costoTotal(reporteVenta.getCostoTotal())
                .articulosComprados(reporteVenta.getArticulosComprados().stream()
                        .map(articulo -> ArticulosEntity.builder()
                                .nombreArticulo(articulo.getNombreArticulo())
                                .cantidadComprada(articulo.getCantidadComprada())
                                .precioUnitario(articulo.getPrecioUnitario())
                                .build())
                        .toList())
                .build();
        reporteVentaMongoRepository.save(reporteVentaEntity);
    }
}