package com.maven.springmvc.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @requestMapping : 放在类上面 : value 表示所有请求地址的公共部分
 */
@Controller
@RequestMapping("/user")
public class MyController {



    @ResponseBody
    @RequestMapping(value = {"/donUrlPattern"},method = RequestMethod.POST)
    public ModelAndView doSome (String name ,Integer age)  {

        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.setViewName("show");
        return mv;
    }



}
