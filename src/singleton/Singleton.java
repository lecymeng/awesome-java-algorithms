package singleton;

/**
 * Created by weico on 16/3/23.
 */

/**
 * 题目：单例模式七种实现方式
 * 设计一个类，我们只能生成该类的一个实例
 */
public class Singleton {

    /**
     * 1.0
     * 单例模式,懒汉式,线程安全
     */
    public static class Singleton1{
        private final static Singleton1 INSTANCE = new Singleton1();
        private Singleton1(){

        }
        private static Singleton1 getInstance(){
            return INSTANCE;
        }
    }

    /**
     * 2.0
     * 单例模式,饿汉式,线程不安全
     */
    public static class Singleton2{
        private static Singleton2 instance = null;
        private Singleton2(){

        }

        public static Singleton2 getInstance() {
            if (instance == null){
                instance = new Singleton2();
            }
            return instance;
        }
    }

    /**
     * 3.0
     * 单例模式,饿汉式,线程不安全,多线程环境下效率不高-synchronized
     **/
    public static class Singleton3{
        private static Singleton3 instance = null;
        private Singleton3(){}
        public static synchronized Singleton3 getInstance(){
            if (instance == null){
                instance = new Singleton3();
            }
            return instance;
        }
    }

    /**
     * 4.0
     * 单例模式,饿汉式,变种-线程不安全
     *
     * 静态代码块
     **/
    public static class Singleton4{
        private static Singleton4 instance = null;
        static {
            instance = new Singleton4();
        }
        private Singleton4(){

        }
        public static Singleton4 getInstance(){
            return instance;
        }
    }

    /**
     * 5.0
     * 单例模式,使用静态内部类,线程安全[推荐]
     *
     * 静态内部类（构造函数不需要外部参数时）
     **/
    private static class Singleton5{
        private final static class SingletonHolder{
            private static final Singleton5 INSTANCE = new Singleton5();
        }
        private Singleton5(){

        }
        public static Singleton5 getInstance(){
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 6.0
     * 静态内部类,枚举方式,线程安全[推荐]
     **/
    public enum Singleton6{
        INSTANCE;
        public void whateverMethod(){

        }
    }

    /**
     * 7.0
     * 静态内部类,使用双重校验锁,线程安全[推荐]
     **/
    public static class Singleton7{
        private volatile static Singleton7 instance = null;
        private Singleton7(){}
        public static Singleton7 getInstance(){
            if (instance == null) {
                synchronized (Singleton7.class){
                    if (instance == null){
                        instance = new Singleton7();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());
        System.out.println(Singleton6.INSTANCE == Singleton6.INSTANCE);
        System.out.println(Singleton7.getInstance() == Singleton7.getInstance());
    }
}
