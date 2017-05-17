package com.luwu.web.api;

import com.luwu.core.dto.UserDto;
import com.luwu.core.service.UserService;
import com.luwu.web.api.dto.RegistrationDto;
import io.dropwizard.hibernate.UnitOfWork;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserService userService;

    @Inject
    private UserResource(UserService userService) {
        this.userService = userService;
    }

    //TODO: Temp method
    @GET
    @Path("/list")
    @UnitOfWork
    public List<UserDto> listAll() {
        return userService.findAll();
    }

    @POST
    @Path("/register")
    @UnitOfWork
    public Response createUser(@NotNull @Valid RegistrationDto registrationDto) {
        return Response.accepted(null).build();
    }
}
