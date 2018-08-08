import Exceptions.*;
import Resources.PlanetNames;
import Units.Units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    void findAllSystems() {
        System.out.println("The following systems resides in this Galaxy:");
        for (Systems systems : SystemsList) {
            System.out.println(systems.getClass().getSimpleName() + ": " + systems.getPosition());

        }
    }

    void findAllSpaceships() {
        System.out.println("The following spaceships roams in this Galaxy:");
        for (Systems systems : SystemsList) {
            for (Units units : systems.getSpaceshipsInsideSystem()) {
                System.out.println(units.getClass().getSimpleName() + " owned by " + units.getOwner().getName());
            }
        }
    }

    void findAllPlanets() {
        System.out.println("   These planets resides in this Galaxy: ");
        for (Systems systems : SystemsList) {
            for (Planet planet : systems.getPlanetList()) {
                System.out.println(planet.getName() + " exists in the " + systems.getPosition() + " system.");
            }
        }
    }

    public boolean isLegal() throws Exception {
        return false;
    }

    boolean hasMecatolRexInCenterSystem() throws DoesNotContainMecatolRexException, CenterSystemContainsMultiplePlanetsException {

        if (!(SystemsList.get(0).getPosition().contains("Center") &&
                SystemsList.get(0).getPlanetList().get(0).getName().contains(PlanetNames.MECATOL_REX.name()))) {
            throw new DoesNotContainMecatolRexException();
        }

        if (1 < SystemsList.get(0).getPlanetList().size()) {
            throw new CenterSystemContainsMultiplePlanetsException();
        }
        return true;
    }

    boolean doesNotContainDuplicatePlanets() throws GalaxyHasDuplicatePlanets {
        ArrayList<Planet> allPlanetsList = new ArrayList<>();

        for (Systems systems : SystemsList) {
            allPlanetsList.addAll(systems.getPlanetList());

        }
        int allPlanetsListSize = allPlanetsList.size();
        for (Planet planet : allPlanetsList) {
            for (int j = 1; j < allPlanetsListSize; j++) {
                if (planet.equals(allPlanetsList.get(j))) {
                    throw new GalaxyHasDuplicatePlanets();
                }

            }
        }
        return true;
    }

    boolean doesNotHaveMoreThan3PlanetsInASystem() throws SystemHasMoreThan3PlanetsException {

        for (Systems systems : SystemsList) {
            if (3 < systems.getPlanetList().size()) {
                throw new SystemHasMoreThan3PlanetsException();
            }
        }
        return true;
    }
    boolean isAllOppositeSystemPositionsCorrect() throws Exception {
        //map defines a key-value pair that is used to determine if the opposite direction is correct via integers.
        Map<String, Integer> map = new HashMap();
        map.put("North", 0);
        map.put("North-East", 1);
        map.put("South-East", 2);
        map.put("South", 3);
        map.put("South-West", 4);
        map.put("North-West", 5);

        //the size of the galaxy without the center system of the galaxy.
        int numberOfPlanetSystems = SystemsList.size() - 1;
        //validOppositePlanetSystems need to be initialized because it is used to compare to the number of systems.
        int currentPosition, expectedPosition, calcExpectedOffset, validOppositeSystems = 0;

        for (int galaxyPosition = 0; galaxyPosition < numberOfPlanetSystems; galaxyPosition++) {
            //there is 6 direction and 3 correlates to the opposite direction when there is 6 directions.
            calcExpectedOffset = (galaxyPosition + 3) % 6;

            //1 is used an offset because the 0th position is the center system.
            currentPosition = map.get(SystemsList.get(1 + galaxyPosition).getPosition());
            expectedPosition = map.get(SystemsList.get(1 + calcExpectedOffset).getPosition());

            //the current position + 3 should equal the expected position (opposite direction).
            if ((currentPosition + 3) % 6 == expectedPosition) {
                validOppositeSystems++;
            }
        }
        //if these numbers are not equal it means that some planet systems are not aligned correctly. An exception is thrown.
        if (validOppositeSystems != numberOfPlanetSystems) {
            throw new SystemsAreNotPositionedOppositeException();
        }
        return true;
    }
}
