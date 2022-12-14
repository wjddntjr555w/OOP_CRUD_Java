package org.example.repository;

import org.example.domain.Data;
import org.example.service.OrderService;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataRepository {


    private static Data data = new Data(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

    public void dataLoad(){
        BufferedReader br = null;

        try{
            String path = DataRepository.class.getClassLoader().getResource("Data.csv").getPath();
            br = Files.newBufferedReader(Paths.get(path));
            //Charset.forName("UTF-8");
            String line = "";
            ArrayList tempNum = new ArrayList<>(),tempName = new ArrayList<>(),tempPrice= new ArrayList<>(),tempCount= new ArrayList<>();
            while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",");
                //배열에서 리스트 반환
                tmpList = Arrays.asList(array);
                System.out.println(tmpList);
//                ret.add(tmpList);
                if(OrderService.isInteger(array[0]) && OrderService.isInteger(array[2]) && OrderService.isInteger(array[3])) {
                    tempNum.add(Integer.valueOf(array[0]));
                    tempName.add(array[1]);
                    tempPrice.add(Integer.valueOf(array[2]));
                    tempCount.add(Integer.valueOf(array[3]));
                }
            }
            data.setDataNum(tempNum);
            data.setDataName(tempName);
            data.setDataPrice(tempPrice);
            data.setDataCount(tempCount);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public Data showData() {
        return new Data(data.getDataNum(),data.getDataName(),data.getDataPrice(),data.getDataCount());
    }

}
