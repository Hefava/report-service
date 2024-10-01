package com.report_service.domain.spi;

public interface IUsuarioPersistencePort {
    Long obtenerUsuarioID();
    String obtenerUsuarioEmail(Long usuarioID);
}
