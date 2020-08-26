package nz.co.johannesvogt.userservice.api.support;

import nz.co.johannesvogt.userservice.spec.model.Error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

abstract class ErrorResponseExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {
    @Override
    public final Response toResponse(T exception) {
        Error error = toError(exception);
        return Response.status(error.getStatus())
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(error)
                .build();
    }

    protected abstract Error toError(T exception);
}
