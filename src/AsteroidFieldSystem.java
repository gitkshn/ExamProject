import Units.Units;

import java.util.ArrayList;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class AsteroidFieldSystem implements Systems {
    private String position;
    private ArrayList<Units> spaceshipsInsideSupernova = new ArrayList<Units>();

    public AsteroidFieldSystem(String position) {
        this.position = position;
    }

    @Override
    //adds the spaceship to the arrayList. If it is not a dreadnought the object gets removed.
    public void flySpaceshipToSystem(Units spaceship) {
        spaceshipsInsideSupernova.add(spaceship);
        if (!spaceship.getClass().getSimpleName().contentEquals("Dreadnought")) {
            System.out.println(spaceship.getClass().getSimpleName() + " was hit by an asteroid and destroyed.");
            spaceshipsInsideSupernova.remove(spaceship);
        }
    }

    @Override
    public ArrayList<Units> getSpaceshipsInsideSystem() {
        return spaceshipsInsideSupernova;
    }

    @Override
    public ArrayList<Planet> getPlanetList() {
        System.out.println("Only asteroids resides in the " + getPosition() + " system. Enter at your own risk.");
        return new ArrayList<>();
    }

    @Override
    public String getPosition() {
        return position;
    }

    public void flySpaceshipAwayFromSystem(Units dreadnought) {
        spaceshipsInsideSupernova.remove(dreadnought);
    }
}
