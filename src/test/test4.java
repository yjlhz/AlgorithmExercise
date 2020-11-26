package test;

public class test4 {
    public static void main(String[] args) {
        for(int a=1;a<=4;a++) {
            if (4-a == 0){
                for(int c=1;c<=a*2-1;c++){
                    System.out.print("+");
                }
                System.out.println();
            }else{
                for(int b=1;b<=4-a;b++){
                    System.out.print(" ");
                }
                for(int c=1;c<=a*2-1;c++){
                    System.out.print("*");
                }
                System.out.println();
            }

        }
        for(int d=3;d>=1;d--) {
            for(int b=1;b<=4-d;b++){
                System.out.print(" ");
            }
            for(int c=4-d;c<=2+d;c++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
