package cache2.policies;

import cache2.exceptions.InvalidElementException;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key) throws InvalidElementException;

    /**
     * Evict key from eviction policy and return it.
     */
    Key evictKey();
}
