import Exceptions.InvalidResourceProductionException;
import Resources.PlanetNames;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class PlanetTest {

    @Test
    void validPlanetTest() {
        try {
            Planet planet = new Planet(PlanetNames.ABYZ.name(), 6);
            assertNotNull(planet);
        } catch (InvalidResourceProductionException e) {
            System.out.println(e.getMessage());
            assert false;
        }
    }

    @Test
    void invalidPlanetTest() {
        try {
            Planet invalidPlanet = new Planet(PlanetNames.BELLATRIX.name(), -1);
            assert false;
        } catch (InvalidResourceProductionException e) {
            assert true;
        }
    }
}