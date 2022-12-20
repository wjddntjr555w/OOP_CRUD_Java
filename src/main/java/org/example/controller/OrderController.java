package org.example.controller;

import org.example.domain.Cart;
import org.example.domain.CartItem;
import org.example.service.CartService;
import org.example.service.OrderService;

import java.util.Scanner;


public class OrderController {

    private static OrderService orderService = new OrderService();

    public static void quitCommand(){
        OrderService.quitCommand();
    }

    public static void orderCommand() {
        OrderService.orderCommand();
    }


}
