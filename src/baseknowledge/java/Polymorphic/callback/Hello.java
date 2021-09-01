package baseknowledge.java.Polymorphic.callback;

/**
 * 打招呼的接口
 * @param <T> 接口中使用了泛型
 */
public interface Hello<T> {
    void morning(T name);
}
