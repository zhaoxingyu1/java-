package 建造者模式;

/**
 * @author zxy
 * @Classname Builder
 * @Date 2022/5/6 19:44
 */

// 抽象的建造者:方法
public abstract class Builder {


    abstract Builder buildA(String msg);  // 可乐
    abstract Builder buildB(String msg);  // 汉堡
    abstract Builder buildC(String msg);  // 鸡排
    abstract Builder buildD(String msg);  // 鸡腿

    abstract Product getProduct();

}
