import java.util.Random;
/**
* @author onealdv
* @version 1.0
*/
public class RandomAI extends AI {

    private static final Random randomizer = new Random();
    /**
    * Constructor for RandomAI class
    *
    * @param cannonTarget coordinate of the cannontarget
    * @param secretHQ is the coordinate of the secretHQ location
    */
    public RandomAI(Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
    }
    /**
    * Override abstract method shouldSwapCannonTarget() in AI
    *
    * @return true with 50% probability or false with 50% probability
    */
    @Override
    public boolean shouldSwapCannonTarget() {
        return randomizer.nextInt(100) < 50;
    }
    /**
    * Override abstract method shouldSelfDestruct() in AI
    *
    * @return true with 50% probability or false with 50% probability
    */
    @Override
    public boolean shouldSelfDestruct() {
        return randomizer.nextInt(100) < 50;
    }
}
