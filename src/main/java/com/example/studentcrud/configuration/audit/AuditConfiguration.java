package com.example.studentcrud.configuration.audit;

import com.example.studentcrud.configuration.security.SpringSecurityAuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.IsNewAwareAuditingHandler;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.event.AuditingEntityCallback;
import org.springframework.beans.factory.ObjectFactory;

@Configuration
@EnableMongoAuditing
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAwareImpl();
    }

    @Bean
    public AuditingEntityCallback auditingEntityCallback(ObjectFactory<IsNewAwareAuditingHandler> auditingHandlerFactory) {
        return new AuditingEntityCallback(auditingHandlerFactory);
    }
}
