package cache2.util;

import cache2.exception.KeyNotFoundException;

public interface ICache<K, V> {
    public V get(K key) throws KeyNotFoundException;
    public void put(K key, V value);
}
