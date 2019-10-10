package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {


    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>( Math.max( (int) (collection.size() / .75f) + 1, 16 ) );
        addAll( collection );
    }

    public AmigoSet(int capacity) {
        map = new HashMap<>( capacity );
    }

    public AmigoSet(int initialCapacity, float loadFactor) {
        map = new HashMap<>( initialCapacity, loadFactor );
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet<E> newSet = (AmigoSet<E>) super.clone();
            newSet.map = (HashMap<E, Object>) map.clone();
            return newSet;

        } catch (Exception e) {
            throw new InternalError( e );
        }
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E e) {
        return map.put( e, PRESENT ) == null;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey( o );
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove( o );
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt( HashMapReflectionHelper.callHiddenMethod( map, "capacity" ) );
        oos.writeFloat( HashMapReflectionHelper.callHiddenMethod( map, "loadFactor" ) );

        oos.writeInt( map.size() );
        for( E e : map.keySet() ) {
            oos.writeObject( e );
        }
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();

        int capacity = ois.readInt();
        float loadFactor = ois.readFloat();
        int size = (int)ois.readInt();

        Set<E> set = new HashSet<>(  );

        for (int i = 0; i < size; i++){
            boolean add = set.add( (E) ois.readObject() );
        }
        map = new HashMap<>( capacity,loadFactor );
        for (E e : set){
            map.put( e, PRESENT );
        }

    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AmigoSet initialAmigoSet = new AmigoSet<>();

        for (int i = 0; i < 10; i++) {
            initialAmigoSet.add( i );
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( initialAmigoSet );

        ObjectInputStream ois = new ObjectInputStream( new ByteArrayInputStream( baos.toByteArray() ) );
        AmigoSet loadedAmigoSet = (AmigoSet) ois.readObject();

        System.out.println( initialAmigoSet.size() + " " + loadedAmigoSet.size() );
    }
}
