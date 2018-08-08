package Units;/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */

public class LightCruiser extends Cruiser {
    //field is static as to be usable in the constructor.
    private static int LightCruiserMovementSpeed = 3;

    //constructor.
    public LightCruiser(Player owner) {
        super(owner, LightCruiserMovementSpeed);
    }

}
