package com.maven.springmvc.domain;

public class Student {
    //属性名和请求中的参数名要一致
    private String name;
    private  Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName:"+name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge:"+age);
        this.age = age;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        System.out.println("student无参数构造方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
