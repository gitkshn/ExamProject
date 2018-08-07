import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/* Kasper Suamchiang Hvitfeldt Nielsen.
kshn16@student.aau.dk */
class PredefinedGalaxyTest {

    @Test
    void getGalaxy() {
        PredefinedGalaxy predefinedGalaxy = new PredefinedGalaxy();
        //the predefined galaxy should have 7 systems.
        Assertions.assertTrue(predefinedGalaxy.getGalaxy().SystemsList.size() == 7);

    }
}