package Units;/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */

public class Carrier implements Units{
    private int resourceCost = 3;
    private int combatValue = 9;
    private int movementSpeed = 1;
    private int capacity = 6;
    private Player owner;

    //constructor.
    public Carrier(Player owner) {
        this.owner = owner;
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
