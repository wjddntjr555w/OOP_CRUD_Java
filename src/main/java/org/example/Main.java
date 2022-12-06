package org.example;

import org.example.controller.OrderController;
import org.example.domain.Data;
import org.example.repository.DataRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String com;

        //DB Load
        DataRepository dataRepository = new DataRepository();
        dataRepository.dataLoad();

        while(true){
            System.out.println("Command >> [주문 : o, order ] [종료 : q, quit ]");
            System.out.print("input : ");
            com = sc.nextLine();
            if(com.compareTo("q") == 0 || com.compareTo("quit") == 0) {
                OrderController.quitCommand();
                break;
            }
            else if (com.compareTo("o") == 0 || com.compareTo("order") == 0) {
                OrderController.orderCommand();

                // service에서 전체 목록 불러오는 거

            }
            else{
                System.out.println("잘못된 입력이 들어왔습니다. 다시 입력해주세요.");
            }
        }
    }
}