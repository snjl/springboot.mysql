package com.example.myproject.service.impl;

import com.example.myproject.dao.TbStudentDao;
import com.example.myproject.domain.TbStudent;
import com.example.myproject.service.TbStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 34924
 */
@Service
public class TbStudentServiceImpl implements TbStudentService{
    @Resource(name = "tbStudentDaoImpl")
    private TbStudentDao tbStudentDao;


    @Override
    public int insert(TbStudent tbStudent) {
        return tbStudentDao.insert(tbStudent);
    }

    @Override
    public int update(TbStudent tbStudent) {
        return tbStudentDao.update(tbStudent);
    }

    @Override
    public int delete(long id) {
        return tbStudentDao.delete(id);
    }

    @Override
    public TbStudent findTbStudent(long id) {
        return tbStudentDao.findTbStudent(id);
    }

    @Override
    public List<TbStudent> findAll() {
        return tbStudentDao.findAll();
    }
}
