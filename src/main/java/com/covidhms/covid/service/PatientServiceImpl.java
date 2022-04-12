package com.covidhms.covid.service;

import com.covidhms.covid.domain.request.PatientRequest;
import com.covidhms.covid.domain.response.PatientResponse;
import com.covidhms.covid.exceptionHandlerr.BusinessException;
import com.covidhms.covid.model.PatientEntity;
import com.covidhms.covid.repo.PatientRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepo patientRepo;


    @Override
    public String createObject(PatientRequest patientRequest) {

            if (patientRequest.getName().isEmpty()) {
                throw new BusinessException("Your Name is null,Kinldy check the Request ", "400 ");
            }
            try{
            String patientId = genratePatientId();
            PatientEntity patientEntity = new PatientEntity();
            StringToBooleanConvertor(patientRequest, patientEntity);
            BeanUtils.copyProperties(patientRequest, patientEntity);
            patientEntity.setPatientId(patientId);
            LocalDate date = LocalDate.now();
            patientRequest.setDateOfAdmission(date);
            String dailyPatientCounter = String.valueOf(getPatientCountOnSingleDay(date));
            patientEntity.setDailyPatientCounter(dailyPatientCounter);
            StringToBooleanConvertor(patientRequest, patientEntity);
            patientEntity.setSymptomStatus(patientRequest.getSymptomStatus());
            patientEntity.setActionTaken(patientRequest.getActionTaken());
           // patientEntity.setComment(patientRequest.getComment());
            Instant lastUpdatedOn = Instant.now();
            patientEntity.setLastUpdatedOn(lastUpdatedOn);
            patientRepo.save(patientEntity);
            return patientId;
        }catch (IllegalArgumentException e){
            throw new BusinessException("Your payload is null ", "401 "+ e.getMessage());

        }catch (Exception e){
            throw new BusinessException("Something went wrong ", "404 "+ e.getMessage());
            }
    }


    @Override
    public PatientResponse getPatientDetails(String id) {
        PatientEntity patientEntity=new PatientEntity();
        PatientResponse patientResponse = new PatientResponse();
        if(id.isEmpty()){
            throw new BusinessException("33"," enter valid id");
        }
        try{
        patientEntity = patientRepo.getByPatientId(id);
        BeanUtils.copyProperties(patientEntity, patientResponse);
        return patientResponse;
        }
        catch (IllegalArgumentException e){
            throw new BusinessException("no record found ", "401 "+ e.getMessage());

        }catch (Exception e){
            throw new BusinessException("Something went wrong in business layer ", "404 "+ e.getMessage());
        }


        }


    @Override
    public String updateInPatient(PatientRequest patientRequest) {
        String patientId = patientRequest.getPatientId();
        if(patientId.isEmpty()){
            throw new BusinessException("33"," enter valid id");
        }
        PatientEntity patientEntity = patientRepo.getByPatientId(patientId);
        if (patientEntity == null){

           throw new BusinessException("333"," no date found");
        }

            try {
            patientEntity.setBedAllotment(patientRequest.getBedAllotment());
            patientEntity.setOutcome(patientRequest.getOutcome());
            patientEntity.setFirstResult(patientRequest.getFirstResult());
            patientEntity.setSecondResult(patientRequest.getSecondResult());
            patientEntity.setThirdResult(patientRequest.getThirdResult());
            patientRepo.save(patientEntity);
            return "updated successfully";
        } catch (Exception e){
                throw new BusinessException("Something went wrong in business layer ", "404 "+ e.getMessage());
            }
    }

    @Override
    @Transactional
    public String deletePatient(String patientId) {
        PatientEntity patientEntity = patientRepo.getByPatientId(patientId);
        if (patientEntity == null){
            throw new BusinessException("333"," no date found");
        }
        try{
            patientRepo.deleteByPatientId(patientId);
            return "deleted successfully";
        } catch (Exception e){
                throw new BusinessException("Something went wrong in business layer ", "404 "+ e.getMessage());
            }
    }


    @Override
    public List<PatientResponse> getAllPatient() {
        Iterable<PatientEntity> patients = patientRepo.findAll();
        if (patients == null) {

            throw new BusinessException("333", " no date found");
        }
        try {
            List<PatientEntity> result = new ArrayList<>();
            patients.forEach(result::add);
            return convertingforIteration(result);
        } catch (Exception e) {
            throw new BusinessException("Something went wrong in business layer ", "404 " + e.getMessage());
        }
    }

    //************************************
    private List<PatientResponse> convertingforIteration(List<PatientEntity> patientEntity) {
        List<PatientResponse> patientResponselIST = new ArrayList<>();
        for (PatientEntity s : patientEntity) {
            PatientResponse patientResponse = new PatientResponse();
            BeanUtils.copyProperties(s, patientResponse);
            patientResponselIST.add(patientResponse);
        }
        return patientResponselIST;


    }

    private int getPatientCountOnSingleDay(LocalDate date) {

        return patientRepo.getTotalPatientByDay(date) + 1;

    }

    public static String genratePatientId() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();

        String id = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String jk = id.toUpperCase();


        return jk;
    }

    private void StringToBooleanConvertor(PatientRequest patientRequest, PatientEntity patientEntity) {
        if (patientRequest.getContactHistory() == null) {
            patientEntity.setContactHistory(null);
        } else if (patientRequest.getContactHistory().equals("YES")) {
            patientEntity.setContactHistory(true);
        } else if (patientRequest.getContactHistory().equals("NO")) {
            patientEntity.setContactHistory(false);
        }


        if (patientRequest.getTravelHistory() == null) {
            patientEntity.setTravelHistory(null);
        } else if (patientRequest.getTravelHistory().equals("YES")) {
            patientEntity.setTravelHistory(true);
        } else if (patientRequest.getTravelHistory().equals("NO")) {
            patientEntity.setTravelHistory(false);
        }

        if (patientRequest.getCoMorbidity() == null) {
            patientEntity.setCoMorbidity(null);
        } else if (patientRequest.getCoMorbidity().equals("YES")) {
            patientEntity.setCoMorbidity(true);
        } else if (patientRequest.getCoMorbidity().equals("NO")) {
            patientEntity.setCoMorbidity(false);
        }

        if (patientRequest.getSrfNo() == null) {
            patientEntity.setSrfNo(null);
        } else if (patientRequest.getSrfNo().equals("YES")) {
            patientEntity.setSrfNo(true);
        } else if (patientRequest.getSrfNo().equals("NO")) {
            patientEntity.setSrfNo(false);
        }

        if (patientRequest.getCovidActiveStatus() == null) {
            patientEntity.setCovidActiveStatus(null);
        } else if (patientRequest.getCovidActiveStatus().equals("Suspected")) {
            patientEntity.setCovidActiveStatus(true);
        } else if (patientRequest.getCovidActiveStatus().equals("Unsuspected")) {
            patientEntity.setCovidActiveStatus(false);
        }

    }

//    private int getCountOfPatientId() {
//
//       return patientRepo.getTotalPatient();
//    }
}
