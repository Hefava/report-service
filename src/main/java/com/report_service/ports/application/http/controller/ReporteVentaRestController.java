package com.report_service.ports.application.http.controller;

import com.report_service.domain.api.IReporteVentaServicePort;
import com.report_service.domain.model.ReporteVenta;
import com.report_service.domain.utils.TokenHolder;
import com.report_service.ports.application.http.dto.ReporteVentaRequest;
import com.report_service.ports.application.http.mapper.ReporteVentaMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reporte")
@RequiredArgsConstructor
public class ReporteVentaRestController {
    private final IReporteVentaServicePort reporteVentaServicePort;
    private final ReporteVentaMapper reporteVentaRequestMapper;

    @Operation(summary = "Generar reporte de ventas", description = "Permite generar un reporte de ventas con los datos especificados en la solicitud.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reporte de ventas generado exitosamente."),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta. Los datos del reporte pueden ser inválidos o incompletos."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor. Se produjo un problema al procesar la solicitud.")
    })
    @PostMapping("/generar-reporte-ventas")
    public ResponseEntity<Void> generarReporteVenta(
            @RequestHeader("Authorization") @Parameter(required = true) String token,
            @RequestBody @Valid @Parameter(required = true) ReporteVentaRequest requestDto) {

        TokenHolder.setToken(token);
        ReporteVenta domainRequest = reporteVentaRequestMapper.toModel(requestDto);
        reporteVentaServicePort.generarReporteVenta(domainRequest);
        TokenHolder.clear();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}