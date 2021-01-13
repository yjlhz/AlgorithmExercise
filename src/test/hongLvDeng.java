package test;

public class hongLvDeng {
    public static void main(String[] args) {
        Lighter l = new Lighter();
        l.start();
        for (int i = 0; i < 10; i++) {
            Car c = new Car("car",l,"right");
            try {
                c.sleep(1000);
                c.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            Car c = new Car("car",l,"");
            try {
                c.sleep(1000);
                c.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
