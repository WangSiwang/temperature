package com.xatu.temperature.common;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.beans.PropertyVetoException;
import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by 3 on 2019/1/3.
 */
public class InsertIntoDB {

    private static QueryRunner queryRunner;

    public static void main(String[] args) {
        String path = "C:\\Users\\pc\\Desktop\\站点_20180101-20181229\\站点_20180101-20181229";
        List<File> files = getAllCVSFile(path);
        for (File file : files) {
            List<String> strings = revertFile(file);
            HashMap<String, List<String>> formatData = getFormatData(strings);
            if (!insertIntoSQL(formatData)) {
                System.out.println(file.getName());
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
        return files;
    }

    //反转cvs的行列
    private static List<String> revertFile(File f) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            List<String> titles = new ArrayList<>();
            String line;
            while ((line = bf.readLine()) != null) {
                titles.add(line);
            }

            String[][] data = new String[4096][4096];
            for (int i = 0; i < titles.size(); i++) {
                String[] split = titles.get(i).split(",");
                for (int i1 = 0; i1 < split.length; i1++) {
                    data[i1][i] = split[i1];
                }
            }
            List<String> a = new ArrayList<>();
            for (String[] datum : data) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < datum.length; i++) {
                    if (datum[i] != null) {

                        sb.append(datum[i]);
                        if (i != datum.length - 1)
                            sb.append(",");
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
        if (formatData != null) {
            for (Map.Entry<String, List<String>> entry : formatData.entrySet()) {
                String key = entry.getKey();
                List<String> list = entry.getValue();
                Object[] objects = new Object[17];
                for (int i = 0; i < list.size(); i++) {
                    objects[i] = list.get(i).isEmpty() ? "-1" : list.get(i);
                }
                objects[15] = key.split("-")[0];
                String time = key.split("-")[1];
                objects[16] = time + "-" + key.split("-")[2];
                try {
                    getQueryRunner();
                    String sql = "INSERT INTO `hjjkdb`.`environment_glob_info_history` ( `AQI`, `PM2_5`, `PM2_5_24H`, `PM10`, `PM10_24H`, `SO2`, `S02_24H`, `NO2`, `NO2_24H`, `O3`, `O3_24H`,`O3_8H`, `O3_8H_24H`, `CO`, `CO_24H`,`type`, `datetime`)" +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
                    MapHandler rsh = new MapHandler();
                    Map<String, Object> insert = queryRunner.insert(sql, rsh, objects);
                    System.out.println(key + "-----" + insert);
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private static void getException(){
//        C3P0 和 JDBCUtil
//        com.mysql.jdbc.PreparedStatement.setTimestamp(int, java.sql.Timestamp)下的
//        this.parameterMetaData.metadata   报空指针异常；
        try {
            MapHandler rsh = new MapHandler();
            Object[] objects = new Object[17];
            objects[16] = new Timestamp(2018-1900,1-1,5,0,0,0,0);

            String sql = "INSERT INTO `hjjkdb`.`environment_glob_info_history` ( `AQI`, `PM2_5`, `PM2_5_24H`, `PM10`, `PM10_24H`, `SO2`, `S02_24H`, `NO2`, `NO2_24H`, `O3`, `O3_24H`,`O3_8H`, `O3_8H_24H`, `CO`, `CO_24H`,`type`, `datetime`)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            Map<String, Object> insert = queryRunner.insert(sql, rsh, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                        hours = line;
                    }
                    if (i==0){
                        dates=line;
                    }
                    for (String title : titles) {
                        if (line.contains(title.split(",")[0])) {
                            datas.add(line);
                            break;
                        }
                    }
                }
                if (hours==null){
                    System.out.println();
                }
                if (dates != null && hours!=null) {
                    String[] dateSplite = dates.split(",");
                    String[] hourSplite = hours.split(",");

                    HashMap<String, List<String>> result = new HashMap<>();

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
                            String key = type + "-" + date + "-" + hour;
                            if (result.containsKey(key)) {
                                List<String> strings = result.get(key);
                                strings.add(data);
                            } else {
                                ArrayList<String> strings = new ArrayList<>();
                                strings.add(data);
                                result.put(key, strings);
                            }
                        }
                    }
                    return result;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static void getQueryRunner() {
        if (queryRunner == null) {
            try {
                //第一步：创建连接池核心工具类
                ComboPooledDataSource dataSource = new ComboPooledDataSource();
                //第二步：连接池，url，驱动，账号，密码，初始连接数，最大连接数
                dataSource.setJdbcUrl("jdbc:mysql://140.143.98.65:3306/hjjkdb");//设置url
                dataSource.setDriverClass("com.mysql.jdbc.Driver");//设置驱动
                dataSource.setUser("mysql");//mysql的账号
                dataSource.setPassword("913043599");//mysql的密码
                dataSource.setInitialPoolSize(6);//初始连接数，即初始化6个连接
                dataSource.setMaxPoolSize(50);//最大连接数，即最大的连接数是50
                dataSource.setMaxIdleTime(60);//最大空闲时间
                //第三步：从连接池对象中获取数据库连接
                queryRunner = new QueryRunner(dataSource);
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }
    }
}
