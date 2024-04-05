package com.rudeveloper.lms.programmeserviceapi.utill;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
