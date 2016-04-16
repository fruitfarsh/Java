package Lambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class MyArrays {
    private static LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();
    private static LinkedList<String> stringLinkedList = new LinkedList<String>();

    private static ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
    private static ArrayList<String> stringArrayList = new ArrayList<String>();

    public static LinkedList<Integer> getLinkedListIntegerRandom(int lenght){
        integerLinkedList.clear();
        for (int i=0; i< lenght; i++){
            integerLinkedList.add(new Random().nextInt(lenght));
        }
        return integerLinkedList;
    }

    public static LinkedList<String> getLinkedListStringRandom(int lenght){
        stringLinkedList.clear();
        for (int i=0; i< lenght; i++){
            stringLinkedList.add(""+new Random().nextInt(lenght));
        }
        return stringLinkedList;
    }

    public static ArrayList<Integer> getArrayListIntegerRandom(int lenght){
        integerArrayList.clear();
        for (int i=0; i< lenght; i++){
            integerArrayList.add(new Random().nextInt(lenght));
        }
        return integerArrayList;
    }

    public static ArrayList<String> getArrayListStringRandom(int lenght){
        stringArrayList.clear();
        for (int i=0; i< lenght; i++){
            stringArrayList.add(""+new Random().nextInt(lenght));
        }
        return stringArrayList;
    }
}
