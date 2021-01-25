package com.maven.springmvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller :创建处理器对象,对象放在springmvc中 位置在类上面
 * 和spring中的Service,@Component 一样都是用来创建对象的
 */
@Controller
public class MyController {

    /**
     *  处理用户提交的请求 springmvc中是用方法来处理的
     Scratches*  方法名称是自定义的 多种参数 有多种返回值
     *  能处理请求的都是控制器(处理器) MyController能处理请求
     *  MyController 叫做后端处理器 (back Controller)
     */
    /**
     * 准备使用 doSome方法来处理请求
     * @RequestMapping 请求映射 作用是把一个请求地址和一个方法绑定在一起
     * 属性: value 是一个String ,表示请求地址 value的值必须是唯一的
     * 在使用的时候 推荐使用以 /开头
     * 位置 : 1在方法的上面
     *        2.类的上面
     *        说明:使用@RequestMapping 修饰的方法叫做处理器方法或者叫控制器方法
     *         @RequestMapping修饰的方法是可以处理请求的 类似 Servlet中的 doGet 和doPost方法
     *         value = "/some.do  /:表示根地址
     * @return 返回值是ModelAndView  本次处理请求的结果 数据和视图的展示
     * Model: 表示处理完请求后 要返回的数据
     * View :请求完之后需要返回的地址 比如jsp等等
     */
    @RequestMapping(value = {"/some.do","/first.do"})
    public ModelAndView doSome(){
        //处理som.do的请求 以下的操作 假设已经从service层处理完业务逻辑 开始向客户端返回处理结果

        ModelAndView mv = new ModelAndView();
        //添加数据 ,框架在请求的最后部分 把这个数据放入到request作用域中 相当于 request.setAttribute()
        mv.addObject("msg","欢迎使用springmvc开发");
        mv.addObject("fun","执行的是doSome方法");

        //指定视图  指定视图的完整路径 框架对视图执行的是 forward()
//        mv.setViewName("/WEB-INF/view/show.jsp");

        //当配置视图解析器之后 可以使用逻辑名称(文件名)  框架会用前缀+逻辑名称+后缀 组成完整的路径名
        mv.setViewName("show");  //  WEB-INF/view/+show+.jsp
        //返回mv对象
        return mv;
    }

    @RequestMapping(value = {"/other.do","/second.do"})
    public ModelAndView doOther(){
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","欢迎使用springmvc开发");
        mv.addObject("fun","执行的是doOther方法");
        mv.setViewName("other");  //  WEB-INF/view/+show+.jsp

        return mv;
    }
}
