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
    public PlanetSystem(String position, ArrayList<Planet> planetList) throws ContainsMoreThan3PlanetsException {
        this.position = position;
        if (planetList.size() <= 3) {
            this.planetList = planetList;
        }
        else {
            throw new ContainsMoreThan3PlanetsException();
        }
    }
    //constructor with position and arrayList for initializing with planets via var args.
    public PlanetSystem(String position, ArrayList<Planet> planetList, Planet ... planets) throws ContainsMoreThan3PlanetsException {
        this.position = position;
        if (planetList.size() <= 3 && planets.length <= 3) {
            this.planetList = planetList;
            //var args parses an array and Array.asList converts it to a list.
            this.planetList.addAll(Arrays.asList(planets));
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
    public void flySpaceshipAwayFromSystem(Units spaceship) {
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





}
