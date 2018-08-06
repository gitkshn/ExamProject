package Units;/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */

public class Destroyer implements Units {
    private int resourceCost = 1;
    private int combatValue = 9;
    private int movementSpeed = 2;
    private int capacity = 0;
    private Player owner;
    //constructor.
    public Destroyer(Player owner) {
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
