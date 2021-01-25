package com.ssm.test;


import com.ssm.dao.StudentDao;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import com.ssm.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {


    @Test
    public  void  TestUserDao(){
        String config = "applicationContext.xml";
        ApplicationContext context =new ClassPathXmlApplicationContext(config);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("容器中的对象"+beanDefinitionName);
        }
    }

    @Test
    public  void  TestUserDao2(){
        String config = "applicationContext.xml";
        ApplicationContext context =new ClassPathXmlApplicationContext(config);
        StudentDao dao = context.getBean("studentDao", StudentDao.class);
        List<Student> students = dao.selectStudents();
        System.out.println(students);

    }
}
