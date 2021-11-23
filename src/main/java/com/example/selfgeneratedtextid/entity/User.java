package com.example.selfgeneratedtextid.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator", strategy = "com.example.selfgeneratedtextid.MyGenerator")
    @Column(name="id")
    private String id;


    @Column(name = "name")
    String name;


}