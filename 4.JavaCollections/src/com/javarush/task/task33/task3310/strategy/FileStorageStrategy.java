package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    private int size;
    long maxBucketSize;

    public long getMaxBucketSize() {
        return maxBucketSize;
    }

    public void setMaxBucketSize(long maxBucketSize) {
        this.maxBucketSize = maxBucketSize;
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public int hash(Long k) {
        return k.hashCode();
    }

    public int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    public Entry getEntry(Long key) {
        int hash = key == null ? 0 : hash( key );

        Entry e = table[indexFor( hash, table.length )].getEntry();
        while (e != null) {

            if (e.hash == hash && (e.key).equals( key ))
                return e;
            e = e.next;
        }

        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer( newTable );
        table = newTable;
    }

    public void transfer(FileBucket[] newTable) {
        int newCapacity = newTable.length;

        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;

            Entry entry = table[i].getEntry();
            while (entry != null) {
                Entry next = entry.next;

                int indexFor = indexFor( entry.hash, newCapacity );
                entry.next = newTable[indexFor].getEntry();

                newTable[indexFor].putEntry( entry );
                entry = next;
            }
            table[i].remove();
            table[i] = null;

        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry( new Entry( hash, key, value, entry ) );

        if (table[bucketIndex].getFileSize() > bucketSizeLimit) {
            resize( 2 * table.length );
            size++;
        }
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry( new Entry( hash, key, value, null ) );
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry( key ) != null;
    }

    @Override
    public boolean containsValue(String value) {

        for (FileBucket fileBucket : table) {
            if (fileBucket == null) continue;

            Entry e = fileBucket.getEntry();
            while (e != null) {
                if (value.equals( e.value ))
                    return true;
                e = e.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash( key );
        int i = indexFor( hash, table.length );

        if (table[i] == null) {
            createEntry( hash, key, value, i );
        } else {
            Entry e = table[i].getEntry();

            while (e != null) {
                if (e.hash == hash && (e.key).equals( key ))
                    e.value = value;
                e = e.next;
            }
            addEntry( hash, key, value, i );
        }
    }

    @Override
    public Long getKey(String value) {
        for (FileBucket fileBucket : table) {
            if (fileBucket == null) continue;

            for (Entry e = fileBucket.getEntry(); e != null; e = e.next)
                if (value.equals( e.value ))
                    return e.key;
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
