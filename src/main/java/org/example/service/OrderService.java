package org.example.service;

import org.example.domain.Data;
import org.example.domain.Item;
import org.example.repository.DataRepository;
import org.example.repository.CartRepository;

public class OrderService {
    public static boolean order() {

        Data data = DataRepository.showData();
        Item item = CartRepository.showItem();

        int sumOrder = 0;
        for(int i = 0; i< item.getCom().size(); i++) {
            for(int j = 0; j < data.getDataNum().size(); j++){
                if(item.getCom().get(i).equals(data.getDataNum().get(j))){
                    if(Integer.valueOf(String.valueOf(item.getNum().get(i))) > Integer.valueOf(String.valueOf(data.getDataCount().get(j)))){
                        // arraylist에서 바로 int로 변환****
                        return false;
                    }
                    else{
                        int temp = Integer.valueOf(String.valueOf(data.getDataCount().get(j))) - Integer.valueOf(String.valueOf(item.getNum().get(i)));
                        data.setDataCountIndex(data.getDataCount(),j,temp);
                        sumOrder += (Integer) item.getNum().get(i) * (Integer) data.getDataPrice().get(j);
                        System.out.println(data.getDataName().get(j) + " - "+item.getNum().get(i)+"개");
                    }
                }
            }
        }
        if(sumOrder<50000)
            sumOrder += 2500;
        System.out.println("총 결제 금액(배송비 포함) : "+ sumOrder);
        return true;
    }


}
