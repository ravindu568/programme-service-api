package com.rudeveloper.lms.programmeserviceapi.controller;

import com.rudeveloper.lms.programmeserviceapi.dto.request.RequestProgrameDto;
import com.rudeveloper.lms.programmeserviceapi.repo.ProgrammeRepository;
import com.rudeveloper.lms.programmeserviceapi.service.ProgrammeService;
import com.rudeveloper.lms.programmeserviceapi.utill.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/programs")
public class ProgrammeController {

    private final ProgrammeService programmeService;
    @PostMapping
    public ResponseEntity<StandardResponse> createProgramme(
            @RequestBody RequestProgrameDto requestProgrameDto

    ){
        programmeService.createProgramme(requestProgrameDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Programe successfully created",requestProgrameDto.getName()),HttpStatus.CREATED
        );
    }
}
