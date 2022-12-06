package org.example.service;

import org.example.domain.Item;
import org.example.repository.KartRepository;

import java.util.ArrayList;
import java.util.List;

public class KartService {



    public static void addKart(int com, int num) {
        KartRepository.addItem(com,num);
        // 중복되는 물품이 카트에 담기면 추가 ****
    }

    public static void showKart(){
        Item itemList = KartRepository.showItem();
        System.out.println(itemList.toString());
    }
}
