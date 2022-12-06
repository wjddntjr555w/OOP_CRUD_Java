package org.example.domain;

import java.util.ArrayList;

public final class Item{
    private ArrayList com;
    private ArrayList num;

    public Item(ArrayList com, ArrayList num) {
        this.com = com;
        this.num = num;
    }

    public ArrayList getCom() {
        return com;
    }

    public ArrayList getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Item{" +
                "com=" + com +
                ", num=" + num +
                '}';
    }


}