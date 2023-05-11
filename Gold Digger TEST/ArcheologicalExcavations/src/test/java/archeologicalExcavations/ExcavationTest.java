package archeologicalExcavations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExcavationTest {
    private static final int CAPACITY = 10;
    private static final String NAME = "Test Excavation";
    private Excavation excavation;

    @BeforeEach
    public void setUp() {
        excavation = new Excavation(NAME, CAPACITY);
    }

    @Test
    public void testConstructorCreatesExcavation() {
        Assertions.assertEquals(NAME, excavation.getName());
        Assertions.assertEquals(CAPACITY, excavation.getCapacity());
        Assertions.assertEquals(0, excavation.getCount());
    }

    @Test
    public void testAddArchaeologistToExcavation() {
        Archaeologist archaeologist = new Archaeologist("Test Archaeologist", "TestID");
        excavation.addArchaeologist(archaeologist);

        Assertions.assertEquals(1, excavation.getCount());
    }

    @Test
    public void testAddArchaeologistToFullExcavationThrowsException() {
        for (int i = 0; i < CAPACITY; i++) {
            Archaeologist archaeologist = new Archaeologist("Test Archaeologist " + i, "TestID " + i);
            excavation.addArchaeologist(archaeologist);
        }

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Archaeologist archaeologist = new Archaeologist("Test Archaeologist", "TestID");
            excavation.addArchaeologist(archaeologist);
        });
    }

    @Test
    public void testAddExistingArchaeologistToExcavationThrowsException() {
        Archaeologist archaeologist = new Archaeologist("Test Archaeologist", "TestID");
        excavation.addArchaeologist(archaeologist);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Archaeologist existingArchaeologist = new Archaeologist("Test Archaeologist", "TestID");
            excavation.addArchaeologist(existingArchaeologist);
        });
    }

    @Test
    public void testRemoveArchaeologistFromExcavation() {
        Archaeologist archaeologist = new Archaeologist("Test Archaeologist", "TestID");
        excavation.addArchaeologist(archaeologist);
        boolean isRemoved = excavation.removeArchaeologist("Test Archaeologist");

        Assertions.assertTrue(isRemoved);
        Assertions.assertEquals(0, excavation.getCount());
    }

    @Test
    public void testRemoveNonExistingArchaeologistFromExcavation() {
        boolean isRemoved = excavation.removeArchaeologist("Non-Existing Archaeologist");

        Assertions.assertFalse(isRemoved);
    }
}