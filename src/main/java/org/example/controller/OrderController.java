package org.example.controller;

import org.example.domain.Cart;
import org.example.domain.CartItem;
import org.example.service.CartService;
import org.example.service.OrderService;

import java.util.Scanner;


public class OrderController {

    private static OrderService orderService = new OrderService();
    public static void quitCommand(){
        System.out.println("종료합니다.");
    }

    public static void orderCommand() {
        String com = null;
        String num = null;
        Boolean flag;
        CartItem cartItem = new CartItem();
        while(true){
            cartItem = orderService.productOrder();
            if (cartItem.getCom().compareTo(" ")==0 && cartItem.getNum().compareTo(" ")==0){
                flag = orderService.payment();
                break;
            }

            else if(isInteger(cartItem.getCom()) && isInteger(cartItem.getNum())){
                orderService.addCart(Integer.valueOf(cartItem.getCom()), Integer.valueOf(cartItem.getNum()));
            }
        }
    }

    private static boolean isInteger(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
