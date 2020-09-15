package com.example.demo3.serviceimpl;

import com.example.demo3.mapper.StudentMapper;
import com.example.demo3.pojo.Student;
import com.example.demo3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired(required = false)
    private StudentMapper studentMapper ;

    @Autowired
    private RedisTemplate redisTemplate ;


    @Override
    public Integer queryAllStudentCount() {
        //设置redis的key序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //从redis中获取学生总人数
        Integer allStudentCount = (Integer) redisTemplate.opsForValue().get("allStudentCount") ;

        if(null == allStudentCount){
            System.out.println("查询数据库");

            //从数据库查询
            allStudentCount = studentMapper.selectAllStudentCount() ;

            //将值放入redis缓存当中
            redisTemplate.opsForValue().set("allStudentCount",allStudentCount,15, TimeUnit.HOURS);

        }else{

            System.out.println("查找REDIS...");
        }
/*        return allStudentCount;
        //从数据库查询
        Integer  allStudentCount = studentMapper.selectAllStudentCount() ;
        System.out.println("查询结果"+allStudentCount);*/
        return allStudentCount;
        /*return  (long)2 ;*/
    }
    @Override
    public Student queryStudentByPri(Integer id) {

        //从数据库查询
        Student queryStudent= studentMapper.selectByPrimaryKey(id) ;
        System.out.println("查询结果"+queryStudent.toString());
        return queryStudent;
        /*return  (long)2 ;*/
    }
}
