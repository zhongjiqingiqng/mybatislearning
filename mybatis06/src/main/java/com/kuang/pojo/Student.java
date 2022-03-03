package com.kuang.pojo;


import lombok.Data;

@Data
public class Student {

    private int id;
    private String name;
    //每个学生都要关联一名老师
    private Teacher teacher;

}
