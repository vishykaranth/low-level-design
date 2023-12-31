package cache2.policy;

/**
 * 
 * @created 02/05/2021
 */
public interface IEvictionPolicy<Key> {
    void keyAccessed(Key key);

    Key evictKey();
}
