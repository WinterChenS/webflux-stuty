package com.example.flux.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 14:16
 **/
@Document
@Data
public class User {

    @Id
    private String id;

    private String username;

    private String address;

}