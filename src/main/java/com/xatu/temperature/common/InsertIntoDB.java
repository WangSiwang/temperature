package com.xatu.temperature.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 3 on 2019/1/3.
 */
public class InsertIntoDB {

    public static void main(String[] args) {
        File f = new File("F:\\项目\\温度检测项目\\temperature\\src\\main\\resources\\china_sites_20180101.csv");
        File b = new File("F:\\项目\\温度检测项目\\temperature\\src\\main\\resources\\站点列表-2018.11.08起.csv");

        try {
            if (f.exists()) {
                BufferedReader bf = new BufferedReader(new FileReader(f));
                BufferedReader bb = new BufferedReader(new FileReader(b));
                String line;
                List<String> titles = new ArrayList<>();
                while ((line = bb.readLine()) !=null) {
                    titles.add(line);
                }

                List<String> datas = new ArrayList<>();
                line = null;
                while ((line = bf.readLine()) !=null) {
                    for (String title : titles) {
                        if (line.contains(title.split(",")[0])) {
                            line = line.replaceAll(title.split(",")[0], title);
                            datas.add(line);
                            break;
                        }
                    }
                }
                for (String data : datas) {
                    String[] split = data.split(",");


                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
