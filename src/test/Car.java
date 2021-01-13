package test;

public class Car extends Thread{
    String name = "";
    private Lighter lighter;
    String carState = "";
    public Car(String name,Lighter l,String carState){
        this.name = name;
        this.lighter = l;
        this.carState = carState;
    }
    public void run(){
        if (lighter.state.equals("straight") && carState.equals("straight")){
            System.out.println(this.name+":可以通过!");
        }else if (lighter.state.equals("right") && carState.equals("right")){
            System.out.println(this.name+":可以通过!");
        }else if (lighter.state.equals("left") && carState.equals("left")){
            System.out.println(this.name+":可以通过!");
        }else if (lighter.state.equals("green") || carState.equals("right")){
            System.out.println(this.name+":可以通过!");
        }else {
            System.out.println(this.name+":无法通过!");
        }
    }
}
