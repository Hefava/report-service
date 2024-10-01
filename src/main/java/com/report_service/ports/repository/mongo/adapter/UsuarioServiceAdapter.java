package com.report_service.ports.repository.mongo.adapter;

import com.report_service.domain.spi.IUsuarioPersistencePort;
import com.report_service.ports.application.http.dto.UsuarioIDRequest;
import com.report_service.ports.feign.UsuarioFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioServiceAdapter implements IUsuarioPersistencePort {

    private final UsuarioFeign usuarioClient;

    @Override
    public Long obtenerUsuarioID() {
        UserDetails usuarioID = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Long.valueOf(usuarioID.getUsername());
    }

    @Override
    public String obtenerUsuarioEmail(Long usuarioID) {
        UsuarioIDRequest request = new UsuarioIDRequest();
        request.setUsuarioID(usuarioID);
        return usuarioClient.obtenerCorreo(request);
    }

}
