package com.report_service.domain.api.usecase;

import com.report_service.domain.api.IReporteVentaServicePort;
import com.report_service.domain.model.ReporteVenta;
import com.report_service.domain.spi.IReporteVentaPersistencePort;
import com.report_service.domain.spi.IUsuarioPersistencePort;

public class ReporteVentaUseCase implements IReporteVentaServicePort {
    IReporteVentaPersistencePort reporteVentaPersistencePort;
    IUsuarioPersistencePort usuarioPersistencePort;

    public ReporteVentaUseCase(IReporteVentaPersistencePort reporteVentaPersistencePort, IUsuarioPersistencePort usuarioPersistencePort) {
        this.reporteVentaPersistencePort = reporteVentaPersistencePort;
        this.usuarioPersistencePort = usuarioPersistencePort;
    }

    @Override
    public void generarReporteVenta(ReporteVenta reporteVenta) {
        Long usuarioID = usuarioPersistencePort.obtenerUsuarioID();
        String correoUsuario = usuarioPersistencePort.obtenerUsuarioEmail(usuarioID);
        reporteVenta.setCorreoUsuario(correoUsuario);
        reporteVentaPersistencePort.saveReporteVenta(reporteVenta);
    }
}
