package com.Lesson1;

public interface MyArray <T>{
    void add(T value);
    T get(int index);
    boolean remove(T value);
    T remove(int index);
    boolean contains(T value);
    boolean isEmpty();
    int size();
    void display();
    int indexOf(T value);
    void sortBubble();
    void sortSelect();
    void sortInsert();

}
