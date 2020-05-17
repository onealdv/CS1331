/**
* @author onealdv
* @version 1.0
*/
public abstract class AI {

    private boolean destructed;
    private Coordinates cannonTarget;
    private Coordinates secretHQ;
    /**
    * Constructor method for AI
    *
    * @param cannonTarget of type Coordinates acts as the initial set
    * coordinate of the "cannon"
    * @param secretHQ of type Coordinates is the coordinate of the secretHQ
    * of the AI
    */
    public AI(Coordinates cannonTarget, Coordinates secretHQ) {
        this.cannonTarget = cannonTarget;
        this.secretHQ = secretHQ;
    }
    /**
    * Getter method for variable destructed
    *
    * @return boolean value of destructed
    */
    public boolean getDestructed() {
        return destructed;
    }
    /**
    * Getter method for variable cannonTarget
    *
    * @return Coordinate value of cannonTarget
    */
    public Coordinates getCannonTarget() {
        return cannonTarget;
    }
    /**
    * Getter method for variable secretHQ
    *
    * @return Coordinate value of secretHQ
    */
    public Coordinates getSecretHQ() {
        return secretHQ;
    }
    /**
    * Getter method for variable cannonTarget
    *
    * @param newCoords is a Coordinate type to set new coordinates of the
    * cannon target if shouldSwapCannonTarget() is true
    * @return boolean true if shouldSwapCannonTarget() is true or if not true
    * or if shouldSelfDestruct() is true
    */
    public boolean swapCannonTarget(Coordinates newCoords) {
        if (!destructed && newCoords != cannonTarget) {
            if (shouldSwapCannonTarget()) {
                cannonTarget = newCoords;
                return true;
            } else if (shouldSelfDestruct()) {
                selfDestruct();
                return false;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    /**
    * selfDestruct() method, when called, sets destructed to true;
    */
    public void selfDestruct() {
        destructed = true;
    }
    /**
    * abstract method to determine if cannon target is swapped
    * @return true will swap cannon target
    */
    public abstract boolean shouldSwapCannonTarget();
    /**
    * abstract method which calls selfdestruct() when true
    * @return true will call selfdestruct()
    */
    public abstract boolean shouldSelfDestruct();
    /**
    * Overrides toString method for print statements
    *
    * @return new string to be printed
    */
    @Override
    public String toString() {
        return "Dr. Chipotle’s guacamole cannon is currently pointed at "
            + cannonTarget.toString();
    }
}
