package 工厂模式.simpleFactory;

import 工厂模式.methodFactory.Car;

/**
 * @author zxy
 * @Classname FulaiCar
 * @Date 2022/5/6 18:14
 */
public class FulaiCar implements Car {
    @Override
    public void start() {
        System.out.println("福来开启");
    }

    @Override
    public void open() {
        System.out.println("福来打开");
    }
}
