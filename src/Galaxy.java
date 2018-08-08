import Exceptions.*;
import Resources.PlanetNames;
import Units.*;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class Galaxy {
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

    boolean isLegal() throws Exception {
        return hasMecatolRexInCenterSystem() && doesNotContainDuplicatePlanets()
                && doesNotHaveMoreThan3PlanetsInASystem() && isAllOppositeSystemPositionsCorrect();
    }


    boolean hasMecatolRexInCenterSystem() throws DoesNotContainMecatolRexException, CenterSystemContainsMultiplePlanetsException, GalaxyContainsMultipleMecatolRexException {
        //checks if the center system has the correct position and contains the planet called mecatol rex. if not, an exception is thrown.
        if (!(SystemsList.get(0).getPosition().contains("Center") &&
                SystemsList.get(0).getPlanetList().get(0).getName().contains(PlanetNames.MECATOL_REX.name()))) {
            throw new DoesNotContainMecatolRexException();
        }
        //there should only be one planet in the planet list and that is mecatol rex. An exception will be thrown otherwise.
        if (1 < SystemsList.get(0).getPlanetList().size()) {
            throw new CenterSystemContainsMultiplePlanetsException();
        }
        //mecatol rex should only exist in the center system and not anywhere else.
        int mecatolRexPlanets = 0;
        for (Systems systems : SystemsList) {
            for (Planet planet : systems.getPlanetList()) {
                if (planet.getName().contains(PlanetNames.MECATOL_REX.name())) {
                    mecatolRexPlanets++;
                    if (mecatolRexPlanets != 1) {
                        throw new GalaxyContainsMultipleMecatolRexException();
                    }
                }
            }
        }
        return true;
    }

    boolean doesNotContainDuplicatePlanets() throws GalaxyHasDuplicatePlanets {
        ArrayList<Planet> totalPlanetList = new ArrayList<>();

        for (Systems systems : SystemsList) {
            totalPlanetList.addAll(systems.getPlanetList());

        }
        /*iterates through the list and checks whether the i'th planet is equal to the j'th + 1 planet.
         * +1 is used so it does not run equals on it self.*/
        int totalPlanetListSize = totalPlanetList.size();
        for (int i = 0; i < totalPlanetListSize; i++) {
            for (int j = 1 + i; j < totalPlanetListSize; j++) {
                if (totalPlanetList.get(i).equals(totalPlanetList.get(j))) {
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
    //checks whether a galaxy with 7 systems is aligned correctly.
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
    //returns an arrayList with all the spaceships the player owns in a sorted list.
    ArrayList<Units> returnAllShipsOwnedByPlayer(Player player) {
        ArrayList<Units> spaceshipsOwnedByPlayer = new ArrayList<Units>();
        //gathers all the spaceships owned by the player.
        for (Systems systems : SystemsList) {
            for (Units spaceship : systems.getSpaceshipsInsideSystem()) {
                if (spaceship.getOwner().equals(player)) {
                    spaceshipsOwnedByPlayer.add(spaceship);
                }
            }
        }
        //if the list is empty, a print statement is made.
        if (spaceshipsOwnedByPlayer.isEmpty()) {
            System.out.println(player.getName() + " has no spaceships in the galaxy.");
        }
        //compares the units according to their combat value first and then resource cost if their combat values are equal.
        spaceshipsOwnedByPlayer.sort(Comparator.comparingInt(Units::getCombatValue).thenComparingInt(Units::getResourceCost));

        return spaceshipsOwnedByPlayer;
    }
    void createTextFileContainingPlayersWithPlanetaryControl() {
    /*bufferedWriter in try-with-resources to close it after use.
    the filepath for PlayersWithPlanetaryControl is in the same folder as the project.*/
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("PlayersWithPlanetaryControl.txt"), StandardCharsets.UTF_8))) {
            for (Systems system : SystemsList) {
                //flag that is used to keep bufferWriter from writing the system and owner multiple times.
                int newSystemFlag = 0;

                for (Units spaceship : system.getSpaceshipsInsideSystem()) {
                    int totalNumberOfShips = system.getSpaceshipsInsideSystem().size();
                    int shipsOwned = 0;
                    //if there is planets in the system the for loop checks whether the owner of the first spaceship owns all the spaceships in the planet system.
                    if (!system.getPlanetList().isEmpty()) {
                        for (int numberOfShips = 0; numberOfShips < totalNumberOfShips; numberOfShips++) {
                            if (system.getSpaceshipsInsideSystem().get(0).getOwner().equals(system.getSpaceshipsInsideSystem().get(numberOfShips).getOwner())) {
                                shipsOwned++;
                            }
                        }
                    }
                    /*should be equal otherwise there is different owners which means no-one has control of the system
                     *if it is a new system (indicated by the flag) bufferedWriter writes the planet system name,
                     *and the owner which has control over the following planets.*/
                    if (shipsOwned == totalNumberOfShips) {
                        newSystemFlag++;
                        if (newSystemFlag == 1) {
                            bufferedWriter.write("Planet System: " + system.getPosition());
                            bufferedWriter.newLine();
                            bufferedWriter.write(spaceship.getOwner().toString());
                            bufferedWriter.newLine();
                            for (Planet planet : system.getPlanetList()) {
                                bufferedWriter.write("     " + planet.getName());
                                bufferedWriter.newLine();

                            }
                        }
                    }
                }
            }
        //bufferedWriter, OutputStreamWriter and FileOutputStream can throw an IOException.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    Galaxy getRandomGalaxy() {
        
        return null;
    }
}
