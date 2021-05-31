package com.gurov.lesson2.task3;

public class SearchElement {

    private int[] masElements;
    private final int KEY;

    SearchElement(int[] masElements,int KEY){

        this.masElements = masElements;
        this.KEY = KEY;
    }

    public int SearchIterate(){

        for (int i=0;i < masElements.length;i++)
            if (KEY == masElements[i])
                return i;
        return -1;
    }

    public int SearchBinary(){

        return SearchBinaryRecursion(0,masElements.length);
    }

    private int SearchBinaryRecursion(int first,int last){

        int middle = (first + (last - first)/2);
        if (KEY == masElements[middle])
            return middle;
        if (first != last){
            if (KEY < masElements[middle])
                return SearchBinaryRecursion(first, middle);
            else
                return SearchBinaryRecursion(middle, last);
        }
        else
            return -1;
    }
}
