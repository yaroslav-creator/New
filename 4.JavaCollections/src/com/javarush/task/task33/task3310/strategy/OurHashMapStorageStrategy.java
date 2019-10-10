package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    public int hash(Long k) {
        return k.hashCode();
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key) {
        return table[indexFor( hash( key ), table.length )];
    }

    public void resize(int newCapacity) {
        Entry[] oldTable = table;
        int oldCapacity = oldTable.length;

        if (oldCapacity == (1 << 30)) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable = new Entry[newCapacity];
        transfer( newTable );
        table = newTable;
        threshold = (int) Math.min( newCapacity * loadFactor, (1 << 30) + 1 );

    }

    public void transfer(Entry[] newTable) {
        int newCapacity = newTable.length;

        for (Entry e : table) {
            while (e != null) {
                Entry next = e.next;
                int i = indexFor( e.hash, newCapacity );
                e.next = newTable[i];
                newTable[i] = e;
                e = next;
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {

        if ((size >= threshold) && (table[bucketIndex] != null)) {
            resize(2 * table.length);
            //hash = (null != key) ? hash(key) : 0;
            if (key != null)
                hash = hash( key );
            else hash = 0;

            bucketIndex = indexFor(hash, table.length);
        }
        createEntry(hash, key, value, bucketIndex);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        Entry e = table[bucketIndex];
        table[bucketIndex] = new Entry( hash, key, value, e );
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry( key ) != null;
    }

    @Override
    public boolean containsValue(String value) {
        if (value == null)
            return false;

        for (Entry table : table) {
            for (Entry e = table; e != null; e = e.next)
                if (value.equals( e.value ))
                    return true;
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        addEntry( hash( key ), key, value, indexFor( hash( key ), this.table.length ) );
    }

    @Override
    public Long getKey(String value) {
        if (value == null)
            return 0L;

        for (Entry table : this.table) {
            for (Entry e = table; e != null; e = e.next)
                if (value.equals( e.value ))
                    return table.getKey();
        }
        return null;
    }

    @Override
    public String getValue(Long key) {
        if (getEntry( key ) == null)
            return null;
        else
            return getEntry( key ).getValue();
    }
}
