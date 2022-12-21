package org.example.service;

import org.example.domain.CartItem;
import org.example.domain.Data;
import org.example.domain.Cart;
import org.example.repository.DataRepository;
import org.example.repository.CartRepository;

import java.util.Scanner;

public class OrderService {
    private static CartService cartService = new CartService();
    private static OrderService orderService = new OrderService();
    private static DataRepository dataRepository = new DataRepository();
    private static CartRepository cartRepository = new CartRepository();
    private static CartItem cartItem = new CartItem();
    public static void quit() {
        System.out.println("종료합니다.");
    }

    public static void quitCommand() {
    }

    public static void orderCommand() {
        while(true){
            cartItem = orderService.productOrder();
            if (cartItem.getCom().compareTo(" ")==0 && cartItem.getNum().compareTo(" ")==0){
                orderService.payment();
                break;
            }

            else if(isInteger(cartItem.getCom()) && isInteger(cartItem.getNum())){
                orderService.addCart(Integer.valueOf(cartItem.getCom()), Integer.valueOf(cartItem.getNum()));
            }
        }
    }

    public boolean order() {

        Data data = dataRepository.showData();
        Cart cart = cartRepository.showItem();

        int sumOrder = 0;
        System.out.println("--------------------------------");
        for(int i = 0; i< cart.getCom().size(); i++) {
            for (int j = 0; j < data.getDataNum().size(); j++) {
                if (cart.getCom().get(i).equals(data.getDataNum().get(j))) {
                    if (Integer.valueOf(String.valueOf(cart.getNum().get(i))) > Integer.valueOf(String.valueOf(data.getDataCount().get(j)))) {
                        // 값을 가져오도록
                        return false;
                    } else {
                        int temp = Integer.valueOf(String.valueOf(data.getDataCount().get(j))) - Integer.valueOf(String.valueOf(cart.getNum().get(i)));
                        data.setDataCountIndex(data.getDataCount(), j, temp);
                        sumOrder += (Integer) cart.getNum().get(i) * (Integer) data.getDataPrice().get(j);
                        System.out.println(data.getDataName().get(j) + " - " + cart.getNum().get(i) + "개");
                    }
                }
            }
        }
        System.out.println("--------------------------------");
        System.out.println("주문 금액 : "+ sumOrder +"원");
        if(sumOrder<50000) {
            System.out.println("배송비 : 2500원");
            sumOrder += 2500;
        }
        System.out.println("--------------------------------");
        System.out.println("지불 금액 : "+ sumOrder +"원");
        System.out.println("--------------------------------");
        return true;
    }

    public Boolean payment() {
        // 결제
        try{
            if(order() == false) {
                throw new Exception("SoldOutException");
            }
        }catch(Exception e){
            System.out.println("SoldOutException, 주문한 상품량이 재고량보다 큽니다.");
            return false;
        }finally {
            cartService.clearCart();
            return true;
        }
    }

    public void addCart(int com, int num) {
        // 추가하고 새로운 결제 또 받기
        cartService.addCart(Integer.valueOf(com), Integer.valueOf(num));

        cartService.showCart();
    }

    public CartItem productOrder() {
        Scanner sc = new Scanner(System.in);
        CartItem cartItem = new CartItem();
        System.out.print("상품번호 : ");
        String com = sc.nextLine();
        System.out.print("개수 : ");
        String num = sc.nextLine();
        cartItem.setCom(com);
        cartItem.setNum(num);
        return cartItem;
    }

    public static boolean isInteger(String str) {
        // isInteger를 서비스와 레포지토리에서도 사용하는데... 합칠 방법?
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
