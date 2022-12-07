package org.example.service;

import org.example.domain.Item;
import org.example.repository.CartRepository;

import java.util.ArrayList;

public class CartService {



    public static void addCart(int com, int num) {
        Item itemList = CartRepository.showItem();
        ArrayList com1 = itemList.getCom();
        int flag = 0;
        for (int i = 0; i< com1.size(); i++){
            if(com1.get(i).equals(com)){
                flag = 1;
                CartRepository.setNum(num,i);
                break;
            }
        }
        if (flag == 0) {
            CartRepository.addItem(com, num);
        }
        // 중복되는 물품이 카트에 담기면 추가 ****
    }

    public static void showCart(){
        Item itemList = CartRepository.showItem();
        System.out.println(itemList.toString());
    }
}
