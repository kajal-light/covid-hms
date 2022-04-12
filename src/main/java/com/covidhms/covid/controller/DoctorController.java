package com.covidhms.covid.controller;


import com.covidhms.covid.domain.request.DocterRequest;
import com.covidhms.covid.domain.response.DocterResponse;
import com.covidhms.covid.service.DocterInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docters")
public class DoctorController {

    @Autowired
    DocterInterface docterInterface;

    @PostMapping("/create")
    public String createRecord(@RequestBody DocterRequest docterRequest){
       String id=null;
       id=docterInterface.create(docterRequest);
        return id;

    }

@GetMapping(path="/{id}")
    public DocterResponse getData(@PathVariable String id){

        return docterInterface.getUser(id);


}


}
