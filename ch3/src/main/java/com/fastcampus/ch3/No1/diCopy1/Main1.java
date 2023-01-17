package com.fastcampus.ch3.No1.diCopy1;

import java.io.FileReader;
import java.util.Properties;

//접근 제한자 생략 시 default 접근 제한자를 가짐
class Car {
}

class SportsCar extends Car {
}

class Truck extends Car {
}

public class Main1 {
    public static void main(String[] args) throws Exception {
        Car car = getCar();
        System.out.println("car = " + car);
    }

    static Car getCar() throws Exception {
        Properties p = new Properties();

        //파일 시작 위치는 프로젝트 폴더
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty("car"));

        return (Car) clazz.newInstance();
    }
}