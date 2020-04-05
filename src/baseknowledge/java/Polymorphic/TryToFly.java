package baseknowledge.java.Polymorphic;

/**
 * @Author: shaoRongGang
 * @Description:
 * @Date:Created in 1:27 2020/3/19
 * @Modifid By:
 * @Version：
 */
public class TryToFly {
    public static void main(String[] args) {
        Person person = new MrGang();
        person.setAdult(true);
        person.setAge(18);
        person.setName("TangYan");
        person.eat(null);
        person.isInSky(new FlyStatus(189,"UFO"));
        person.sleep(new FlyStatus(200,"火箭"));


    }
}
