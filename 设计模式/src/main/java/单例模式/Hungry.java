package 单例模式;

/**
 * @author zxy
 * @Classname Hungry
 * @Deprecated 单例饿汉式   会浪费资源
 * @Date 2022/4/17 15:28
 */
public class Hungry {

    private static Hungry HUNGRY = new Hungry();

    private Hungry(){

    }

    public static Hungry getInstance() {
        return HUNGRY;
    }

}
