package com.example.demo.User.model;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String username;
    private float age;
}
