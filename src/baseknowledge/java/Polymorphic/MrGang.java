package baseknowledge.java.Polymorphic;

/**
 * @Author:shaoronggang
 * @Description:
 * @Date:Created in 0:59 2020/3/19
 * @Modifid By:
 */
public class MrGang extends Person {


    public MrGang() {

    }

    @Override
    public <T> boolean playOnlineGame(T t) {
        System.out.println("playOnlineGame" + t);
        return true;
    }


    @Override
    public <T> int eat(T t) {
        System.out.println("eat:" + this.getAge());
        return 0;
    }

    @Override
    public <T> int sleep(T t) {
        System.out.println("sleep:" + t);
        return 0;
    }

    @Override
    public boolean isInSky(FlyStatus flyStatus) {
        System.out.println("isInSky高度；:" + flyStatus.getHeight()
        +" 使用的工具："+ flyStatus.getFlyTool());
        return false;
    }
}
