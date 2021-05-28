package hu.nive.ujratervezes.birdwatcher;

import birdwatcher.BirdWatcher;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BirdWatcherTest {
    private static final List<String> EXPECTED_SPECIES = Arrays.asList("american robin", "downy woodpecker", "house sparrow", "northern cardinal");

    private BirdWatcher birdWatcher;

    @BeforeEach
    void init() throws SQLException {
        MariaDbDataSource dataSource;
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/employees?useUnicode=true");
        dataSource.setUser("root");
        dataSource.setPassword("helloworld");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        birdWatcher = new BirdWatcher(dataSource);

    }


    @Test
    void test_getUniqueBirds_allBirdsOnce_anyOrder() {
        List<String> actualSpecies = birdWatcher.getUniqueBirds();

        assertEquals(EXPECTED_SPECIES.size(), actualSpecies.size());
        for (String bird : EXPECTED_SPECIES) {
            assertTrue(actualSpecies.contains(bird));
        }
    }

    @Test
    void test_getUniqueBirds_allBirdsOnce_alphabeticOrder() {
        List<String> actualSpecies = birdWatcher.getUniqueBirds();

        assertEquals(EXPECTED_SPECIES, actualSpecies);
    }

    @Test
    void test_getUniqueBirds_oneDuplicate_anyOrder() {
        List<String> actualSpecies = birdWatcher.getUniqueBirds();

        assertEquals(EXPECTED_SPECIES.size(), actualSpecies.size());
        for (String bird : EXPECTED_SPECIES) {
            assertTrue(actualSpecies.contains(bird));
        }
    }

}