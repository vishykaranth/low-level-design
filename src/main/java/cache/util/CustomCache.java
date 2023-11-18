package cache.util;

import cache.model.Bucket;
import cache.eviction.IEvictionStrategy;
import cache.eviction.RecentlyUsedEvictionStrategy;
import cache.exception.KeyNotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomCache<K,V> implements ICache<K,V> {

    private IEvictionStrategy<K,V> evictionStrategy;
    private int capacity;
    private Map<K, Bucket<K,V>> map;

    public CustomCache(int capacity) {
        this.capacity = capacity;
        this.map= new ConcurrentHashMap<>();
        this.evictionStrategy= new RecentlyUsedEvictionStrategy<K,V>(map, capacity);
    }

    @Override
    public V get(K key) throws KeyNotFoundException {
        return evictionStrategy.get(map, key);
    }

    @Override
    public void put(K key, V value) {
        evictionStrategy.put(map, key, value);
    }

    public void setEvictionStrategy(IEvictionStrategy<K,V> evictionStrategy) {
        this.evictionStrategy = evictionStrategy;
    }

    public Map<K, Bucket<K, V>> getMap() {
        return map;
    }

    public void setMap(Map<K, Bucket<K, V>> map) {
        this.map = map;
    }
}
