package test;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入年月份：");
        String date = input.next();
        String[] dateStr = date.split("-");
        int year = Integer.parseInt(dateStr[0]);
        int month = Integer.parseInt(dateStr[1]);
        int data = Integer.parseInt(dateStr[2]);
        int sum = 0;

        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    sum = sum +31;
                    continue;
                case 4:
                case 6:
                case 9:
                case 11:
                    sum = sum + 30;
                    continue;
            }
        }
        if (year%4==0&&month>2) {
            sum = sum +29;
        }else if (month>2){
            sum = sum +28;
        }
        sum = sum + data;
        System.out.println("今天是"+year+"年的第"+sum+"天");
    }
}
