package com.jianglai.learn.stage02;

class PersonTest{
    public static void main(String args[]) {
        Person p1, p2;
        p1 = new Person("张三", 28, 'M');
        p2 = new Person();
        p2.setName("陈红");
        p2.setAge(38);
        p2.setSex('F');
        p1.introduceme();
        p2.introduceme();
    }
}
