package com.restfulServices.Services;

import com.restfulServices.Model.Person;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tugba
 */
@Path("postExampleJSON")
public class postExamplewithJSON {

    // webservice/postExampleJSON/postAValue
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/postAValue")
    public void postAValue(Person person) {
        System.out.println(person.getName());
        System.out.println(person.getSurname());
        System.out.println(person.getCity());
        System.out.println(person.getCountry());
    }

    // webservice/postExampleJSON/postListValue
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/postListValue")
    public void postListValue(List<Person> persons) {

        for (Person person : persons) {
            System.out.println(person.getName());
            System.out.println(person.getSurname());
            System.out.println(person.getCity());
            System.out.println(person.getCountry());
        }
    }

    // webservice/postExampleJSON/returnAnswerpostMethod
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/returnAnswerpostMethod")
    public List<Person> returnAnswerpostMethod(List<Person> persons) {
        for (Person person : persons) {
            System.out.println(person.getName());
            System.out.println(person.getSurname());
            System.out.println(person.getCity());
            System.out.println(person.getCountry());
        }

        return persons;
    }

}
