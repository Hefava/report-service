package com.report_service.ports.application.http.mapper;

import com.report_service.domain.model.Articulos;
import com.report_service.domain.model.ReporteVenta;
import com.report_service.ports.application.http.dto.ReporteVentaRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReporteVentaMapper {

    // De DTO a Model
    @Mapping(target = "articulosComprados", source = "articulosComprados")
    ReporteVenta toModel(ReporteVentaRequest reporteVentaRequest);

    // De ArticulosRequest a Articulos Model
    Articulos toModel(ReporteVentaRequest.ArticulosRequest articulosRequest);

    // De Model a DTO
    @Mapping(target = "articulosComprados", source = "articulosComprados")
    ReporteVentaRequest toDto(ReporteVenta reporteVenta);

    // De Articulos Model a ArticulosRequest DTO
    ReporteVentaRequest.ArticulosRequest toDto(Articulos articulos);
}
