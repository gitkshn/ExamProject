package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class GalaxyContainsMultipleMecatolRexException extends Exception {
    @Override
    public String getMessage() {
        return "The galaxy has multiple mecatol Rex planets. There can only be one!";
    }
}
