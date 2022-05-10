package com.spring.fastcampus.controller.No11;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
    public static void main(String[] args) throws Exception {

        //1. YoilTeller클래스의 객체를 생성
        Class clazz = Class.forName("com.spring.fastcampus.controller.No11.YoilTeller");
        Object obj = clazz.newInstance();

        //2. 모든 메서드 정보를 가져와서 배열에 저장
        Method[] methodArr = clazz.getDeclaredMethods();

        for (Method m : methodArr) {
            String name = m.getName(); //메서드의 이름
            Parameter[] paramArr = m.getParameters(); //매개변수 목록
//			Class[] paramTypeArr = m.getParameterTypes();
            Class returnType = m.getReturnType(); //반환 타입

            StringJoiner paramList = new StringJoiner(", ", "(", ")");

            for (Parameter param : paramArr) {
                String paramName = param.getName();
                Class paramType = param.getType();

                paramList.add(paramType.getName() + " " + paramName);
            }

            System.out.printf("!%s %s%s%n", returnType.getName(), name, paramList);

//            매개 변수의 이름은 Compiler에게 중요하지 않기 때문에 arg0, arg1,,, 등으로 처리하여 관리
//            매개 변수 이름을 저장하려면 javac -parameters 라는 옵션을 주어야 함 (컴파일러 옵션에 추가)
//            !java.lang.String main(int arg0, int arg1, int arg2, org.springframework.ui.Model arg3)
//            !char getYoil(int arg0, int arg1, int arg2)
//            !boolean isValie(int arg0, int arg1, int arg2)
        }
    } // main
}

/* [실행결과]
java.lang.String main(java.lang.String year, java.lang.String month, java.lang.String day, org.springframework.ui.Model model)
boolean isValid(int year, int month, int day)
*/

