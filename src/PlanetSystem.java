import Exceptions.ContainsNoSpaceshipsException;
import Exceptions.HasOver6NeighboringSystemsException;
import Units.Units;

import java.util.ArrayList;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class PlanetSystem {
    private String position;
    private ArrayList<Planet> planetList;
    public ArrayList<Units> spaceshipsInsidePlanetSystem = new ArrayList<Units>();

    public PlanetSystem(String position, ArrayList<Planet> planetList) throws HasOver6NeighboringSystemsException {
        this.position = position;
        if (planetList.size() <= 6) {
            this.planetList = planetList;
        }
        else {
            throw new HasOver6NeighboringSystemsException();
        }
    }
    //adds a spaceship to the spaceships arrayList.
    public void flySpaceshipToPlanetSystem(Units spaceship) {
        spaceshipsInsidePlanetSystem.add(spaceship);
    }
    //remove a spaceship in the spaceships arrayList if it is present.
    public void flySpaceshipAwayFromPlanetSystem(Units spaceship) {
        spaceshipsInsidePlanetSystem.remove(spaceship);
    }
    //prints all the ships that resides in the current planet system.
    public void retrieveAllSpaceships() throws ContainsNoSpaceshipsException {
        if (spaceshipsInsidePlanetSystem.isEmpty()) {
            throw new ContainsNoSpaceshipsException();
        }
        else {
            System.out.println("The " + position + " planet system contains the following ships:");
            for (Units spaceship : spaceshipsInsidePlanetSystem) {
                System.out.println(spaceship.getOwner().getName() + " has a " + spaceship.getClass().getSimpleName());
            }
        }
    }
    //returns the position of the planet.
    public String getPosition() {
        return position;
    }
    //returns an arrayList of the planets present in the system.
    public ArrayList<Planet> getPlanetList() {
        return planetList;
    }
}
