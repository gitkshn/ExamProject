package Units;/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */

public class Cruiser implements Units {
    private int resourceCost = 2;
    private int combatValue = 7;
    private int movementSpeed = 2;
    private int capacity = 0;
    private Player owner;
    //constructor for cruiser unit.
    public Cruiser(Player owner) {
        this.owner = owner;
    }
    //constructor for the light cruiser unit.
    public Cruiser(Player owner, int LCMovementSpeed) {
        this.owner = owner;
        this.movementSpeed = LCMovementSpeed;
    }

    @Override
    public int getResourceCost() {
        return resourceCost;
    }

    @Override
    public int getCombatValue() {
        return combatValue;
    }

    @Override
    public int getMovementSpeed() {
        return movementSpeed;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public Player getOwner() {
        return owner;
    }
}
