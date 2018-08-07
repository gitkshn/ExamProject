import Exceptions.ContainsMoreThan3PlanetsException;
import Exceptions.ContainsNoSpaceshipsException;
import Units.Units;

import java.util.ArrayList;
import java.util.Arrays;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class PlanetSystem implements Systems{
    private String position;
    private ArrayList<Planet> planetList;
    private ArrayList<Units> spaceshipsInsidePlanetSystem = new ArrayList<Units>();

    //constructor with position and arrayList for initializing without planets.
    PlanetSystem(String position, ArrayList<Planet> planetList) throws ContainsMoreThan3PlanetsException {
        this.position = position;
        if (planetList.size() <= 3) {
            this.planetList = planetList;
        }
        else {
            throw new ContainsMoreThan3PlanetsException();
        }
    }
    //constructor with position and arrayList for initializing with planets via varargs.
    PlanetSystem(String position, ArrayList<Planet> planetList, Planet... planets) throws ContainsMoreThan3PlanetsException {
        this.position = position;
        if (planetList.size() <= 3 && planets.length <= 3) {
            //var args parses an array and Array.asList converts it to a list.
            planetList.addAll(Arrays.asList(planets));
            this.planetList = planetList;
        }
        else {
            throw new ContainsMoreThan3PlanetsException();
        }
    }

    @Override
    //adds a spaceship to the spaceships arrayList.
    public void flySpaceshipToSystem(Units spaceship) {
        spaceshipsInsidePlanetSystem.add(spaceship);
    }
    //adds multiple ships via varargs. the method is overloaded.
    void flySpaceshipToSystem(Units ... spaceship) {
        spaceshipsInsidePlanetSystem.addAll(Arrays.asList(spaceship));
    }

    @Override
    //returns an arrayList of the spaceships ín the system.
    public ArrayList<Units> getSpaceshipsInsideSystem() {
        return spaceshipsInsidePlanetSystem;
    }

    @Override
    //returns an arrayList of the planets present in the system.
    public ArrayList<Planet> getPlanetList() {
        return planetList;
    }

    @Override
    public String getPosition() {
        return position;
    }

    //remove a spaceship in the spaceships arrayList if it is present.
    void flySpaceshipAwayFromSystem(Units spaceship) {
        spaceshipsInsidePlanetSystem.remove(spaceship);
    }
    //prints all the ships that resides in the current planet system.
    void retrieveAllSpaceships() throws ContainsNoSpaceshipsException {
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





}
