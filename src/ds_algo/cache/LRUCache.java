package ds_algo.cache;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringJoiner;

/*
https://medium.com/@krishankantsinghal/my-first-blog-on-medium-583159139237
 */
public class LRUCache {
    public static void main(String[] args) {
        Cache lruCache = new Cache(3);
        lruCache.offer(1);
        lruCache.offer(2);
        lruCache.offer(3);
        lruCache.offer(1);
        lruCache.offer(4);
        lruCache.offer(5);
        System.out.println("Cache: " + lruCache);
    }

    private static class Cache {
        private Deque<Integer> deque = new LinkedList<>();
        private Set<Integer> set = new HashSet<>();
        private final int size;

        public Cache(int size) {
            this.size = size;
        }

        public void offer(int n) {
            if (set.contains(n)) {
                deque.remove(n);
            } else {
                set.add(n);
                if (deque.size() == size) {
                    Integer last = deque.removeLast();
                    set.remove(last);
                }
            }

            deque.addFirst(n);
        }

        @Override
        public String toString() {
            StringJoiner stringJoiner = new StringJoiner(" ", "[", "]");
            for (Integer i : deque) {
                stringJoiner.add(String.valueOf(i));
            }
            return stringJoiner.toString();
        }
    }
}
