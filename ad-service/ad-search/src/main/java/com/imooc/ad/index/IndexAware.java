package com.imooc.ad.index;

/**
 * @Author: HongchaoLv
 * @Description:
 * @Date: Created in 10:04 2020/5/23
 * @Modified By:
 */
public interface IndexAware<K, V> {
    V get(K key);

    void add(K key, V value);

    void update(K key, V value);

    void delete(K key, V value);
}
