import Exceptions.*;
import Resources.PlanetNames;
import Resources.Races;
import Units.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class GalaxyTest {

    @Test
    //main test method for this class. Runs some methods that needs a galaxy parameter.
    void runAllTestMethods() {
        //instantiate the different objects used to define the galaxy.
        try {
            Planet planet1 = new Planet(PlanetNames.BELLATRIX.name(), 3);
            Planet planet2 = new Planet(PlanetNames.ABYZ.name(),4);
            Planet planet3 = new Planet(PlanetNames.MECATOL_REX.name(),6);

            ArrayList<Planet> planetArrayList1 = new ArrayList<>();
            ArrayList<Planet> planetArrayList2 = new ArrayList<>();

            planetArrayList1.add(planet1);

            planetArrayList2.add(planet1);
            planetArrayList2.add(planet2);
            planetArrayList2.add(planet3);


            PlanetSystem planetSystem1 = new PlanetSystem("North",planetArrayList1);
            PlanetSystem planetSystem2 = new PlanetSystem("South-West",planetArrayList2);

            Player player = new Player("Jon", Races.BROTHERHOOD_OF_YIN.name(), "White");
            Dreadnought dreadnought = new Dreadnought(player);
            Carrier carrier = new Carrier(player);
            planetSystem1.flySpaceshipToSystem(carrier, dreadnought);

            ArrayList<Systems> GalaxyList = new ArrayList<>();
            GalaxyList.add(planetSystem1);
            GalaxyList.add(planetSystem2);

            Galaxy galaxy = new Galaxy(GalaxyList);

            //should find 2 systems.
            findAllSystems(galaxy);
            //should find a carrier.
            findAllSpaceships(galaxy, carrier);
            //should find 4 planets.
            findAllPlanets(galaxy);
            //test for thrown exception.
            hasMecatolRexInCenterSystem(galaxy);
            //test for thrown exception.
            doesNotContainDuplicatePlanets(galaxy);
            //cannot test for thrown exception as planetSystem constructor does not allow > 3 planets.
            doesNotHaveMoreThan3PlanetsInASystem(galaxy);
            //should find 1 spaceship, the carrier.
            returnAllShipsOwnedByPlayer(galaxy, player);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            assert false;
        }

    }

    //should print the planet system North and South. Assertion checks whether there is 2 systems.
    private void findAllSystems(Galaxy galaxy) {
        galaxy.findAllSystems();
        assertEquals(2, galaxy.SystemsList.size());

    }
    //should print the carrier. Assertion checks if the carrier is listed in the system.
    private void findAllSpaceships(Galaxy galaxy, Carrier carrier) {
        galaxy.findAllSpaceships();
        assertTrue(galaxy.SystemsList.get(0).getSpaceshipsInsideSystem().contains(carrier));
    }

    //should print 2 planets. Assertion checks if the systems list is empty.
    private void findAllPlanets(Galaxy galaxy) {
        galaxy.findAllPlanets();
        assertFalse(galaxy.SystemsList.isEmpty());
    }

    //should catch DoesNotContainMecatolRexException.
    private void hasMecatolRexInCenterSystem(Galaxy galaxy) {
        try {
            galaxy.hasMecatolRexInCenterSystem();
            assert false;
        } catch (DoesNotContainMecatolRexException a) {
            //should catch this exception.
            assert true;
        } catch (CenterSystemContainsMultiplePlanetsException | GalaxyContainsMultipleMecatolRexException e) {
            //should not catch this one, as there are not multiple planets in the center system.
            e.printStackTrace();
            assert false;
        }
    }

    //test for GalaxyHasDuplicatePlanetsException.
    private void doesNotContainDuplicatePlanets(Galaxy galaxy) {
        try {
            galaxy.doesNotContainDuplicatePlanets();
            assert false;
        } catch (GalaxyHasDuplicatePlanets e) {
            assert true;
        }
    }

    //this exception cannot be tested as the PlanetSystem constructor limits the construction of a planetList > 3.
    private void doesNotHaveMoreThan3PlanetsInASystem(Galaxy galaxy) {
        try {
            galaxy.doesNotHaveMoreThan3PlanetsInASystem();
            assert true;
        } catch (SystemHasMoreThan3PlanetsException e) {
            //unreachable.
        }

    }

    @Test
    //test whether a 7 system galaxy is legal.
    void isAllOppositeSystemPositionsCorrect() {
        try {
            PlanetSystem centerPlanetSystem = new PlanetSystem("Center", new ArrayList<>());
            PlanetSystem northPlanetSystem = new PlanetSystem("North", new ArrayList<>());
            PlanetSystem northEastPlanetSystem = new PlanetSystem("North-East", new ArrayList<>());
            PlanetSystem southEastPlanetSystem = new PlanetSystem("South-East", new ArrayList<>());
            PlanetSystem southPlanetSystem = new PlanetSystem("South", new ArrayList<>());
            AsteroidFieldSystem southWestAFSystem = new AsteroidFieldSystem("South-West");
            PlanetSystem northWestPlanetSystem = new PlanetSystem("South-West", new ArrayList<>());

            Galaxy galaxy = new Galaxy(new ArrayList<>(), centerPlanetSystem, northPlanetSystem, northEastPlanetSystem,
                    southEastPlanetSystem, southPlanetSystem, southWestAFSystem, northWestPlanetSystem);

            try {
                galaxy.isAllOppositeSystemPositionsCorrect();
                assert false;
            } catch (Exception e) {
                assert true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    //the predefinedGalaxy is legal, so the isLegal method should return true.
    void isLegal() {
        PredefinedGalaxy predefinedGalaxy = new PredefinedGalaxy();
        try {
            assertTrue(predefinedGalaxy.getGalaxy().isLegal());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //finds the spaceship owned by the player. The sorted list is checked manually for errors via a print statement.
    private void returnAllShipsOwnedByPlayer(Galaxy galaxy, Player player) {
        ArrayList<Units> spaceshipsOwnedByPlayer = galaxy.returnAllShipsOwnedByPlayer(player);
        assertEquals(2, spaceshipsOwnedByPlayer.size());
        for (Units spaceship : spaceshipsOwnedByPlayer) {
            System.out.println(spaceship.getClass().getSimpleName());
        }

    }
    @Test
    void createTextFileContainingPlayersWithPlanetaryControl() {
        PredefinedGalaxy predefinedGalaxy = new PredefinedGalaxy();
        predefinedGalaxy.getGalaxy().createTextFileContainingPlayersWithPlanetaryControl();

    }
}