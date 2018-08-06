import Resources.PlanetNames;
import Resources.Races;
import Units.Destroyer;
import Units.LightCruiser;
import Units.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class PlanetSystemTest {
    private LightCruiser lightCruiser = new LightCruiser(new Player("Ragnar", Races.ARBOREC.name(), "Red"));
    private Destroyer destroyer = new Destroyer(new Player("Magnus", Races.CLAN_OF_SAAR.name(), "Orange"));


    @Test
    void flySpaceshipToSystem() {
        try {
            ArrayList<Planet> planetArrayList = new ArrayList<>();
            planetArrayList.add(new Planet(PlanetNames.ARNOR.name(), 5));
            PlanetSystem planetSystem = new PlanetSystem("North", planetArrayList);

            planetSystem.flySpaceshipToSystem(lightCruiser);
            assertTrue(planetSystem.getSpaceshipsInsideSystem().contains(lightCruiser));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            assert false;
        }
    }

    @Test
    void flySpaceshipAwayFromSystem() {
        try {
            ArrayList<Planet> planetArrayList = new ArrayList<>();
            planetArrayList.add(new Planet(PlanetNames.CENTAURI.name(), 5));
            PlanetSystem planetSystem = new PlanetSystem("Center", planetArrayList);
            planetSystem.flySpaceshipToSystem(lightCruiser);
            assertTrue(planetSystem.getSpaceshipsInsideSystem().contains(lightCruiser));

            //removes the recently added light cruiser and the planet system should now be empty of spaceships.
            planetSystem.flySpaceshipAwayFromSystem(lightCruiser);
            assertTrue(planetSystem.getSpaceshipsInsideSystem().isEmpty());
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    void retrieveAllSpaceships() {
        try {
            ArrayList<Planet> planetArrayList = new ArrayList<>();
            planetArrayList.add(new Planet(PlanetNames.ARCTURUS.name(), 6));
            PlanetSystem planetSystem = new PlanetSystem("East", planetArrayList);
            planetSystem.flySpaceshipToSystem(lightCruiser);
            planetSystem.flySpaceshipToSystem(destroyer);

            //should print the 2 ships that resides in the planet system.
            planetSystem.retrieveAllSpaceships();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}