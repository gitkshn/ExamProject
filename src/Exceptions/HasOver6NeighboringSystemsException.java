package Exceptions;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
public class HasOver6NeighboringSystemsException extends Exception {
    @Override
    public String getMessage() {
        return "Planet systems have a maximum of 6 neighboring systems";
    }
}
