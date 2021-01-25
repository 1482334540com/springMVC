package com.maven.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @requestMapping : 放在类上面 : value 表示所有请求地址的公共部分
 */
@Controller
@RequestMapping("/user")
public class MyController {

    /**
     * 处理器返回ModelAndView,实现forward操作
     * 语法:setViewName("forward:视图的完整路径")
     * 特点:不和视图解析器一起使用 就当项目中没有视图解析器
     *
     */
    @RequestMapping(value = {"/doForward.do"},method = RequestMethod.POST)
    public ModelAndView doSome(HttpServletRequest req, HttpServletResponse resp, HttpSession session){

        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","name-->"+req.getParameter("name"));
        mv.addObject("fun","age-->"+req.getParameter("age"));
        //显示转发 forward(请求转发)
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
//        mv.setViewName("forward:/hello.jsp");
        //返回mv对象
        return mv;
    }
    /**
     * 处理器返回ModelAndView,实现Redirect操作
     * 语法:setViewName("redirect:视图的完整路径")
     * 特点:不能访问WEB-INF下的资源 不和视图解析器使用
     * 框架对重定向的操作:会把Model中的简单数据类型 转为String使用 作为下次请求的参数使用
     * 目的:是可以在doRedirect.do 和hello.sjp中传输数据
     */
    @RequestMapping(value = {"/doRedirect.do"},method = RequestMethod.POST)
    public ModelAndView doRedirect(String name,Integer age){

        ModelAndView mv = new ModelAndView();
        //数据是放到request中
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //显示转发 forward(请求转发)
        mv.setViewName("redirect:/hello.jsp");

       // http://localhost/spring/hello.jsp?myName=root&myAge=20 发起的第二次请求

        //返回mv对象
        return mv;
    }

}
