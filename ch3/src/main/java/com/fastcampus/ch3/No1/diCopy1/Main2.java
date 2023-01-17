package com.fastcampus.ch3.No1.diCopy1;

import java.io.FileReader;
import java.util.Properties;

class Engine{};

public class Main2 {
    public static void main(String[] args) throws Exception {
        Car car = (Car)getObject("car");
        System.out.println("car = " + car);

        Engine engine = (Engine)getObject("engine");
        System.out.println("engine = " + engine);
    }

    static Object getObject(String key) throws Exception {
        Properties p = new Properties();

        //파일 시작 위치는 프로젝트 폴더
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty(key));

        return clazz.newInstance();
    }
}
