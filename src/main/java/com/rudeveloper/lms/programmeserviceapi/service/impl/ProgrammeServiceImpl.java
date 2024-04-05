package com.rudeveloper.lms.programmeserviceapi.service.impl;

import com.rudeveloper.lms.programmeserviceapi.dto.request.RequestProgrameDto;
import com.rudeveloper.lms.programmeserviceapi.entity.Programme;
import com.rudeveloper.lms.programmeserviceapi.entity.Subject;
import com.rudeveloper.lms.programmeserviceapi.repo.ProgrammeRepository;
import com.rudeveloper.lms.programmeserviceapi.service.ProgrammeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgrammeServiceImpl implements ProgrammeService {

    private final ProgrammeRepository programmeRepository;
    private final WebClient webClient;

    @Override
    public void createProgramme(RequestProgrameDto programeDto) {
        Programme programme=Programme.builder()
                .name(programeDto.getName())
                .price(programeDto.getPrice()).
                startDate(programeDto.getStartDate()).
                subjects(programeDto.getSubjects()).build();

        ArrayList<Long> list=new ArrayList<>();
        for(Subject sub: programme.getSubjects()){
            list.add(sub.getId());
        }
        String ids=list.stream().map(Objects::toString).collect(Collectors.joining(","));
        System.out.println(ids);



        Boolean isOk=webClient.get().uri("http://localhost:8082/api/v1/subjects",
                uriBuilder -> uriBuilder.queryParam("id",ids).build())
                        .retrieve().bodyToMono(Boolean.class).block();

        if(Boolean.TRUE.equals(isOk)){
            programmeRepository.save(programme);
        }else{
            throw new IllegalArgumentException("Try again with available languages");
        }




    }
}
