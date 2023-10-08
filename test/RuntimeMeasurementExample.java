package test;

import java.io.*;
import java.util.Random;

public class RuntimeMeasurementExample {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        long startTime = System.currentTimeMillis();
        //测试时间的代码

        RandomNumberGenerator();
        fetch();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("程序执行时间：" + executionTime);
    }

    public static void RandomNumberGenerator(){
        Random random = new Random();

        String fileName = "test.txt";

        try {
            // 创建一个文件写入器
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // 循环生成随机整数并写入文件
            //生成并写入100个随机数
            for (int i = 0; i < 100; i++) {
                int randomNumber = random.nextInt(1000);//生成范围在0到999之间
                // 将随机整数转换为字符串并写入文件
                bufferedWriter.write(Integer.toString(randomNumber));
                bufferedWriter.newLine(); // 写入换行符以分隔每个整数
            }
            // 关闭文件写入器
            bufferedWriter.close();

            System.out.println("随机整数已写入文件: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void fetch() {
        try {
            String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "test.txt";

            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 处理每一行的数据
                System.out.println(line);
            }

            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    }

