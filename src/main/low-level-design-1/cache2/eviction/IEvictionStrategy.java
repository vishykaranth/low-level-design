package cache2.eviction;

import cache2.exception.KeyNotFoundException;
import cache2.model.Bucket;

import java.util.Map;

public interface IEvictionStrategy<K, V> {
    V get(Map<K, Bucket<K, V>> map, K key) throws KeyNotFoundException;

    void put(Map<K, Bucket<K, V>> map, K Key, V value);
}
