package com.maven.springmvc.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.maven.springmvc.domain.Student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * @requestMapping : 放在类上面 : value 表示所有请求地址的公共部分
 */
@Controller
@RequestMapping("/user")
public class MyController {


    private String name;
    private Integer age;

    /**
     *  使用处理器方法 返回String 表示逻辑名称 需要配置视图解析器
     *
     *
     */
    @RequestMapping(value = {"/returnString1.do"},method = RequestMethod.POST)
    public String returnString (HttpServletRequest request, Student student){

        System.out.println("name:"+student.getName()+","+student.getAge());
        //手动添加数据到reques域中去
        request.setAttribute("name",student.getName());
        request.setAttribute("age",student.getAge());
        /**
         *   show:逻辑视图名称 springmvc.xml中配置的视图解析器
         *   框架对视图执行的forward转发操作
         */

        return "show";
    }
    /**
     *  使用处理器方法 返回String 表示完整视图路径
     *
     *
     */
    @RequestMapping(value = {"/returnString2.do"},method = RequestMethod.POST)
    public String returnAllUrlString (HttpServletRequest request, Student student){

        System.out.println("name:"+student.getName()+","+student.getAge());
        //手动添加数据到reques域中去
        request.setAttribute("name",student.getName());
        request.setAttribute("age",student.getAge());
        /**
         *  框架中就不能进行视图配置解析器
         *   框架对视图执行的forward转发操作
         */

        return "/WEB-INF/view/show.jsp";
    }

    @RequestMapping(value = {"/returnVoid-ajax.do"})
    public void doReturnAjax (HttpServletResponse response, Student student) throws IOException {


        //处理ajax 使用json做数据格式 假设service已经调用完成
        Student students= new Student();
        students.setName(student.getName());
        students.setAge(student.getAge());

        if(students!=null){
            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(student);
            System.out.println("student转换的json-->"+json);
           // 响应ajax的请求
            response.setContentType("application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println(json);
            writer.flush();
            writer.close();
        }
    }


    /**
     * 处理器方法返回一个Student，通过框架转为json，响应ajax请求
     * @ResponseBody:
     *    作用：把处理器方法返回对象转为json后，通过HttpServletResponse输出给浏览器。
     *    位置：方法的定义上面。 和其它注解没有顺序的关系。
     * 返回对象框架的处理流程：
     *  1.  <mvc:annotation-driven /> 在springmvc.xml配置文件中加上开启驱动的注册
     *     框架会把返回Student类型，调用框架的中ArrayList<HttpMessageConverter>中每个类的canWrite()方法
     *     检查那个HttpMessageConverter接口的实现类能处理Student类型的数据--MappingJackson2HttpMessageConverter
     *
     *  2.在控制器方法上加上 @ResponseBody注解
     *    框架会调用实现类的write（）， MappingJackson2HttpMessageConverter的write()方法
     *    把李四同学的student对象转为json， 调用Jackson的ObjectMapper实现转为json
     *    contentType: application/json;charset=utf-8
     *
     *  3. 返回student对象
     *    框架会调用@ResponseBody把2的结果数据输出到浏览器， ajax请求处理完成
     */

    @RequestMapping(value = {"/returnStudentJson.do"})
    @ResponseBody
    public Student doStudentObject (String name, Integer age)  {
        //student 就表示返回的结果数据
        Student student = new Student();
        student.setName("小明");
        student.setAge(20);
        return student; //返回json字符串
    }

    /**
     * 处理器方法返回List<student>集合 发给服务端的是json数组
     *
     */
    @RequestMapping(value = {"/returnStudentJsonArray.do"})
    @ResponseBody
    public List<Student> doStudentObject ()  {
        //student 就表示返回的结果数据
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("小明",20));
        students.add(new Student("小花",18));
        return students; //返回json数组
    }
    /**
     * 返回一个String String表示数据 不是视图
     * 如何区分返回String是视图还是数据 就看方法上有没有 :@ResponseBody 注解 有就是数据 反之亦然
     * 默认使用的是 ISo-8859-1 作为 ContentType 导致中文乱码]
     * 解决方案:在RequestMapping中添加 produces 这个属性设置新的ContentType 值
     * 
     *  1. 框架会把返回String类型，调用框架的中ArrayList<HttpMessageConverter>中每个类的canWrite()方法
     *   检查那个HttpMessageConverter接口的实现类能处理String类型的数据--StringHttpMessageConverter
     *
     *  2.框架会调用实现类的write（）， StringHttpMessageConverter的write()方法
     *    把字符按照指定的编码处理 text/plain;charset=ISO-8859-1
     *
     *  3.框架会调用@ResponseBody把2的结果数据输出到浏览器， ajax请求处理完成
     */

    @ResponseBody
    @RequestMapping(value = {"/returnStringData.do"},produces = "text/plain;charset=utf-8")
    public String doStringData ()  {
        //String 表示返回的结果数据

        return "hello Spring 返回对象 表示数据";
    }



}
