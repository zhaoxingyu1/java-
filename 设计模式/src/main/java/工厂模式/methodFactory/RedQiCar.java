package 工厂模式.methodFactory;

/**
 * @author zxy
 * @Classname RedQiCar
 * @Date 2022/5/6 18:14
 */
public class RedQiCar implements Car {
    @Override
    public void start() {
        System.out.println("红旗开启");

    }

    @Override
    public void open() {
        System.out.println("红旗打开");
    }
}
