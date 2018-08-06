import Resources.PlanetNames;
import Resources.Races;
import Units.Carrier;
import Units.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class GalaxyTest {

    @Test
    //main test method for this class. Runs all the 3 smaller methods as they need to be visually inspected for errors.
    void runAllGalaxyMethods() {
        //instantiate the different objects used to define the galaxy.
        try {
            Planet planet1 = new Planet(PlanetNames.BELLATRIX.name(), 3);
            Planet planet2 = new Planet(PlanetNames.ABYZ.name(),4);

            ArrayList<Planet> planetArrayList1 = new ArrayList<>();
            ArrayList<Planet> planetArrayList2 = new ArrayList<>();

            planetArrayList1.add(planet1);
            planetArrayList2.add(planet2);

            PlanetSystem planetSystem1 = new PlanetSystem("North",planetArrayList1);
            PlanetSystem planetSystem2 = new PlanetSystem("South",planetArrayList2);

            Carrier carrier = new Carrier(new Player("Jon", Races.BROTHERHOOD_OF_YIN.name(), "White"));
            planetSystem1.flySpaceshipToSystem(carrier);

            ArrayList<Systems> GalaxyList = new ArrayList<>();
            GalaxyList.add(planetSystem1);
            GalaxyList.add(planetSystem2);

            Galaxy galaxy = new Galaxy(GalaxyList);

            findAllSystems(galaxy);

            findAllSpaceships(galaxy, carrier);

            findAllPlanets(galaxy);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            assert false;
        }
    }

    //should print the planet system North and South. Assertion checks whether there is 2 systems.
    void findAllSystems(Galaxy galaxy) {
        galaxy.findAllSystems();
        assertTrue(galaxy.SystemsList.size() == 2);

    }
    //should print the carrier. Assertion checks if the carrier is listed in the system.
    void findAllSpaceships(Galaxy galaxy, Carrier carrier) {
        galaxy.findAllSpaceships();
        assertTrue(galaxy.SystemsList.get(0).getSpaceshipsInsideSystem().contains(carrier));
    }

    //should print 2 planets. Assertion checks if the systems list is empty.
    void findAllPlanets(Galaxy galaxy) {
        galaxy.findAllPlanets();
        assertFalse(galaxy.SystemsList.isEmpty());
    }
}