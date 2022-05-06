package 工厂模式.methodFactory;

/**
 * @author zxy
 * @Classname TestMain
 * @Date 2022/5/6 18:18
 */
public class TestMain {


    public static void main(String[] args) {

        FulaiCarFactory fulaiCarFactory = new FulaiCarFactory();
        RedQiCarFactory redQiCarFactory = new RedQiCarFactory();

        Car car1 = fulaiCarFactory.productCar();
        Car car2 = redQiCarFactory.productCar();
        assert car1 != null;
        car1.open();
        assert car2 != null;
        car2.start();

    }

}
