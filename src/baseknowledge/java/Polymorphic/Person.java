package baseknowledge.java.Polymorphic;


import baseknowledge.java.Polymorphic.callback.Fly;

/**
 *
 */
public abstract class Person implements Fly<FlyStatus> {
    /**
     *年龄
     */
    private int age;

    /**
     * 名字
     */
    private String name;
    /**
     * 是否是成年人
     */
    private boolean isAdult;

    /**
     * 性别：男，女，不男不女
     */
    private String gentle;
    // 标签
    public String tag;

    // 公共无参构造函数
    public Person() {

    }

    public Person(int age){
        this.age = age;
    }

    public Person(int age, String name, boolean isAdult) {
        this.age = age;
        this.name = name;
        this.isAdult = isAdult;
    }

    /**
     * 抽象方法：吃的行为
     * @param t 作为一个备用参数
     * @param <T>  泛型参数
     * @return 备用返回参数，用来作为行为的评判标准
     */
    public abstract <T> int eat(T t);

    /**
     * 睡觉得行为
     * @param t 相关的参数传入
     * @param <T>
     * @return
     */
    public abstract <T> int sleep(T t);

    /**
     * 进行运动
     * @param t 参与某一项运动
     * @param <T>
     * @return
     */
    private <T>int playBall(T t){
        System.out.println("playBall-Father" + t);
        return -1;
    }

    /**
     * 玩网络游戏的行为
     * @param t 行为的属性添加
     * @param <T>
     * @return
     */
    public <T>boolean playOnlineGame(T t){
        System.out.println("playOnlineGame-Father" + t);
        return true;
    }


    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public int getAge() {
        System.out.println("getAge-Father" + age);
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge-Father" + age);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", isAdult=" + isAdult +
                '}';
    }
}
