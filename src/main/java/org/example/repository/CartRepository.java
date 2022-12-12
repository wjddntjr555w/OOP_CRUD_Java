package org.example.repository;

import org.example.domain.Cart;

import java.util.ArrayList;

public class CartRepository {


    private static ArrayList comArr = new ArrayList();
    private static ArrayList numArr = new ArrayList();
    public void addItem(int com, int num){
        comArr.add(com);
        numArr.add(num);
    }

    public Cart showItem(){
        return new Cart(comArr,numArr);
    }

    public void setNum(int num,int idx){
        int temp = (int) numArr.get(idx);
        numArr.set(idx,temp+num);
    }

    public void delItem() {
        comArr = new ArrayList();
        numArr = new ArrayList();
    }
}
