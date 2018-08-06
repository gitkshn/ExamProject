import Units.Units;

import java.util.ArrayList;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class SupernovaSystem implements Systems {
    private String position;
    private ArrayList<Units> spaceshipsInsideSupernova = new ArrayList<Units>();

    @Override
    //adds the spaceship to the arrayList and immediately removes it via the clear method.
    public void flySpaceshipToSystem(Units spaceship) {
        spaceshipsInsideSupernova.add(spaceship);
        System.out.println(spaceship.getClass().getSimpleName() + " has been destroyed by the supernovas.");
        spaceshipsInsideSupernova.clear();
    }

    @Override
    public ArrayList<Units> getSpaceshipsInsideSystem() {
        return spaceshipsInsideSupernova;
    }

    @Override
    public ArrayList<Planet> getPlanetList() {
        System.out.println("All the stars have collapsed and turned into supernovas.");
        return null;
    }

    @Override
    public String getPosition() {
        return position;
    }
}
