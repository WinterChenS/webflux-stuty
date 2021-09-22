package com.winterchen.fluxrouter.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 16:00
 **/
@Data
@Document
public class Person {

    @Id
    private Long id;

    private String name;

    private String address;




}