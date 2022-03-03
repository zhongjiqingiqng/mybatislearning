package com.kuang.dao;

import com.kuang.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {


    //获取老师
    List<Teacher> getTeacher();

  //  /获取指定老师，及老师下的所有学生
    public Teacher getTeacher1(int id);
}
