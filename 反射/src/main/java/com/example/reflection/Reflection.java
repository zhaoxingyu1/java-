package com.example.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zxy
 * @Classname Reflection
 * @Date 2022/4/23 14:55
 */
public class Reflection {

    public static void main(String[] args) throws Exception {


        Class<Student> studentClass = Student.class;
        // 获取父类的class对象从而获取其名字
        System.out.println("获取父类的class对象从而获取其名字");
        System.out.println(studentClass.getSuperclass().getName());
        System.out.println("=================================================================");

        // 根据反射获取对象实例
        Student student =studentClass.newInstance();
        System.out.println(student);
        System.out.println("=================================================================");

        // 根据反射构造方法创建实例 无参构造 newInstance()方法不参参就行
        System.out.println("根据反射有参构造方法创建实例");
        Constructor<Student> declaredConstructor = studentClass.getDeclaredConstructor(String.class);
        Student zxy = declaredConstructor.newInstance("zxy");
        System.out.println(zxy);
        System.out.println("=================================================================");

        ClassLoader classLoader = studentClass.getClassLoader();
        System.out.println(classLoader);
        System.out.println("=================================================================");

        // 根据反射获取一个方法对像数组
        Method[] methods = studentClass.getMethods();
        System.out.println("获取一个方法列表");
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("获取一个方法");
        Method method = studentClass.getDeclaredMethod("test");
        System.out.println(method);
        System.out.println("=================================================================");
        // 获取字段
        System.out.println("获取public属性");
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("获取全部的属性全部属性");
        fields = studentClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("获取指定属性");
        Field name = studentClass.getField("name");
        System.out.println(name);
        System.out.println("=================================================================");
        System.out.println("根据反射调用一个方法");
        // 通过构造器创造对象
            // 无参构造器
        Student student1 = studentClass.newInstance();

            // 有参构造器
        Constructor<Student> constructor = studentClass.getDeclaredConstructor(String.class);

        // 安全检测是否关闭 破坏私有权限 （破坏 private 权限）
        constructor.setAccessible(true);  // true为关闭 false为开启（默认开启false）
        // 传递有参构造器参数
        Student zxysb = constructor.newInstance("zxy");

        // 调用一个方法
        // 获取一个方法
        Method getAge = studentClass.getDeclaredMethod("setAge", String.class);
        // invoke() 激活 （要操作的对象，多个方法的值）
        getAge.setAccessible(true);
        getAge.invoke(zxysb,"10000");
        System.out.println(zxysb.getAge());

        System.out.println("=================================================================");
        // 操作属性
        Field studentName = studentClass.getDeclaredField("name");
        studentName.setAccessible(true);
        studentName.set(student,"傻逼");

    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{

    public String name;

}

@Data
class Student extends Person{

    public String age;
    public String name;

    public Student(){
        this.name = "学生";
    }

    public Student(String name){
        this.name=name;
    }

    public String test(){
        System.out.println("test方法");
        return "test方法返回值";
    }
}

class Teacher extends Person{

    public Teacher(){
        this.name = "教师";
    }
}