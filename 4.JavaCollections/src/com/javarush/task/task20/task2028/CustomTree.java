package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>( "root" );
    }

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public void checkChildren() {
            availableToAddLeftChildren = leftChild == null;
            availableToAddRightChildren = rightChild == null;

            //аналогично
//            if (leftChild != null) availableToAddLeftChildren = false;
//            else availableToAddLeftChildren = true;
//            if (rightChild != null) availableToAddRightChildren = false;
//            else availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }


    public String getParent(String s) {
        if (s == null) return null;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer( root );

        Entry<String> currentEntry;
        while (!queue.isEmpty()) {
            currentEntry = queue.poll();
            if (currentEntry.elementName.equals( s )) {
                return currentEntry.parent.elementName;
            }
            if (!currentEntry.availableToAddLeftChildren) queue.offer( currentEntry.leftChild );

            if (!currentEntry.availableToAddRightChildren) queue.offer( currentEntry.rightChild );

        }
        return null;
    }

    @Override
    public int size() {
        int result = -1;
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer( root );

        Entry<String> currentEntry;
        while (!queue.isEmpty()) {
            currentEntry = queue.poll();
            result++;

            if (!currentEntry.availableToAddRightChildren) queue.offer( currentEntry.rightChild );
            if (!currentEntry.availableToAddLeftChildren) queue.offer( currentEntry.leftChild );
        }
        return result;
    }

    @Override
    public boolean add(String s) {
        if (s == null) return false;

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer( root );

        Entry<String> currentEntry;
        while (!queue.isEmpty()) {
            currentEntry = queue.poll();

            if (currentEntry.isAvailableToAddChildren()) {
                if (currentEntry.availableToAddLeftChildren) {
                    currentEntry.leftChild = new Entry<>( s );
                    currentEntry.leftChild.parent = currentEntry;
                    currentEntry.checkChildren();
                    return true;

                } else if (currentEntry.availableToAddRightChildren) {
                    currentEntry.rightChild = new Entry<>( s );
                    currentEntry.rightChild.parent = currentEntry;
                    currentEntry.checkChildren();
                    return true;
                }
            } else {
                queue.offer( currentEntry.leftChild );
                queue.offer( currentEntry.rightChild );
            }
        }
        return false;

    }

    public boolean remove(Object o) {
        if (o == null) throw new UnsupportedOperationException();
        String elem;
        try {
            elem = (String) o;
        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }

        Queue<Entry<String>> queue = new LinkedList<>();
        queue.offer( root );
        Entry<String> currentEntry;
        while (!queue.isEmpty()) {
            currentEntry = queue.poll();
            if (!currentEntry.availableToAddLeftChildren) {
                if (currentEntry.leftChild.elementName.equals( elem )) {
                    currentEntry.leftChild = null;
                    currentEntry.checkChildren();
                    return true;
                } else queue.offer( currentEntry.leftChild );
            }
            if (!currentEntry.availableToAddRightChildren) {
                if (currentEntry.rightChild.elementName.equals( elem )) {
                    currentEntry.rightChild = null;
                    currentEntry.checkChildren();
                    return true;
                } else queue.offer( currentEntry.rightChild );
            }
        }
        return false;

    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}