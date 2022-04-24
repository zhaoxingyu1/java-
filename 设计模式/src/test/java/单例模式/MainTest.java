package 单例模式;

import org.junit.Test;

/**
 * @author zxy
 * @Classname MainTest
 * @Date 2022/4/17 15:32
 */

public class MainTest {

    /**
     * 饿汉式单例模式测试
     */
    @Test
    public void hungryTest(){

        Hungry instance1 = Hungry.getInstance();
        Hungry instance2 = Hungry.getInstance();
        // true;
        System.out.println(instance1==instance2);

    }

    /**
     * 懒汉式单例模式测试
     */
    @Test
    public void lazyManTest() {




    }

}
