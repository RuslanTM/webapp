package lesson1;

/**
 * Aser
 * 11.05.2015
 */
public class RaceCar extends AbstractCar {
    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println("Something custom");
    }

    RaceCar() {
        speed = 200;
    }
public double getEngineVolume() {
        return 3.5;
    }
}
