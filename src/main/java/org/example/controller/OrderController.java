package org.example.controller;

import org.example.service.KartService;
import org.example.service.OrderService;

import java.util.Scanner;


public class OrderController {

    public static void quitCommand(){
        System.out.println("종료합니다.");
    }

    public static void orderCommand() {
        Scanner sc = new Scanner(System.in);
        String com;
        String num;
        while(true){
            System.out.print("상품번호 : ");
            com = sc.nextLine();
            System.out.print("개수 : ");
            num = sc.nextLine();
            if (com.compareTo(" ")==0 && num.compareTo(" ")==0){
                // 결제
                try{
                    if(OrderService.order() == false) {
                        throw new Exception("SoldOutException");
                    }
                }catch(Exception e){
                    System.out.println("SoldOutException");
                    e.printStackTrace();
                }
            }
            else if(isInteger(com) && isInteger(num)){
                // 추가하고 새로운 결제 또 받기
                KartService.addKart(Integer.valueOf(com), Integer.valueOf(num));

                KartService.showKart();
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
