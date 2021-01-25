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


    @RequestMapping(value = {"/some.do"},method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletRequest req, HttpServletResponse resp, HttpSession session){

        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","欢迎使用springmvc开发-->"+req.getParameter("name"));
        mv.addObject("fun","执行的是doSome方法");

        mv.setViewName("/index.jsp");
        //返回mv对象
        return mv;
    }


}
