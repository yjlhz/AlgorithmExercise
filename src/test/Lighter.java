package test;

public class Lighter extends Thread{
    public String state;//状态
    public void run(){
        while (true){
            try {
                state = "straight";
                System.out.println("直行可通过");
                Thread.sleep(5000);
                state = "right";
                System.out.println("可以右转");
                Thread.sleep(5000);
                state = "left";
                System.out.println("可以左转");
                Thread.sleep(5000);
                state = "green";
                System.out.println("绿灯，可以通过!");
                Thread.sleep(5000);
                state = "red";
                System.out.println("红灯，非右转无法通过!");
                Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
