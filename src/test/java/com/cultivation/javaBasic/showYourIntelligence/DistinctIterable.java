package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
    // <--start
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Iterator<E> iterator;
    private ArrayList<E> items;
    private int index;

    DistinctIterator(Iterator<E> iterator) {
        this.iterator = iterator;
        items = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        while (iterator.hasNext()) {
            E item = iterator.next();
            if (!items.contains(item)) {
                items.add(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public E next() {
        return items.get(index++);
    }
    // --end->
}