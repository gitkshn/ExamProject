package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class CenterSystemContainsMultiplePlanetsException extends Exception {
    @Override
    public String getMessage() {
        return "The center system contains multiple planets.";
    }
}
