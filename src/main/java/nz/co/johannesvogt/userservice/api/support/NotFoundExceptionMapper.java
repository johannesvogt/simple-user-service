package nz.co.johannesvogt.userservice.api.support;

import nz.co.johannesvogt.userservice.spec.model.Error;

import javax.ws.rs.NotFoundException;

public class NotFoundExceptionMapper extends ErrorResponseExceptionMapper<NotFoundException> {

    @Override
    protected Error toError(NotFoundException exception) {
        return new Error()
                .status(exception.getResponse().getStatus())
                .reason(exception.getMessage());
    }

}
