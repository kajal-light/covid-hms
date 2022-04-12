package com.covidhms.covid.repo;

import com.covidhms.covid.model.DocterEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocterRepo extends PagingAndSortingRepository<DocterEntity,Integer> {

@Query(name="select * from docter where docter_Id=?0")
    DocterEntity findByDocter(String id);
}
