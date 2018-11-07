/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaders.Controller;

import com.javaders.Model.User;
import com.javaders.Service.UserService;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tugba
 */
@Path("/rest/users")
public class UserController {

    UserService userService = UserService.getInstance();

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUser() {
        return userService.userList;
    }

    //QueryParam Example
    @GET
    @Path("/names")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByName(@QueryParam("name") String username) {
        return userService.findUserByName(username);
    }

    //PathParam example
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("userId") String id) {
        return userService.findUserById(id);
    }

    //FormParam example
    @PUT
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String registerUserPutExample(@FormParam("username") String name, @FormParam("password") String password) {
        if (userService.isUserNameUsed(name)) {
            return "Bu kullanıcı adı daha önceden kullanılmış";
        } else {
            boolean registered = userService.registerUser(name, password);
            if (registered) {
                return "Başarıyla kayıt olundu.";
            } else {
                return "Kayıt işlemi gerçekleştirilemedi";
            }
        }
    }

    @DELETE
    @Path("/{userId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@PathParam("userId") String id) {
        boolean result = userService.deleteUser(id);
        if (result) {
            return "Başarıyla Silindi";
        } else {
            return "Böyle bi user yok.";
        }
    }

    @POST
    @Path("/{userId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUserName(@PathParam("userId") String id, @FormParam("newUserName") String newname) {
        boolean result = userService.changeUserName(id, newname);
        if (result) {
            return "Kullanıcı adı güncellendi.";
        } else {
            return "Böyle bi user yok.";
        }
    }

}
