import Resources.PlanetNames;
import Resources.Races;
import Units.*;

import java.util.ArrayList;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class PredefinedGalaxy {

    public Galaxy getGalaxy() {
        try {
            Planet mecatolRex = new Planet(PlanetNames.MECATOL_REX.name(), 5);
            Planet vegaMinor = new Planet(PlanetNames.VEGA_MINOR.name(), 6);
            Planet vegaMajor = new Planet(PlanetNames.VEGA_MAJOR.name(), 4);

            Planet industrex = new Planet(PlanetNames.INDUSTREX.name(), 6);
            Planet rigel1 = new Planet(PlanetNames.RIGEL_I.name(), 0);
            Planet rigel2 = new Planet(PlanetNames.RIGEL_II.name(), 1);
            Planet mirage = new Planet(PlanetNames.MIRAGE.name(),1);

            PlanetSystem centerPlanetSystem = new PlanetSystem("Center", new ArrayList<>(), mecatolRex);
            PlanetSystem northPlanetSystem = new PlanetSystem("North", new ArrayList<>(), vegaMinor, vegaMajor);
            SupernovaSystem northEastSupernovaSystem = new SupernovaSystem("North-East");

            PlanetSystem southEastPlanetSystem = new PlanetSystem("South-East", new ArrayList<>(),industrex);
            PlanetSystem southPlanetSystem = new PlanetSystem("South", new ArrayList<>(), rigel1, rigel2);
            AsteroidFieldSystem southWestAsteroidFieldSystem = new AsteroidFieldSystem("South-West");

            PlanetSystem northWestPlanetSystem = new PlanetSystem("North-West", new ArrayList<>(), mirage);

            Player pompey = new Player("Pompey", Races.FEDERATION_OF_SOL.name(), "Red");
            Player crassus = new Player("Crassus", Races.EMIRATES_OF_HACAN.name(),"Blue");

            Dreadnought dreadnoughtBlue1 = new Dreadnought(crassus);
            Dreadnought dreadnoughtBlue2 = new Dreadnought(crassus);
            Destroyer destroyerBlue = new Destroyer(crassus);

            Cruiser cruiserRed1 = new Cruiser(pompey);
            Cruiser cruiserRed2 = new Cruiser(pompey);
            Carrier carrierRed = new Carrier(pompey);

            centerPlanetSystem.flySpaceshipToSystem(dreadnoughtBlue1, dreadnoughtBlue2, destroyerBlue);
            northPlanetSystem.flySpaceshipToSystem(cruiserRed1, cruiserRed2, carrierRed);

            return new Galaxy(new ArrayList<>(), centerPlanetSystem, northPlanetSystem, northEastSupernovaSystem,
                    southEastPlanetSystem, southPlanetSystem, southWestAsteroidFieldSystem, northWestPlanetSystem);

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
}
