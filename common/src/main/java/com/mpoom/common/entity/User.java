package com.mpoom.common.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String email;
    private Integer age;
    private Integer state;
}
