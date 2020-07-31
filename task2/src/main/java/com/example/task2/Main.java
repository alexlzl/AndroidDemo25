package com.example.task2;

public class Main {
    public void test(){
        Outer.Inner.test();
        Outer outer=new Outer();
        Outer.Inner1 inner1= new Outer().new Inner1();
    }
}
