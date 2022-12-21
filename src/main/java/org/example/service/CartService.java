package org.example.service;

import org.example.domain.Cart;
import org.example.repository.CartRepository;

import java.util.ArrayList;

public class CartService {

    private CartRepository cartRepository = new CartRepository();

    public void addCart(int com, int num) {
        Cart cartList = cartRepository.showItem();
        ArrayList com1 = cartList.getCom();
        int flag = 0;
        for (int i = 0; i< com1.size(); i++){
            if(com1.get(i).equals(com)){
                // 중복된 물품이 들어오면 갯수를 추가
                flag = 1;
                cartRepository.setNum(num,i);
                break;
            }
        }
        if (flag == 0) {
            // 새로운 물품이 들어오면 항목 갯수 추가
            cartRepository.addItem(com, num);
        }

    }

    public void showCart(){
        cartRepository.showItem();
    }

    public void clearCart() {
        cartRepository.delItem();
    }
}
