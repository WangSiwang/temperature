package com.xatu.temperature.common;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 3 on 2019/1/3.
 */
public class Tools {

    public static void main(String[] args) {
        File f = new File("E:\\Idea_workspace\\temperature\\src\\main\\resources\\china_sites_20180101.csv");

        String path="C:\\Users\\pc\\Desktop\\站点_20180101-20181229\\站点_20180101-20181229";
        List<File> files = getAllCVSFile(path);
        for (File file : files) {
            List<String> strings = revertFile(file);
            HashMap<String, List<String>> formatData = getFormatData(strings);
            if(insertIntoSQL(formatData)){
                System.out.println(true);
            }
        }



    }
    //获得所有的cvs文件
    private static List<File> getAllCVSFile(String path) {
        File file = new File(path);
        ArrayList<File> files = new ArrayList<>();
        if (file.isDirectory()) {
            for (File file1 : file.listFiles()) {
                if (file1.getName().endsWith(".csv")) {
                    files.add(file1);
                }
            }
        }
        System.out.println();
        return files;
    }

    //反转cvs的行列
    private static List<String> revertFile(File f) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            List<String> titles = new ArrayList<>();
            String line;
            while ((line = bf.readLine()) !=null) {
                titles.add(line);
            }

            String[][] data = new String[4096][4096];
            for (int i = 0; i < titles.size(); i++) {
                String[] split = titles.get(i).split(",");
                for (int i1 = 0; i1 < split.length; i1++) {
                    data[i1][i] = split[i1];
                }
            }
            List<String> a= new ArrayList<>();
            for (String[] datum : data) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < datum.length; i++) {
                    if (datum[i] != null) {

                        sb.append(datum[i]);
                        if (i != datum.length - 1)
                            sb
                                    .append(",");
                    }
                }
                if (!sb.toString().trim().isEmpty()) {
                    a.add(sb.toString());
                }

            }
            data = null;
            return a;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //入库
    private static boolean insertIntoSQL(HashMap<String, List<String>> formatData) {
        System.out.println(formatData);
        return false;
    }

    //输入文本，获得格式化数据
    private static HashMap<String, List<String>> getFormatData(List<String> f) {
        File b = new File("E:\\Idea_workspace\\temperature\\src\\main\\resources\\站点列表-2018.11.08起.csv");
        try {
            if (b.exists()) {
                BufferedReader bb = new BufferedReader(new FileReader(b));
                String line;
                List<String> titles = new ArrayList<>();
                while ((line = bb.readLine()) !=null) {
                    titles.add(line);
                }

                List<String> datas = new ArrayList<>();
                line = null;
                String dates = null;
                String hours = null;
                for (int i = 0; i < f.size(); i++) {
                    line = f.get(i);
                    if (i==1){
                        System.out.println(f);
                        hours = line;
                    }
                    if (i==0){
                        System.out.println(line);
                        dates=line;
                    }
                    for (String title : titles) {
                        if (line.contains(title.split(",")[0])) {
                            datas.add(line);
                            break;
                        }
                    }
                }
                String[] dateSplite = dates.split(",");
                String[] hourSplite = hours.split(",");

                HashMap<String,List<String>> result= new HashMap<>();

                for (int i = 0; i < datas.size(); i++) {
                    String[] lineData = datas.get(i).split(",");
                    String type = null;
                    for (int i1 = 0; i1 < lineData.length; i1++) {
                        if (i1 == 0) {
                            type = lineData[i1];
                            continue;
                        }
                        String date = dateSplite[i1];
                        String hour = hourSplite[i1];
                        String data = lineData[i1];
                        String key = type+"-"+date+"-"+ hour;
                        if (result.containsKey(key)) {
                            List<String> strings = result.get(key);
                            strings.add(data);
                        }else {
                            ArrayList<String> strings = new ArrayList<>();
                            strings.add(data);
                            result.put(key,strings);
                        }
                    }
                }
                System.out.println();
                return result;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
