package com.maven.springmvc.controller;


import com.maven.springmvc.domain.Student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @requestMapping : 放在类上面 : value 表示所有请求地址的公共部分
 */
@Controller
@RequestMapping("/user")
public class MyController {

    /**
     *
     * @return  @RequestMapping:请求映射
     *  属性 :method表示请求方式 他的值是 RequestMethod 的枚举类型值 例如 :get请求 RequestMethod.GET
     */

    @RequestMapping(value = {"/some.do","/first.do"},method = RequestMethod.POST)
    /**
     *  逐个接受post请求 表单发送过来的数据
     *  要求: 处理器方法的形参名称和请求中的参数名称必须一致 同名的请求参数名赋值给同名的形参
     *  框架在接受请求参数的时候 ,会进行类型转换 能把 string int double float long 等类型
     *  400状态码:表示客户端错误,表示客户端在提交数据的过程中发生了错误
     */
    public ModelAndView doSome(String name,Integer age){

        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","name:"+name);
        mv.addObject("fun","age:"+age);

        mv.setViewName("show");
        //返回mv对象
        return mv;
    }

    /**
     *  请求中的参数名和控制器方法的形参名称不一致
     * @RequestParame 可以解决
     *  属性1: value 请求中的参数名
     *  位置:定义在控制器方法形参的前面
     *  属性2:required 是一个boolean值 默认是true :表示请求中必须包含此参数
     *  如果是false 就表示可以没有,如果没有,就是空串
     *
     *
     *
     */
    @RequestMapping(value = {"/receiveParam.do","/receiveParams.do"},method = RequestMethod.POST)
    public ModelAndView receiveParam(@RequestParam(value = "Sname",required = false)  String name, @RequestParam(value = "Sage") Integer age){
        System.out.println("name:"+name+","+"age:"+age);
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","name:"+name);
        mv.addObject("fun","age:"+age);

        mv.setViewName("show");
        //返回mv对象
        return mv;
    }

    /**
     * 处理器方法的形参是java对象 ,这个对象的属性名和java对象的属性名是一致的
     * 框架会给形参的java对象,给属性赋值,请求中的name 会调用setName方法
     * @return
     */
    @RequestMapping(value = {"/objectParam.do","/objectParams.do"},method = RequestMethod.POST)
    public ModelAndView objectParam (Student student){

        System.out.println("name:"+student.getName()+","+student.getAge());

        ModelAndView mv = new ModelAndView();

        mv.addObject("name","name:"+student.getName());
        mv.addObject("age","age:"+student.getAge());

        mv.setViewName("show");
        //返回mv对象
        return mv;
    }



}
