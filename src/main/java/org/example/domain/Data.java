package org.example.domain;

import java.util.ArrayList;

public class Data {

    private ArrayList dataNum;
    private ArrayList dataName;
    private ArrayList dataPrice;
    private ArrayList dataCount;

    public Data(ArrayList dataNum, ArrayList dataName, ArrayList dataPrice, ArrayList dataCount) {
        this.dataNum = dataNum;
        this.dataName = dataName;
        this.dataPrice = dataPrice;
        this.dataCount = dataCount;
    }

    public ArrayList getDataNum() {
        return dataNum;
    }

    public void setDataNum(ArrayList dataNum) {
        this.dataNum = dataNum;
    }

    public ArrayList getDataName() {
        return dataName;
    }

    public void setDataName(ArrayList dataName) {
        this.dataName = dataName;
    }

    public ArrayList getDataPrice() {
        return dataPrice;
    }

    public void setDataPrice(ArrayList dataPrice) {
        this.dataPrice = dataPrice;
    }

    public ArrayList getDataCount() {
        return dataCount;
    }

    public void setDataCount(ArrayList dataCount) {
        this.dataCount = dataCount;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dataNum=" + dataNum +
                ", dataName=" + dataName +
                ", dataPrice=" + dataPrice +
                ", dataCount=" + dataCount +
                '}';
    }
}
