package com.example.demo.controller;
import com.example.demo.bean.Details;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserServices userserv;


    @RequestMapping(method = RequestMethod.GET,value = "/users")
    public List<Details> getAllUsers(){
        return userserv.getUsers();
    }
    @RequestMapping(method = RequestMethod.GET,value = "/users/{id}")
    public Details getUser(@PathVariable Long id){
        return userserv.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<Object> addUsers(@RequestBody Details details){
        userserv.addUser(details);
        return new ResponseEntity<>(
                "User is created with Id: "+ details.getId()+"\n Name: "+details.getName()+" \n Emp Id: "+details.getEmpId()+"\n Tech: "+details.getTech(),
        HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id,@RequestBody Details details){
        userserv.updateUser(id,details);
        return new ResponseEntity<>(
                "User is Updated with Id"+" "+ details.getId(),
        HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{id}")
    public ResponseEntity<Object> deleteUer(@PathVariable Long id, @RequestBody Details details){
        userserv.deleteUser(id);
        return  new ResponseEntity<>(
                "User Deleted with Id"+" "+ details.getId(),
        HttpStatus.ACCEPTED);
    }

}

