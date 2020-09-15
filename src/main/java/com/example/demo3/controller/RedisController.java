package com.example.demo3.controller;

import com.example.demo3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class RedisController {
    @Autowired
    private StudentService studentService ;

    @GetMapping(value = "/springboot/student" )
    public @ResponseBody Object student() {
      /*  //线程池个数，一般建议是CPU内核数 或者 CPU内核数据*2
        ExecutorService executorService = Executors.newFixedThreadPool(8) ;

        for(int i=0 ; i<1000; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    studentService.queryAllStudentCount() ;
                }
            }) ;
        }*/

        return "学生总人数"+studentService.queryAllStudentCount() ;
    }
}
