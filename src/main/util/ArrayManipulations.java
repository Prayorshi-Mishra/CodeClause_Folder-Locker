package main.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayManipulations {
    public static void reverseArrayOfInt(int[] rowIndexes){
        for(int i=0; i<rowIndexes.length/2; i++){
            int temp = rowIndexes[i];
            rowIndexes[i] = rowIndexes[rowIndexes.length-1-i];
            rowIndexes[rowIndexes.length-1-i] = temp;
        }
    }

    public static List<String> listReverse(List<String> dataList){
        List<String> temp = new ArrayList<>();
        for(int i=dataList.size()-1; i>=0; i--){
            temp.add(dataList.get(i));
        }
        return temp;
    }
}
