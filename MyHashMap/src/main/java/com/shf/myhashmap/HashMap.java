package com.shf.myhashmap;

public class HashMap<K,V> implements Map<K,V>{
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put("悟空"+i, i);
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println(map.get("悟空"+i));
        }

        System.out.println(map.size());
    }

    private static int defaultLength = 16;
    private static double defaultLoader = 0.75;
    private Entry<K,V>[] table = null;
    private int size = 0;

    public HashMap() {
        this(defaultLength, defaultLoader);
    }

    public HashMap(int length, double loader) {
        defaultLength = length;
        defaultLoader = loader;
        table = new Entry[defaultLength];
    }

    @Override
    public V put(K k, V v) {
        size++;
        int index = hash(k);
        Entry<K,V> entry = table[index];
        if (entry == null) {
            table[index] = newEntry(k, v, null);
        } else {
            table[index] = newEntry(k, v, entry);
        }
        return table[index].getValue();
    }

    private Entry<K,V> newEntry(K k, V v, Entry<K,V> next) {
        return new Entry<>(k, v, next);
    }

    @Override
    public V get(K k) {
        int index = hash(k);
        if (table[index] == null) {
            return null;
        }
        return find(k, table[index]);
    }

    private V find(K k, Entry<K,V> entry) {
        if (k == entry.getKey() || k.equals(entry.getKey())) {
            return entry.getValue();
        } else {
            if (entry.next != null) {
                return find(k, entry.next);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    public int hash(K k) {
        int m = defaultLength;
        int i = k.hashCode() % m;
        return i > 0 ? i : -i;
    }

    class Entry<k,y> implements Map.Entry<K,V>{
        K k;
        V v;
        Entry<K,V> next;

        public Entry(K k, V v, Entry<K, V> next) {
            this.k = k;
            this.v= v;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
