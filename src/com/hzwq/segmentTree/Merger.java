package com.hzwq.segmentTree;

/**
 * 将两个数据融合，产生一个新的对应类型的数据
 * @param <E>
 */
public interface Merger<E> {
    E merger(E a, E b);
}
