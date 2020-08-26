package nz.co.johannesvogt.userservice.api;

import nz.co.johannesvogt.userservice.api.support.NotFoundExceptionMapper;
import nz.co.johannesvogt.userservice.api.resource.UserResource;
import nz.co.johannesvogt.userservice.api.support.JerseyExceptionLogger;
import nz.co.johannesvogt.userservice.api.support.WebApplicationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceConfigConfiguration {

    @Bean
    public ResourceConfig resourceConfig() {
        return new ResourceConfig()
            .register(UserResource.class)
            .register(JerseyExceptionLogger.class)
            .register(NotFoundExceptionMapper.class)
            .register(WebApplicationExceptionMapper.class);
    }
}