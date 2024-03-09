package org.dev.JDBC_With_SpringBoot.controller;


import org.dev.JDBC_With_SpringBoot.requests.PersonRequestData;
import org.dev.JDBC_With_SpringBoot.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


//real app
@RestController
@RequestMapping("/v2")
public class PersonController2 {

    @Autowired
    private PersonService personService;

    private static Logger logger = LoggerFactory.getLogger("PersonController2");

    @PostMapping("/addPersonData")
    public ResponseEntity addPerson(@RequestBody @Valid PersonRequestData person){

        logger.info("Inside our controller with person name as {}" , person.getFirstName());


        // store data to db
        // validations inside our controller
        // if validations fail -> handle the exception
        // light controller
//        if(person.getFirstName() == null || person.getFirstName() == ""){
//            return  null;
//        }
//        if(person.getDob() ==  null || person.getDob() ==""){
//            return null;
//        }
        // in appropriate case
//        service class
        personService.createPerson(person);
        ResponseEntity responseEntity = new ResponseEntity(person, HttpStatus.BAD_REQUEST);
        return responseEntity;

    }

//    person ->  what i want to get stored in db
//            person -> what i am getting from frontend


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrorList =bindingResult.getFieldErrors();
        List<String> error = fieldErrorList.stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }





}
