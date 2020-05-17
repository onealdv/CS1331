/**
* @author onealdv
* @version 1.0
*/
public class RogueAI extends AI {
    private int firewallProtection;
    private int alertLevel;
    private final int maxAlert;
    /**
    * Constructor for RogueAI, takes in three ints and two Coordinates
    * objects and assigns them to their corresponding instance fields
    *
    * @param firewallProtection represents security level of the firewall
    * @param cannonTarget represents the location at which
    * Dr. Chipotle’s guacamole cannon is aimed
    * @param secretHQ is an instance of Coordinates that represents
    * the location of Dr. Chipotle’s secret headquarters
    */
    public RogueAI(int firewallProtection,
            Coordinates cannonTarget, Coordinates secretHQ) {
        this(firewallProtection, 10, cannonTarget, secretHQ);
    }
    /**
    * Constructor for RogueAI, takes in three ints and two Coordinates
    * objects and assigns them to their corresponding instance fields
    *
    * @param firewallProtection represents security level of the firewall
    * @param cannonTarget represents the location at which
    * Dr. Chipotle’s guacamole cannon is aimed
    * @param secretHQ is an instance of Coordinates that represents
    * the location of Dr. Chipotle’s secret headquarters
    * @param maxAlert is a constant int variable that represents
    * the alert level at which the computer self destructs
    */
    public RogueAI(int firewallProtection, int maxAlert,
            Coordinates cannonTarget, Coordinates secretHQ) {
        this(firewallProtection, 0, maxAlert, cannonTarget, secretHQ);
    }
    /**
    * Constructor for RogueAI, takes in three ints and two Coordinates
    * objects and assigns them to their corresponding instance fields
    *
    * @param firewallProtection represents security level of the firewall
    * @param cannonTarget represents the location at which
    * Dr. Chipotle’s guacamole cannon is aimed
    * @param secretHQ is an instance of Coordinates that represents
    * the location of Dr. Chipotle’s secret headquarters
    * @param maxAlert is a constant int variable that represents
    * the alert level at which the computer self destructs
    * @param alertLevel is an int that represents the current
    * alert level of the computer.
    */
    public RogueAI(int firewallProtection, int alertLevel,
            int maxAlert, Coordinates cannonTarget, Coordinates secretHQ) {
        super(cannonTarget, secretHQ);
        this.firewallProtection = firewallProtection;
        this.alertLevel = alertLevel;
        this.maxAlert = maxAlert;
    }
    /**
    * Getter method for variable firewallProtection
    *
    * @return int value of firewallProtection
    */
    public int getfirewallProtection() {
        return firewallProtection;
    }
    /**
    * Represents current alert level of the computer
    *
    * @return int value of alertLevel
    */
    public int alertLevel() {
        return alertLevel;
    }
    /**
    * Represents the alert level at which the computer self destructs.
    *
    * @return int value of maxAlert
    */
    public int maxAlert() {
        return maxAlert;
    }
    /**
    * When called, lowers firewallProtection by 2 and increments
    * alertLevel by 1
    */
    public void lowerFirewall() {
        firewallProtection -= 2;
        alertLevel += 1;
    }
    /**
    * Override abstract method shouldSwapCannonTarget() in AI
    *
    * @return true if firewallProtection is less than 0
    */
    @Override
    public boolean shouldSwapCannonTarget() {
        return firewallProtection <= 0;
    }
    /**
    * Override abstract method shouldSelfDestruct() in AI
    *
    * @return true if alertLevel is greater than maxAlert
    */
    @Override
    public boolean shouldSelfDestruct() {
        return alertLevel >= maxAlert;
    }
    /**
    * Overrides toString method for print statements
    *
    * @return new string to be printed
    */
    @Override
    public String toString() {
        return super.toString() + ", and is at alert level " + alertLevel
            + " with firewall protection " + firewallProtection + ".";
    }
}
