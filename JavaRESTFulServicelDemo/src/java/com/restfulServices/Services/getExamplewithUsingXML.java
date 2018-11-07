/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfulServices.Services;

import com.restfulServices.Model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tugba
 */
@Path("/getExampleXML")
public class getExamplewithUsingXML {
    
    
    // webservice/getExampleXML/getAValue
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/getAValue")
    public Person getAValue(){
        Person person = new Person();
        
        person.setName("Tuğba");
        person.setSurname("Ay");
        person.setCity("İstanbul");
        person.setCountry("Türkiye");
        
        return person;
    }
    
    // webservice/getExampleXML/getListValue
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/getListValue")
    public List<Person> getListValue(){
        
        List<Person> persons = new ArrayList<>();
        
        Person person1 = new Person();
        
        person1.setName("Tuğba");
        person1.setSurname("Ay");
        person1.setCity("İstanbul");
        person1.setCountry("Türkiye");
        
        
        Person person2 = new Person();
        
        person2.setName("Nurdan");
        person2.setSurname("Albaş");
        person2.setCity("Rize");
        person2.setCountry("Türkiye");
        
        
        Person person3 = new Person();
        
        person3.setName("Erdem Çağrı");
        person3.setSurname("Görücü");
        person3.setCity("Sivas");
        person3.setCountry("Türkiye");
        
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        
        return persons;
    }
    
    
}
