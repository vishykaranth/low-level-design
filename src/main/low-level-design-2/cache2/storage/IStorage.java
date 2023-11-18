package cache2.storage;

/**
 *
 * @created 02/05/2021
 */
public interface IStorage<Key, Value> {
    boolean add(Key key, Value value);

    void remove(Key key);

    Value get(Key key);

    Boolean isStorageFull();
}
