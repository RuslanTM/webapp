package lesson1;

/**
 * Aser
 08.05.2015
 */
public class Main {
    public static void main(String[] args) {
        System.out.format("Hello %s! \n", args[0]);
        Car raceCar = new RaceCar();
        Car simpleCar = new SimpleCar();
        simpleCar.getDescription();
        raceCar.getDescription();


    }
}
