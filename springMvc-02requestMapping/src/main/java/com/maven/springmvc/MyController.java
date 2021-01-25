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
     *
     * @return  @RequestMapping:请求映射
     *  属性 :method表示请求方式 他的值是 RequestMethod 的枚举类型值 例如 :get请求 RequestMethod.GET
     */

    @RequestMapping(value = {"/some.do","/first.do"},method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest req, HttpServletResponse resp, HttpSession session){

        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","欢迎使用springmvc开发-->"+req.getParameter("name"));
        mv.addObject("fun","执行的是doSome方法");

        mv.setViewName("show");
        //返回mv对象
        return mv;
    }

    //指定 other.do 的请求方式为post 请求
    @RequestMapping(value = {"/other.do","/second.do"},method = RequestMethod.POST)
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","欢迎使用springmvc开发");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("other");

        return mv;
    }
}
