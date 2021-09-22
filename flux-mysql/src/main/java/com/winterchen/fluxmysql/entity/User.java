package com.winterchen.fluxmysql.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author CENTURY
 * @version 1.0
 * @date 2021/9/22 16:45
 * @description TODO
 **/
@Data
public class User {

    @Id
    private Long id;

    private String username;

    private String address;

}