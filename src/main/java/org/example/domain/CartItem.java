package org.example.domain;

public class CartItem {

    private String com;
    private String num;

    public CartItem(String com, String num) {
        this.com = com;
        this.num = num;
    }

    public CartItem() {

    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
