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
                flag = 1;
                cartRepository.setNum(num,i);
                break;
            }
        }
        if (flag == 0) {
            cartRepository.addItem(com, num);
        }
        // 중복되는 물품이 카트에 담기면 추가 ****
    }

    public void showCart(){
        Cart cartList = cartRepository.showItem();
    }

    public void clearCart() {
        cartRepository.delItem();
    }
}
