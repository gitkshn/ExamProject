package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class GalaxyHasDuplicatePlanets extends Exception {
    @Override
    public String getMessage() {
        return "Some planets are listed twice in the galaxy. A planet can only belong to one system.";
    }
}
