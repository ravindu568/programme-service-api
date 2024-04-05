package com.rudeveloper.lms.programmeserviceapi.repo;

import com.rudeveloper.lms.programmeserviceapi.entity.Programme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgrammeRepository extends MongoRepository<Programme,String> {


}
