package 单例模式;

import javax.swing.plaf.BorderUIResource;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zxy
 * @Classname LazyMan
 * @Deprecated  懒汉式单例模式
 * @Date 2022/4/17 15:38
 */
public class LazyMan {

    private volatile static LazyMan lazyMan;

    private LazyMan(){
        System.out.println(Thread.currentThread().getName()+"ok");
    }

    public static LazyMan genInstance(){

        // 双重检测锁
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if (lazyMan==null){
                    lazyMan = new LazyMan();  // 不是原子性操作 加上可见性
                }
            }
        }

        return lazyMan;
    }

    /**
     * 测试多线程
     * @param args
     */
    public static void main(String[] args) throws Exception{
        // 多线程测试
        /*
            for (int i = 0; i < 10; i++) {
                new Thread(()->{
                    LazyMan.genInstance();
                }).start();
            }
         */
        // 反射破解
        LazyMan lazyMan1 = LazyMan.genInstance();
        // 反射过程
            //1.获取空参构造器
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
            // 1.1 如果是有参构造使用 获取
//        Constructor<LazyMan> declaredConstructor1 = LazyMan.class.getDeclaredConstructor(String.class, Integer.class);
        //2. 无视私有方法
        declaredConstructor.setAccessible(true);
        LazyMan lazyMan2 = declaredConstructor.newInstance();

        System.out.println(lazyMan1);
        System.out.println(lazyMan2);
        System.out.println(lazyMan1==lazyMan2);

    }


}
