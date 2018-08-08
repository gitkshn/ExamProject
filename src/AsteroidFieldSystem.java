import Exceptions.InvalidSpaceBattleException;
import Units.*;

import java.util.ArrayList;
import java.util.Iterator;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class AsteroidFieldSystem implements Systems {
    private String position;
    private ArrayList<Units> spaceshipsInsideAsteroidField = new ArrayList<Units>();

    AsteroidFieldSystem(String position) {
        this.position = position;
    }

    @Override
    //adds the spaceship to the arrayList. If it is not a dreadnought the object gets removed.
    public void flySpaceshipToSystem(Units spaceship) {
        spaceshipsInsideAsteroidField.add(spaceship);
        if (!spaceship.getClass().getSimpleName().contentEquals("Dreadnought")) {
            System.out.println(spaceship.getClass().getSimpleName() + " was hit by an asteroid and destroyed.");
            spaceshipsInsideAsteroidField.remove(spaceship);
        }
    }

    @Override
    public ArrayList<Units> getSpaceshipsInsideSystem() {
        return spaceshipsInsideAsteroidField;
    }

    @Override
    //returns an empty list
    public ArrayList<Planet> getPlanetList() {
        System.out.println("Only asteroids resides in the " + getPosition() + " system. Enter at your own risk.");
        return new ArrayList<>();
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    //throws an exception with string parameter asteroidField.
    public Player spaceBattle(Player redPlayer, Player bluePlayer) throws InvalidSpaceBattleException {
        throw new InvalidSpaceBattleException("asteroidField");
    }

    //removes the spaceship if the player has dreadnought present in the asteroid field.
    void flySpaceshipAwayFromSystem(Player player) {
        spaceshipsInsideAsteroidField.removeIf(spaceship -> spaceship.getOwner().equals(player));
    }
}
