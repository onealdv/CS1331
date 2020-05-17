/**
* @author osuwandi3
* @version 1.0
*
* Why is this not good style?
* Bad design. Means that if there are new derived types added, the
* decision making code with instanceof needs to be updated.
*
* What changes could we make to AI and it’s subclasses to avoid using
* instanceof?
*
*/
public class DoctorCS {

    private AI ai;
    private final String secretIdentity;
    private final int jlaid;
    private boolean safe;
    /**
    * Getter method for variable jlaid
    *
    * @return int value of jlaid
    */
    public int getJlaid() {
        return jlaid;
    }
    /**
    * Constructor for Coordinates object
    *
    * @param ai  is the AI object upon which you can invoke
    * the various methods to save the day.
    * @param secretIdentity contains the Doctor CS’s hidden identity
    * @param jlaid is an integer representation of the Doctor CS’s
    * JLAID ID
    */
    public DoctorCS(AI ai, String secretIdentity, int jlaid) {
        this.ai = ai;
        this.secretIdentity = secretIdentity;
        this.jlaid = jlaid;
        this.safe = false;
    }
    /**
    * Conditional setter for the safe instance variable.
    */
    public void saveTheDay() {
        if (ai instanceof RogueAI) {
            while (((RogueAI) ai).getfirewallProtection() > 0) {
                ((RogueAI) ai).lowerFirewall();
            }
            safe = ai.swapCannonTarget(ai.getSecretHQ());

        } else if (ai instanceof RandomAI) {
            safe = ai.swapCannonTarget(ai.getSecretHQ());
        }
    }
    /**
    * Getter method for ai
    *
    * @return ai variable of AI object
    */
    public AI getAI() {
        return ai;
    }
    /**
    *  This method will return a different String depending
    * on the value of safe and the value of destructed in the instance ai.
    * @return string representation of corresponding status
    */
    public String getStatus() {
        if (safe) {
            return "Doctor CS has saved the day!";
        }
        if (!safe && ai.getDestructed()) {
            return "Dr. Chipotle has succeeded in his plan";
        } else {
            return "Georgia Tech is still in danger";
        }
    }
    /**
    * Overrides toString method
    *
    * @return  the String representation of Doctor CS’s information.
    */
    @Override
    public String toString() {
        return secretIdentity + " aka Doctor CS with JLAID: " + jlaid;
    }
}
