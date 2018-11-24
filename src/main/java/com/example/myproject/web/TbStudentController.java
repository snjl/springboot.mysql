package com.example.myproject.web;

import com.example.myproject.domain.TbStudent;
import com.example.myproject.service.TbStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 34924
 */
@RestController
@RequestMapping("/tbStudent")
public class TbStudentController {

    @Resource(name = "tbStudentServiceImpl")
    private TbStudentService tbStudentService;

    @RequestMapping("/findAll")
    public List<TbStudent> findAll() {
        return tbStudentService.findAll();
    }

    @RequestMapping("/delete/{id}")
    public int delete(@PathVariable long id) {
        return tbStudentService.delete(id);
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public int insert(@RequestBody TbStudent tbStudent) {
        return tbStudentService.insert(tbStudent);
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public int update(@RequestParam Integer id,@RequestParam String name) {
        TbStudent tbStudent = tbStudentService.findTbStudent(id);
        tbStudent.setName(name);
        return tbStudentService.update(tbStudent);
    }

    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    public TbStudent findOne(@RequestBody TbStudent tbStudent) {
        return tbStudentService.findTbStudent(tbStudent.getId());
    }
}
