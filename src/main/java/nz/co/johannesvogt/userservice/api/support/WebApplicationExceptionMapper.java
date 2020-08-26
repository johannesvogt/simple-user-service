package nz.co.johannesvogt.userservice.api.support;

import nz.co.johannesvogt.userservice.spec.model.Error;

import javax.ws.rs.WebApplicationException;

public class WebApplicationExceptionMapper extends ErrorResponseExceptionMapper<WebApplicationException> {
    @Override
    protected Error toError(WebApplicationException exception) {
        return new Error()
                .status(exception.getResponse().getStatus())
                .reason(exception.getMessage());
    }
}
