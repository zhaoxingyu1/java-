package 工厂模式.simpleFactory;

import 工厂模式.methodFactory.Car;

/**
 * @author zxy
 * @Classname TestMain
 * @Date 2022/5/6 18:18
 */
public class TestMain {


    public static void main(String[] args) {

        Car car1 = CarFactory.productCar("福来");
        Car car2 = CarFactory.productCar("红旗");

        assert car1 != null;
        car1.open();
        assert car2 != null;
        car2.start();

    }

}
