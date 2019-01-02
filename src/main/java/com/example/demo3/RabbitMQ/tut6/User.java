package com.example.demo3.RabbitMQ.tut6;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private  String name;
    private String sex;
    private int age;

    public User(int id) {
        this.id = id;
        this.name="zmm";
        this.sex="w";
        this.age=20;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
