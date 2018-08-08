package Units;

import Resources.Races;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class SpaceshipUnitsTest {
    //declare a player which is to be used in the constructing of the units.
    private Player Hans = new Player("Hans", Races.EMIRATES_OF_HACAN.name(), "Blue");

    @Test
    void DestroyerTest() {
        Destroyer destroyer = new Destroyer(Hans);
        int expectedResourceCost = 1;
        assertEquals(expectedResourceCost, destroyer.getResourceCost());
    }

    @Test
    void CruiserTest() {
        Cruiser cruiser = new Cruiser(Hans);
        int expectedCombatValue = 7;
        assertEquals(expectedCombatValue, cruiser.getCombatValue());
    }

    @Test
    void LightCruiserTest() {
        LightCruiser lightCruiser = new LightCruiser(Hans);
        //inherited value should be 3 instead of 2 (as in the superclass cruiser).
        int expectedMovementSpeed = 3;
        assertEquals(expectedMovementSpeed, lightCruiser.getMovementSpeed());
    }


    @Test
    void CarrierTest() {
        Carrier carrier = new Carrier(Hans);
        int expectedCapacity = 6;
        assertEquals(expectedCapacity, carrier.getCapacity());
    }

    @Test
    void DreadnoughtTest() {
        Dreadnought dreadnought = new Dreadnought(Hans);
        assertEquals(Hans, dreadnought.getOwner());
    }


}