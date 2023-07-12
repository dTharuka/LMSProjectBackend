package com.bookcatalog.sprigboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RegisterDTO {
    private String registerID;
    private String courseID;
    private String userID;
    private String name;
    private String email;
}
