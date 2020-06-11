package com.example.study.model.entity.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatus {

    REGISTERED(0,"상태","사용자 등록상태"),
    UNREGISTERED(1,"해지","사용자 해지상탸")
    ;

    private Integer id;
    private String title;
    private String description;
}
