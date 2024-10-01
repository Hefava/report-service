package com.report_service.domain.spi;

import com.report_service.domain.model.ReporteVenta;

public interface IReporteVentaPersistencePort {
    void saveReporteVenta(ReporteVenta reporteVenta);
}
