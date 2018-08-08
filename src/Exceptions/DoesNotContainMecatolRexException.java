package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class DoesNotContainMecatolRexException extends Exception {
    @Override
    public String getMessage() {
        return "The center system does not contain Mecatol Rex.";
    }
}
