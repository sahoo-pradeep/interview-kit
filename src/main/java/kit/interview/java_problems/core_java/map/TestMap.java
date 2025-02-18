package kit.interview.java_problems.core_java.map;

public interface TestMap<K, V> {
    /**
     * Size of map
     */
    int size();

    /**
     * Checks if map is empty
     */
    boolean isEmpty();

    /**
     * Get value corresponding to key
     * Returns null if there is no such key
     */
    V get(K key);

    /**
     * Checks if key is present in map
     */
    boolean containsKey(K key);

    /**
     * insert or update key, value in map
     * returns previous stored value on update
     */
    V put(K key, V value);

    /**
     * removes entry with given key
     * returns the value of removed key.
     * returns null if key is not present.
     */
    V remove(K key);
}