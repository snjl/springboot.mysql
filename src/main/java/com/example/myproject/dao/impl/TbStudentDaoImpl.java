package com.example.myproject.dao.impl;

import com.example.myproject.dao.TbStudentDao;
import com.example.myproject.domain.TbStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbStudentDaoImpl implements TbStudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int insert(TbStudent tbStudent) {
        return jdbcTemplate.update("insert into tb_student(NAME) VALUES (?)",tbStudent.getName());
    }

    @Override
    public int update(TbStudent tbStudent) {
        return jdbcTemplate.update("update tb_student set NAME=? where id=?",tbStudent.getName(),tbStudent.getId());
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("delete from tb_student where id=?", id);
    }

    @Override
    public TbStudent findTbStudent(long id) {
        List<TbStudent> list = jdbcTemplate.query("SELECT * FROM tb_student WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(TbStudent.class));
        if(list != null && list.size() > 0) {
            TbStudent tbStudent = list.get(0);
            return tbStudent;
        }else {
            return null;
        }
    }

    @Override
    public List<TbStudent> findAll() {
        List<TbStudent> list = jdbcTemplate.query("SELECT * FROM tb_student",
                new Object[]{}, new BeanPropertyRowMapper<>(TbStudent.class));

        return list;
    }
}
