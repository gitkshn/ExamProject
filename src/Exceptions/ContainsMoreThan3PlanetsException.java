package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class ContainsMoreThan3PlanetsException extends Exception {
    @Override
    public String getMessage() {
        return "Planet system has a maximum of 3 planets.";
    }
}
