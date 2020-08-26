package nz.co.johannesvogt.userservice.api.support;

import org.glassfish.jersey.server.monitoring.ApplicationEvent;
import org.glassfish.jersey.server.monitoring.ApplicationEventListener;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JerseyExceptionLogger implements ApplicationEventListener, RequestEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyExceptionLogger.class);

    @Override
    public void onEvent(final ApplicationEvent applicationEvent) {
    }

    @Override
    public RequestEventListener onRequest(final RequestEvent requestEvent) {
        return this;
    }

    @Override
    public void onEvent(RequestEvent paramRequestEvent) {
        if(paramRequestEvent.getType() == RequestEvent.Type.ON_EXCEPTION) {
            LOGGER.error("Exception handling request", paramRequestEvent.getException());
        }
    }
}

