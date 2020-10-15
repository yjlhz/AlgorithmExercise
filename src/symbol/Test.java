package symbol;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        double[] arr = {10,10,10,10};

        double t1=0;
        double t2=0;
        double t3=0;
        double t4=0;
        for (int i = 1;i<=100;i++){
            t1=0.25*(30+40+arr[1]+arr[2]);
            t4=0.25*(arr[1]+arr[2]+5+10);
            t2=0.25*(30+arr[0]+arr[3]+20);
            t3=0.25*(arr[0]+15+10+arr[3]);
            arr[0]=t1;
            arr[1]=t2;
            arr[2]=t3;
            arr[3]=t4;
            System.out.println("第"+i+"次迭代的t1:"+t1);
            System.out.println("第"+i+"次迭代的t2:"+t2);
            System.out.println("第"+i+"次迭代的t3:"+t3);
            System.out.println("第"+i+"次迭代的t4:"+t4);
        }
    }
}
