package com.report_service.ports.application.http.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioIDRequest {
    private Long usuarioID;
}