package 原型模式;

import java.util.Date;

/**
 * @author zxy
 * @Classname TestMain
 * @Date 2022/5/7 15:54
 */
public class TestMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date();
        String name ="java";
        // 原型对象
        Video video1 = new Video(name,date);

        System.out.println(video1);
        System.out.println(video1.hashCode());


        Video video2 = (Video) video1.clone();
        System.out.println(video2);
        System.out.println(video2.hashCode());

        // 修改值
//        video2.setName("zxy");
        date.setTime(1232131);

        System.out.println("========================================");
        System.out.println(video1);
        System.out.println(video2);
        System.out.println("========================================");



    }

}
