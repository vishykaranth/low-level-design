package cache.eviction;

import cache.exception.KeyNotFoundException;
import cache.model.Bucket;

import java.util.Map;

public interface IEvictionStrategy<K,V> {
    public V get(Map<K, Bucket<K,V>> map, K key) throws KeyNotFoundException;
    public void put(Map<K, Bucket<K,V>> map, K Key, V value);
}
