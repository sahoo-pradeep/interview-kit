package java;

import java.util.Objects;
import java.util.StringJoiner;

public class Q4HashMap {
    public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
        System.out.println("put(1, One): " + map.put("1", "One"));
        System.out.println("put(2, Two): " + map.put("2", "Two"));
        System.out.println("put(1, Ek): " + map.put("1", "Ek"));
        System.out.println("put(null,Null Value): " + map.put(null, "Null Value"));

        System.out.println();
        System.out.println("get(1): " + map.get("1"));
        System.out.println("get(2): " + map.get("2"));
        System.out.println("get(3): " + map.get("3"));
        System.out.println("get(null): " + map.get(null));

        System.out.println();
        System.out.println(map.size());

        System.out.println();
        System.out.println("containKey(1): " + map.containsKey("1"));
        System.out.println("containKey(10): " + map.containsKey("10"));
        System.out.println("containKey(null): " + map.containsKey(null));

        System.out.println("remove(2): " + map.remove("2"));
        System.out.println("remove(10): " + map.remove("10"));
        System.out.println(map);
    }
}


class MyHashMap<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; //16 (must be a power of two)
    private Node<K, V>[] table;
    private int size;

    public MyHashMap() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K key) {
        Node<K, V> node = getNode(Objects.hashCode(key), key);
        return node == null ? null : node.value;
    }

    private Node<K, V> getNode(int hash, K key) {
        if (table != null && table.length != 0) {
            int bucket = (table.length - 1) & hash;
            Node<K, V> current = table[bucket];
            while (current != null) {
                if (current.hash == hash && Objects.equals(current.key, key)) {
                    return current;
                } else {
                    current = current.next;
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return getNode(Objects.hashCode(key), key) != null;
    }

    // Return previous value if key already exists
    public V put(K key, V value) {
        return putVal(Objects.hashCode(key), key, value);
    }

    private V putVal(int hash, K key, V value) {
        // table is empty
        if (table == null || table.length == 0) {
            table = (Node<K, V>[]) new Node[DEFAULT_INITIAL_CAPACITY];
        }

        int bucket = (table.length - 1) & hash;

        // Bucket is empty
        if (table[bucket] == null) {
            table[bucket] = new Node<>(hash, key, value, null);
        } else {
            Node<K, V> previous = null;
            Node<K, V> current = table[bucket];

            while (current != null) {
                if (current.hash == hash && Objects.equals(current.key, key)) {
                    break;
                }
                previous = current;
                current = current.next;
            }

            // Reached end of list and didn't find key
            if (current == null) {
                previous.next = new Node<>(hash, key, value, null);
            } else {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
        }

        size++;
        return null;
    }

    // returns previous value associated with key
    public V remove(K key) {
        Node<K, V> node = removeNode(Objects.hashCode(key), key);
        return node == null ? null : node.value;
    }

    private Node<K, V> removeNode(int hash, K key) {
        if (table != null && table.length > 0) {
            int bucket = (table.length - 1) & hash;
            if (table[bucket] == null) {
                return null;
            }

            Node<K, V> previous = null;
            Node<K, V> current = table[bucket];

            while (current != null) {
                if (current.hash == hash && Objects.equals(current.key, key)) {
                    // Remove Node
                    if (previous == null) {
                        table[bucket] = null;
                    } else {
                        previous.next = current.next;
                    }
                    return current;
                }
                previous = current;
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        StringJoiner joiner = new StringJoiner(", ", "MyHashMap: [", "]");
        Node<K,V> node;

        for (Node<K,V> bucket: table){
            node = bucket;
            while (node != null){
                joiner.add(node.toString());
                node = node.next;
            }
        }

        return joiner.toString();
    }

    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + " -> " + value;
        }
    }
}
