package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

public class Entry implements Serializable {

    Long key;
    String value;
    Entry next;
    int hash;

    public Entry(int hash, Long key, String value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.hash = hash;
    }

    public Long getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash( key, value );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Entry entry = (Entry) obj;
        return Objects.equals( key, entry.key ) &&
                Objects.equals( value, entry.value );
    }

    @Override
    public String toString() {
        return new String( key + "=" + value );
    }
}
