package com.example.demo3.service;

import com.example.demo3.pojo.Student;
import org.springframework.stereotype.Service;




@Service("studentServiceImpl")
public interface StudentService {
    /**
     * 获取总人数
     * @return
     */
    Integer queryAllStudentCount() ;
    Student queryStudentByPri(Integer id) ;

}
