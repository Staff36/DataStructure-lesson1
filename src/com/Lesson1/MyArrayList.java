package com.Lesson1;

import java.util.Arrays;

public class MyArrayList <T extends Comparable <? super T>> implements MyArray<T>{
    protected T[] data;
    protected int size;
    protected static final int DEFAULT_CAPACITY=8;


    @SuppressWarnings("Unchecked")
    public MyArrayList(int initialCapacity){
    data= (T[]) new Comparable[initialCapacity];
    }
    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T value) {
        checkAndGrowArraySize();
        data[size++]=value;
    }

    protected void checkAndGrowArraySize() {
        if (data.length==size){
            data= Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size==0? 1:size*2;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index<0||index>=size){
            String errMsg= String.format("Incorrect index:%d max value is %d", index, size - 1);
            throw new ArrayIndexOutOfBoundsException(errMsg);
        }
    }

    @Override
    public boolean remove(T value) {
        return remove(indexOf(value))!=null;
    }
    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedValue = data[index];
       if (size-index-1>=0)
        System.arraycopy(data,index+1,data,index,size-index-1);
        data[--size]=null;
        return removedValue;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value)!=-1;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i <data.length ; i++) {
            if (data[i]==value){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size-1-i; j++) {
                if (data[j].compareTo(data[j+1])>0){
                    swap(j,j+1);
                }

            }
        }
    }



    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex=i;
            for (int j = i+1; j < size; j++) {
                if (data[j].compareTo(data[minIndex])<0){
                    minIndex=j;
                }
            }
            swap(minIndex,i);
        }
    }


    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            T temp=data[i];
            int index=i;
            while (index>0&&data[index-1].compareTo(temp)>=0){
                data[index]=data[index-1];
                index--;
            }
            data[index]=temp;
        }
    }
    private void swap(int indexA, int indexB) {
        T temp= data[indexA];
        data[indexA]=data[indexB];
        data[indexB]=temp;
    }
    @Override
    public String toString() {
        StringBuilder name= new StringBuilder(this.getClass().getSimpleName()+"= [");
        for (int i = 0; i < size-1; i++){
            name.append(data[i]+", ");
        }
        name.append(data[size-1]+"]");
        return name.toString();
    }
}
