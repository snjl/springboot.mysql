package com.example.myproject.service;

import com.example.myproject.domain.TbStudent;

import java.util.List;

/**
 * @author 34924
 */

public interface TbStudentService {


    int insert(TbStudent tbStudent);

    int update(TbStudent tbStudent);

    int delete(long id);

    TbStudent findTbStudent(long id);

    List<TbStudent> findAll();

}
