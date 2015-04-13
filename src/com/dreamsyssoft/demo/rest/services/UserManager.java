package com.dreamsyssoft.demo.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.dreamsyssoft.demo.rest.model.UserRequest;
import com.dreamsyssoft.demo.rest.model.UserResponse;

@Produces("application/json")
public interface UserManager {

    @POST
    @Consumes("application/json")
    @Path("/fetchUserById/")
    public UserResponse fetchUserById(UserRequest request);

    @GET
    @Path("/fetchAllUsers/")
    public UserResponse fetchAllUsers();

    @POST
    @Consumes("application/json")
    @Path("/insertUser/")
    public UserResponse insertUser(UserRequest request);

    @POST
    @Consumes("application/json")
    @Path("/updateUser/")
    public UserResponse updateUser(UserRequest request);

    @POST
    @Consumes("application/json")
    @Path("/deleteUser/")
    public UserResponse deleteUser(UserRequest request);
}
