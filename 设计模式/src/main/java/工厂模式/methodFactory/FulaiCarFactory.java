package 工厂模式.methodFactory;

/**
 * @author zxy
 * @Classname FulaiCarFactory
 * @Date 2022/5/6 18:33
 */
public class FulaiCarFactory implements CarFactor{

    @Override
    public Car productCar() {
        return new FulaiCar();
    }
}
