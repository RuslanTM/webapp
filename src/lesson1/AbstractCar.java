package lesson1;

/**
 * Aser
 * 11.05.2015
 */
public abstract class AbstractCar implements Car {
    protected int speed = 100;

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed + 20;
    }

    public void getDescription() {
        out("\n" + this.getClass().getSimpleName() + " (Speed: " + speed  +
        "and EngineVolume: " + getEngineVolume() + ")");
    }
    private void out(String str) {
        System.out.println(str);
    }
}
