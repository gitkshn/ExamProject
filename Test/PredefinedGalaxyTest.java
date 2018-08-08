import Resources.PlanetNames;
import Units.Units;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class PredefinedGalaxyTest {
    private PredefinedGalaxy predefinedGalaxy = new PredefinedGalaxy();
    private Galaxy testGalaxy = predefinedGalaxy.getGalaxy();

    @Test
    void getGalaxyPlanetsTest() {
        //mecatol rex should be in the center planet system.
        assertTrue(testGalaxy.SystemsList.get(0).getPlanetList().get(0).getName().equalsIgnoreCase(PlanetNames.MECATOL_REX.name()));

        //finds all the planets in each system via foreach loops.
        int planetCounter = 0;
        for (Systems systems : testGalaxy.SystemsList) {
            for (Planet planet : systems.getPlanetList()) {
                planetCounter++;
            }
        }
        //there should be 7 planets
        assertEquals(7, planetCounter);
    }

    @Test
        //finds all the units in each system and checks whether the name and ship name is correct and increments the counter.
    void getGalaxySpaceshipsTest() {
        int crassusUnitCount = 0, pompeyUnitCount = 0, totalSpaceships = 0;

        for (Systems systems : testGalaxy.SystemsList) {
            for (Units units : systems.getSpaceshipsInsideSystem()) {
                if (units.getOwner().getName().contains("Crassus") && units.getClass().getSimpleName().contains("Dreadnought")
                        || units.getClass().getSimpleName().contains("Destroyer")) {
                    crassusUnitCount++;
                }
                if (units.getOwner().getName().contains("Pompey") && units.getClass().getSimpleName().contains("Cruiser")
                        || units.getClass().getSimpleName().contains("Carrier")) {
                    pompeyUnitCount++;
                }
                totalSpaceships++;
            }
        }
        assertEquals(totalSpaceships, crassusUnitCount + pompeyUnitCount);
    }
}