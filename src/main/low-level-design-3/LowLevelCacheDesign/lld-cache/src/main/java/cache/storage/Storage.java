package cache2.storage;

import cache2.exceptions.NotFoundException;
import cache2.exceptions.StorageFullException;

public interface Storage<Key,Value> {

    void add(Key key, Value value) throws StorageFullException;

    void remove(Key key) throws NotFoundException;

    Value get(Key key) throws NotFoundException;

}
