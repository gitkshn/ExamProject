import Units.Units;

import java.util.ArrayList;
import java.util.Arrays;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class Galaxy {
    ArrayList<Systems> SystemsList;

    Galaxy(ArrayList<Systems> SystemsList) {
        this.SystemsList = SystemsList;
    }

    Galaxy(ArrayList<Systems> SystemsList, Systems ... systems) {
        SystemsList.addAll(Arrays.asList(systems));
        this.SystemsList = SystemsList;
    }

    public void findAllSystems() {
        System.out.println("The following systems resides in this Galaxy:");
        for (Systems systems : SystemsList) {
            System.out.println(systems.getClass().getSimpleName() + ": " + systems.getPosition());

        }
    }

    public void findAllSpaceships() {
        System.out.println("The following spaceships roams in this Galaxy:");
        for (Systems systems : SystemsList) {
            for (Units units : systems.getSpaceshipsInsideSystem()) {
                System.out.println(units.getClass().getSimpleName() + " owned by " + units.getOwner().getName());
            }
        }
    }

    public void findAllPlanets() {
        System.out.println("   These planets resides in this Galaxy: ");
        for (Systems systems : SystemsList) {
            for (Planet planet : systems.getPlanetList()) {
                System.out.println(planet.getName() + " exists in the " + systems.getPosition() + " system.");
            }
        }
    }
}
