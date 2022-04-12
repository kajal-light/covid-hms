package com.covidhms.covid.controller;

import com.covidhms.covid.domain.request.PatientRequest;
import com.covidhms.covid.domain.response.PatientResponse;
import com.covidhms.covid.exceptionHandlerr.BusinessException;
import com.covidhms.covid.exceptionHandlerr.ControllerException;
import com.covidhms.covid.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")//http:localhost:8081/users
public class PatientController {


    @Autowired
    PatientService patientService;


    @PostMapping("/addPatient")

    public ResponseEntity<?> create(@RequestBody PatientRequest patientRequest) {

        String result = null;
        try {
            result = patientService.createObject(patientRequest);
            return new ResponseEntity<String>(result,HttpStatus.ACCEPTED);
        } catch (BusinessException e) {
            ControllerException ce=new ControllerException(e.getErrorCode(),e.getMessage()+e.getMessage());
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_GATEWAY);
        }catch (Exception e){
            ControllerException ce=new ControllerException("55"," something went wroung in controller");
            return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
        }

    }

   @GetMapping(path="/{id}")
    public ResponseEntity<?> getPatient(@PathVariable String id){
if(id.isEmpty()){
   throw new ControllerException("33"," kindly check your id parametermeter");
}
try {
          PatientResponse patientResponse = new PatientResponse();
          patientResponse = patientService.getPatientDetails(id);
          return new ResponseEntity<PatientResponse>(patientResponse, HttpStatus.FOUND);
}catch (BusinessException e) {
           ControllerException ce=new ControllerException(e.getErrorCode(),e.getMessage()+e.getMessage());
           return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_GATEWAY);
       }catch (Exception e){
           ControllerException ce=new ControllerException("55"," something went wroung in controller");
           return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
       }
   }


    @GetMapping("/getListOfPatient")
    public List<PatientResponse> getPatient() {

            return patientService.getAllPatient();
    }


        @PutMapping ("/update")
  public ResponseEntity<?> updatePatient(@RequestBody PatientRequest patientRequest){
       if(patientRequest==null) {

           throw new ControllerException("55","" +
                   "null data passed");
       }

try {
    String status = patientService.updateInPatient(patientRequest);
    return new ResponseEntity<String>(status, HttpStatus.GONE);
}catch (BusinessException e) {
    ControllerException ce=new ControllerException(e.getErrorCode(),e.getMessage()+e.getMessage());
    return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_GATEWAY);
}catch (Exception e){
    ControllerException ce=new ControllerException("55"," something went wroung in controller");
    return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
}
        }



@DeleteMapping(path="/{patientId}")
    public String delelet(@PathVariable String patientId){

   return patientService.deletePatient(patientId);

    }





}
