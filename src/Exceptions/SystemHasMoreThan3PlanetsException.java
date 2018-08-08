package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class SystemHasMoreThan3PlanetsException extends Exception {
    @Override
    public String getMessage() {
        return "A system can have a maximum of 3 planets.";
    }
}
