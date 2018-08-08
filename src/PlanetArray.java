import Exceptions.InvalidResourceProductionException;
import Resources.PlanetNames;

import java.util.ArrayList;
import java.util.Random;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class PlanetArray {
    //makes an arrayList of all planets available by instantiating the planets and adding them individually .
    private ArrayList<Planet> getAllPlanetsList() {
        try {
            ArrayList<Planet> allPlanetsList = new ArrayList<>();

            Planet arnor = new Planet(PlanetNames.ARNOR.name(), 2);
            Planet bereg = new Planet(PlanetNames.BEREG.name(), 3);
            Planet centauri = new Planet(PlanetNames.CENTAURI.name(), 1);
            Planet lazar = new Planet(PlanetNames.LAZAR.name(), 1);
            Planet lodor = new Planet(PlanetNames.LODOR.name(), 3);
            Planet mellon = new Planet(PlanetNames.MELLON.name(), 0);
            Planet saudor = new Planet(PlanetNames.SAUDOR.name(), 2);
            Planet wellon = new Planet(PlanetNames.WELLON.name(), 1);
            Planet lisis = new Planet(PlanetNames.LISIS.name(), 2);
            Planet primor = new Planet(PlanetNames.PRIMOR.name(), 2);
            Planet tempesta = new Planet(PlanetNames.TEMPESTA.name(), 1);
            Planet hercalor = new Planet(PlanetNames.HERCALOR.name(), 1);
            Planet abyz = new Planet(PlanetNames.ABYZ.name(), 3);
            Planet arinam = new Planet(PlanetNames.ARINAM.name(), 1);
            Planet coorneeq = new Planet(PlanetNames.COORNEEQ.name(), 1);
            Planet meharXull = new Planet(PlanetNames.MEHAR_XULL.name(), 1);
            Planet arcturus = new Planet(PlanetNames.ARCTURUS.name(), 1);
            Planet bellatrix = new Planet(PlanetNames.BELLATRIX.name(), 0);


            allPlanetsList.add(arnor);
            allPlanetsList.add(bereg);
            allPlanetsList.add(centauri);
            allPlanetsList.add(lazar);
            allPlanetsList.add(lodor);
            allPlanetsList.add(mellon);
            allPlanetsList.add(saudor);
            allPlanetsList.add(wellon);
            allPlanetsList.add(lisis);
            allPlanetsList.add(primor);
            allPlanetsList.add(tempesta);
            allPlanetsList.add(hercalor);
            allPlanetsList.add(abyz);
            allPlanetsList.add(arinam);
            allPlanetsList.add(coorneeq);
            allPlanetsList.add(meharXull);
            allPlanetsList.add(arcturus);
            allPlanetsList.add(bellatrix);


            return allPlanetsList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //arrayList who has all planets and gets reduced in size when a random planet is added to a planet system
    private ArrayList<Planet> randomPlanetList = getAllPlanetsList();

    //gets a random planet from the randomPlanetsList and removes it from the list to keep from adding duplicate planets
    Planet getRandomPlanet() {
        Planet planet;
        Random rand = new Random();
        int randomValue = rand.nextInt(randomPlanetList.size());

        planet = randomPlanetList.get(randomValue);
        randomPlanetList.remove(randomValue);

        return planet;
    }

    //returns Mecatol Rex to use in assigning the planet list for the center planet system.
    Planet getMecatolRex() {
        try {
            return new Planet(PlanetNames.MECATOL_REX.name(), 5);
        } catch (InvalidResourceProductionException e) {
            System.out.println("getMecatolRex Failed and returned null");
            return null;
        }
    }
}
