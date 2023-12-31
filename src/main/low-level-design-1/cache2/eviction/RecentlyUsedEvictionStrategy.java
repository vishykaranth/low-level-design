package cache2.eviction;

import cache2.exception.KeyNotFoundException;
import cache2.model.Bucket;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class RecentlyUsedEvictionStrategy<K, V> implements IEvictionStrategy<K, V> {
    private Deque<Bucket<K, V>> queue;
    private int capacity;

    public RecentlyUsedEvictionStrategy(Map<K, Bucket<K, V>> map, int capacity) {
        List<Bucket<K, V>> list = new ArrayList<>(map.values());
        list.sort((e1, e2) -> e1.getUsedOn().compareTo(e2.getUsedOn()) > 0 ? 1 : -1);

        this.queue = new LinkedBlockingDeque<>();
        queue.addAll(list);
        this.capacity = capacity;
    }

    @Override
    public V get(Map<K, Bucket<K, V>> map, K key) throws KeyNotFoundException {
        /**
         * s1 : inc used on, hit
         * s2 : update queue
         */

        if (!map.containsKey(key)) {
            throw new KeyNotFoundException(key.toString());
        }

        //TODO:  Abstract this as UpdateMeta
        Bucket<K, V> bucket = map.get(key);
        bucket.setHit(bucket.getHit() + 1);
        bucket.setUsedOn(Date.from(Instant.now()));

        queue.remove(bucket);
        queue.addFirst(bucket);


        return bucket.getValue();
    }

    @Override
    public void put(Map<K, Bucket<K, V>> map, K key, V value) {
        if (map.containsKey(key)) {
            return;
        }

        /**
         * s1: check capacity
         * s2: evict if valid
         * s3: then add
         */

        //Check Capacity & Evict if above capacity
        if (map.size() >= capacity) {//evict
            evict(map);
        }

        //adding in bucket
        Bucket<K, V> bucket = new Bucket<>(key, value);
        queue.addFirst(bucket);
        map.put(key, bucket);
    }

    private void evict(Map<K, Bucket<K, V>> map) {
        Bucket<K, V> bucket = queue.removeLast();
        System.out.println("Evicting key: " + bucket.getKey());
        map.remove(bucket.getKey());
    }
}
