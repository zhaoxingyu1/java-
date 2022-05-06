package 工厂模式.simpleFactory;

import 工厂模式.methodFactory.Car;

/**
 * @author zxy
 * @Classname CarFactory
 * @Date 2022/5/6 18:16
 */
public class CarFactory {

    public static Car productCar(String name){

        if(name.equals("福来")){
            return new FulaiCar();
        }else if(name.equals("红旗")){
            return new RedQiCar();
        }else {
            return null;
        }
    }



}
