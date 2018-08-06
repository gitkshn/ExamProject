import Resources.PlanetNames;
import Resources.Races;
import Units.Carrier;
import Units.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class GalaxyTest {
    @Test
    void runAllGalaxyMethods() {
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

            findAllSpaceships(galaxy);

            findAllPlanets(galaxy);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    void findAllSystems(Galaxy galaxy) {
        galaxy.findAllSystems();
    }


    void findAllSpaceships(Galaxy galaxy) {
        galaxy.findAllSpaceships();
    }


    void findAllPlanets(Galaxy galaxy) {
        galaxy.findAllPlanets();
    }
}