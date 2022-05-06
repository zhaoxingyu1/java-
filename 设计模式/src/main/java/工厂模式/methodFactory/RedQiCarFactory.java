package 工厂模式.methodFactory;

/**
 * @author zxy
 * @Classname RedQiCarFactory
 * @Date 2022/5/6 18:33
 */
public class RedQiCarFactory implements CarFactor{

    @Override
    public Car productCar() {
        return new RedQiCar();
    }
}
