package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class InvalidResourceProductionException extends Exception {

    @Override
    public String getMessage() {
        return "Planet resource production should be a value between [0-6]";
    }
}
