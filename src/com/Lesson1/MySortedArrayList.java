package com.Lesson1;

public class MySortedArrayList<T extends Comparable<? super T>> extends MyArrayList<T> {
    public MySortedArrayList(int initialCapacity) {
        data= (T[]) new Comparable[initialCapacity];
    }

    public MySortedArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(T value) {
        checkAndGrowArraySize();
        int index =size;
        for (int i = 0; i < size; i++) {
            if (data[i].compareTo(value)>0){
                index=i;
                break;
            }
        }
        if (index==size){
            data[size++]=value;

        }else {
            doInsert(value, index);
        }
    }

    private void doInsert(T value, int index) {
        System.arraycopy(data,index,data,index+1,size-index);
        data[index]=value;
        size++;
    }

    @Override
    public int indexOf(T value) {
        int low=0;
        int high=size-1;
        while (low<=high){
            int mid =(low+high)/2;
            if (data[mid].equals(value))
            return mid;
            else if (value.compareTo(data[mid])>0)
             low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}
