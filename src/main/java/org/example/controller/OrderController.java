package org.example.controller;

import java.util.Scanner;

import static java.util.Formatter.Conversion.isInteger;

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
                System.out.print("결제");
            }
            else if(isInteger(com) && isInteger(num)){
                // 추가하고 새로운 결제 또 받기
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
