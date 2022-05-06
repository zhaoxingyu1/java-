package 建造者模式;

/**
 * @author zxy
 * @Classname Worker
 * @Date 2022/5/6 19:48
 */

// 服务员 工人 负责具体的实现
public class Worker extends Builder{

    private Product product;

    public Worker(){
        product = new Product();
    }


    @Override
    Builder buildA(String msg) {
        product.setBuildA(msg);
        return this;
    }

    @Override
    Builder buildB(String msg) {
        product.setBuildB(msg);
        return this;
    }

    @Override
    Builder buildC(String msg) {
        product.setBuildC(msg);
        return this;
    }

    @Override
    Builder buildD(String msg) {
        product.setBuildD(msg);
        return this;
    }

    @Override
    Product getProduct() {
        return product;
    }
}
