package baseknowledge.java.Polymorphic.callback;

/**
 * @Author:shaoronggang
 * @Description: 定义了一类飞行的行为
 * @Date:Created in 1:00 2020/3/19
 * @Modifid By:
 */
public interface Fly<T> {
    /**
     * 飞行速度
     */
     long speed = 0;

    /**
     * 在天上这种状态
     * @param t 这个可以定义成一个描述这个状态的具体信息内容
     * @return
     */
    boolean isInSky(T t);
}
