package com.report_service.ports.repository.mongo.persistency;

import com.report_service.ports.repository.mongo.entity.ReporteVentaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReporteVentaMongoRepository extends MongoRepository<ReporteVentaEntity, String> {
}
