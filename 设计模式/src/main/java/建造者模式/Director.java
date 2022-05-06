package 建造者模式;

/**
 * @author zxy
 * @Classname Director
 * @Date 2022/5/6 19:53
 */

// 相当于顾客,指挥
public class Director {

    public static void main(String[] args) {

        Worker worker = new Worker();

        Product product = worker.getProduct();

        System.out.println(product);

        product = worker.buildA("哇哈哈").buildB("汉堡王").getProduct();
        System.out.println(product);

    }




}
