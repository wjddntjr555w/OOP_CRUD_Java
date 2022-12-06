package org.example.service;

import org.example.domain.Data;
import org.example.repository.DataRepository;

public class OrderService {
    public static boolean order() {

        Data temp = DataRepository.showData();
        System.out.println(temp.toString());
        return true;
    }
}
