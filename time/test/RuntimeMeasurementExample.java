package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class RuntimeMeasurementExample {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        // 指定要生成的随机整数数量
        int numberOfRandomIntegers = 50000;
        // 测量不同算法的速度
        long startTime, endTime, elapsedTime;
        // 生成随机整数并将其存储到文件中
        RandomNumberGenerator(numberOfRandomIntegers, "test.txt");
        // 从文件中读取随机整数
        ArrayList<Integer> randomIntegers = readRandomIntegersFromFile("test.txt");

        ArrayList<Integer> sortData = new ArrayList<>(randomIntegers);

        startTime = System.currentTimeMillis();
        algorithm.bubbleSort(sortData);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("冒泡排序耗时: " + elapsedTime + " 毫秒");

    }
    public static void RandomNumberGenerator(int numberOfRandomIntegers, String fileName){
        Random random = new Random();

        try {
            // 创建一个文件写入器
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // 循环生成随机整数并写入文件
            //生成并写入numberOfRandomIntegers个随机数
            for (int i = 0; i < numberOfRandomIntegers; i++) {
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
    // 从文件中读取随机整数并返回一个ArrayList
    private static ArrayList<Integer> readRandomIntegersFromFile(String fileName) {
        ArrayList<Integer> randomIntegers = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int number = Integer.parseInt(line);
                randomIntegers.add(number);
            }
            bufferedReader.close();
            System.out.println("随机整数已从文件中读取");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomIntegers;
    }
    }

