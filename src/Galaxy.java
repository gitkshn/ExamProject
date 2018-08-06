import Units.Units;

import java.util.ArrayList;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class Galaxy {
    ArrayList<Systems> galaxy;

    public Galaxy(ArrayList<Systems> galaxy) {
        this.galaxy = galaxy;
    }

    public void findAllSystems() {
        System.out.println("The following systems resides in this galaxy:");
        for (Systems systems : galaxy) {
            System.out.println(systems.getClass().getSimpleName() + ": " + systems.getPosition());

        }
    }

    public void findAllSpaceships() {
        System.out.println("The following spaceships resides in this galaxy:");
        for (Systems systems : galaxy) {
            for (Units units : systems.getSpaceshipsInsideSystem()) {
                System.out.println(units.getClass().getSimpleName() + " owned by " + units.getOwner().getName());
            }
        }
    }

    public void findAllPlanets() {
        for (Systems systems : galaxy) {
            for (Planet planet : systems.getPlanetList()) {
                System.out.println(planet.getName() + " exists in " + systems.getClass().getSimpleName());
            }
        }
    }
}
