package java_problems.core_java.map;

public class TestMapImpl<K, V> implements TestMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private TestNode<K, V>[] table;
    private int size;

    public TestMapImpl() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        if (isEmpty()) {
            return null;
        }

        TestNode<K, V> head = table[hash(key)];

        TestNode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V put(K key, V value) {
        if (table == null) {
            table = new TestNode[DEFAULT_CAPACITY];
        }

        TestNode<K, V> head = table[hash(key)];
        if (head == null) {
            table[hash(key)] = new TestNode<>(key, value);
            size++;
            return null;
        }

        if (head.key == key) {
            V previousValue = head.value;
            head.value = value;
            return previousValue;
        }

        TestNode<K, V> prev = head;
        TestNode<K, V> current = head.next;

        while (current != null) {
            if (current.key.equals(key)) {
                V previousValue = current.value;
                current.value = value;
                return previousValue;
            } else {
                prev = current;
                current = current.next;
            }
        }

        prev.next = new TestNode<>(key, value);
        size++;
        return null;
    }

    @Override
    public V remove(K key) {
        if (isEmpty()) {
            return null;
        }

        TestNode<K, V> head = table[hash(key)];

        if (head == null) {
            return null;
        }

        if (head.key.equals(key)) {
            V deletedValue = head.value;
            table[hash(key)] = head.next;
            size--;
            return deletedValue;
        }

        TestNode<K, V> prev = head;
        TestNode<K, V> current = head.next;

        while (current != null) {
            if (current.key == key) {
                prev.next = current.next;
                size--;
                return current.value;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return null;
    }
}

class TestNode<K, V> {
    protected K key;
    protected V value;
    protected TestNode<K, V> next;

    public TestNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
