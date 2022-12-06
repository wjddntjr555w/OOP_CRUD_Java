package org.example.repository;

import org.example.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class KartRepository {


    private static ArrayList comArr = new ArrayList();
    private static ArrayList numArr = new ArrayList();
    public static void addItem(int com, int num){
        comArr.add(com);
        numArr.add(num);
    }

    public static Item showItem(){
        return new Item(comArr,numArr);
    }
}
