package com.covidhms.covid.service;

import com.covidhms.covid.domain.request.DocterRequest;
import com.covidhms.covid.domain.response.DocterResponse;
import com.covidhms.covid.model.DocterEntity;
import com.covidhms.covid.repo.DocterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocterServiceIMPL implements DocterInterface {

@Autowired
DocterRepo docterRepo;


@Override
    public String create(DocterRequest docterRequest) {
    String id=PatientServiceImpl.genratePatientId();
    DocterEntity docterEntity=new DocterEntity();
    docterEntity.setDocterId(id);
    docterEntity.setName(docterRequest.getName());
    docterEntity.setAge(docterRequest.getAge());
    docterEntity.setSex(docterRequest.getSex());
    docterEntity.setDepartment(docterRequest.getDepartment());
    docterEntity.setDayMark(docterRequest.getDayMark());
    //BeanUtils.copyProperties(docterRequest,docterEntity);
    docterRepo.save(docterEntity);

        return id;
    }

    @Override
    public DocterResponse getUser(String id) {
        DocterResponse docterResponse=new DocterResponse();
        DocterEntity  docterEntity=new DocterEntity();
        docterEntity= docterRepo.findByDocter(id);


        return null;
    }
}
