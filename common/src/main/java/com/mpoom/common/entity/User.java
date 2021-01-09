package com.mpoom.common.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String email;
    private Integer age;
    private Integer state;
}
