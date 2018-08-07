import Resources.PlanetNames;

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
            Planet rigel1 = new Planet(PlanetNames.RIGEL_I.name(), 3);
            Planet rigel2 = new Planet(PlanetNames.RIGEL_II.name(), 1);

            PlanetSystem centerPlanetSystem = new PlanetSystem("Center", new ArrayList<>(), mecatolRex);
            System.out.println(centerPlanetSystem.getPlanetList().get(0).getName());


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
