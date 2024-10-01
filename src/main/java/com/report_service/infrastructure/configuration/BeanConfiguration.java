package com.report_service.infrastructure.configuration;

import com.report_service.domain.api.IReporteVentaServicePort;
import com.report_service.domain.api.usecase.ReporteVentaUseCase;
import com.report_service.domain.spi.IReporteVentaPersistencePort;
import com.report_service.domain.spi.IUsuarioPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IReporteVentaPersistencePort reporteVentaPersistencePort;
    private final IUsuarioPersistencePort usuarioPersistencePort;

    @Bean
    public IReporteVentaServicePort reporteVentaServicePort() {
        return new ReporteVentaUseCase(reporteVentaPersistencePort, usuarioPersistencePort);
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }
}
