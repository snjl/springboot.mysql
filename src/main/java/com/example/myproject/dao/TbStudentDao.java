package com.example.myproject.dao;

import com.example.myproject.domain.TbStudent;

import java.util.List;

public interface TbStudentDao {

    int insert(TbStudent tbStudent);

    int update(TbStudent tbStudent);

    int delete(long id);

    TbStudent findTbStudent(long id);

    List<TbStudent> findAll();
}
