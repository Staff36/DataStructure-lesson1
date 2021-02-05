package com.Lesson1;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> arrayListForBubleSort= new MyArrayList<>();
        MyArrayList<Integer> arrayListForSelectSort= new MyArrayList<>();
        MyArrayList<Integer> arrayListForInsertSort= new MyArrayList<>();
        for (int i = 10000; i >0; i--) {
            arrayListForBubleSort.add(i);
            arrayListForSelectSort.add(i);
            arrayListForInsertSort.add(i);
        }
        double timeOfBubbleSorting=sortAndGetTimeOfSort(arrayListForBubleSort,TypeOfSort.BUBBLE);
        double timeOfSelectSorting=sortAndGetTimeOfSort(arrayListForSelectSort,TypeOfSort.SELECT);
        double timeOfInsertSorting=sortAndGetTimeOfSort(arrayListForInsertSort,TypeOfSort.INSERT);

        System.out.println("Time of BUBBLE sort is "+timeOfBubbleSorting+" miliseconds");
        System.out.println("Time of SELECT sort is "+timeOfSelectSorting+" miliseconds");
        System.out.println("Time of INSERT sort is "+timeOfInsertSorting+" miliseconds");

    }

    public static double sortAndGetTimeOfSort(MyArrayList myArrayList, TypeOfSort typeOfSort){
        double startTime=System.currentTimeMillis();
        switch (typeOfSort){
            case BUBBLE:
                myArrayList.sortBubble();
                break;
            case INSERT:
                myArrayList.sortInsert();
                break;
            case SELECT:
                myArrayList.sortSelect();
                break;
        }
        double endTime=System.currentTimeMillis();
        return endTime-startTime;

    }
}
