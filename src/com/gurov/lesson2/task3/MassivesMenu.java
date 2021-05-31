package com.gurov.lesson2.task3;

import java.util.Arrays;
import java.util.Scanner;

public class MassivesMenu {

    public static void main(String[] args){

        MassivesMenu app = new MassivesMenu();
        app.Menu();//application start in Menu() method
    }

    public static void Menu(){

        try{
            Scanner in = new Scanner(System.in);
            System.out.print("Enter the number of elements: ");
            int numberElements = in.nextInt();
            if (numberElements < 1 || numberElements > Integer.MAX_VALUE-1)
                throw new Exception("Wrong! The number of elements must be from 1 to 2147483646");
            try{
                System.out.print("Enter a range of element values (from 1 to 100 and from < to): ");
                int minValue = in.nextInt();
                int maxValue = in.nextInt();
                if (notRange(minValue) || (notRange(maxValue)) || (minValue > maxValue))
                    throw new Exception("Wrong! The range of element values must be: from 1 to 100 and from < to");
                int[] masElements = GenerateMas(numberElements,minValue,maxValue);
                //System.out.printf("Source massive: %s\n", Arrays.toString(masElements));
                try{
                    System.out.print("Enter the element you want to search for: ");
                    final int KEY = in.nextInt();
                    if (notRange(KEY))
                        throw new Exception("Wrong! The element must be from 1 to 100");
                    Arrays.sort(masElements);
                    //System.out.printf("Sorted massive received: %s\n", Arrays.toString(masElements));
                    SearchElement searchIterate = new SearchElement(masElements,KEY);
                    long timeStart;
                    long timeFinish;
                    int index;
                    //Start Search Iterate
                    timeStart = System.currentTimeMillis();
                    index = searchIterate.SearchIterate();
                    timeFinish = System.currentTimeMillis();
                    //Finish Search Iterate
                    Display(index,masElements,timeStart,timeFinish);
                    SearchElement searchBinary = new SearchElement(masElements,KEY);
                    //Start Search Binary
                    timeStart = System.currentTimeMillis();
                    index = searchBinary.SearchBinary();
                    timeFinish = System.currentTimeMillis();
                    //Finish Search Binary
                    Display(index,masElements,timeStart,timeFinish);
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static boolean notRange(int element){

        return !((element > 1) && (element < 100));
    }

    public static int[] GenerateMas(int numberElements,int minValue,int maxValue){

        int[] mas = new int[numberElements];
        for (int i=0;i<numberElements;i++)
            mas[i] = (int)(minValue+Math.random()*(maxValue-minValue));
        return mas;
    }

    public static void Display(int index,int[] masElements,long timeStart,long timeFinish){

        if (index >= 0)
            System.out.printf("Element found: massive[%d]=%d, running time: %d\n",index+1,masElements[index],timeFinish-timeStart);
        else
            System.out.println("Element not found");
    }
}
