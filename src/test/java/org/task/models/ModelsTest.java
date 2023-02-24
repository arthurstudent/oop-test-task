package org.task.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.task.enums.MeatEater;
import org.task.enums.PlantEating;
import org.task.models.utils.AnimalsHelper;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ModelsTest {
    MeatEaterAnimal lion;

    PlantEaterAnimal cow;

    PlantEaterAnimal goat;

    Grass grass;

    @BeforeAll
    void setUp() {
        lion = new MeatEaterAnimal(MeatEater.LION);
        cow = new PlantEaterAnimal(PlantEating.COW);
        goat = new PlantEaterAnimal(PlantEating.GOAT);
        grass = new Grass();
    }

    @Test
    void testMeatEaterNotEatPlants() {
        String result = lion.eat(grass);
        assertEquals(AnimalsHelper.NOT_EAT, result);
    }

    @Test
    void testMeatEaterEatAnimals() {
        String firstEat = lion.eat(cow);
        String secondEat = lion.eat(goat);

        assertNotEquals(firstEat, secondEat);
        assertEquals(cow.getType().getName() + " " + AnimalsHelper.HAS_BEEN_EATEN + " " + lion.getType().getName(), firstEat);
        assertEquals(goat.getType().getName() + " " + AnimalsHelper.HAS_BEEN_EATEN + " " + lion.getType().getName(), secondEat);
    }

    @Test
    void testAnimalsDontEatThemself() {
        String lionEatResult = lion.eat(lion);
        String cowEatResult = cow.eat(cow);
        String goatEatResult = goat.eat(goat);

        assertEquals(AnimalsHelper.HAS_NOT_BEEN_EATEN + " " + lion.getType().getName(), lionEatResult);
        assertEquals(AnimalsHelper.NOT_EAT, cowEatResult);
        assertEquals(AnimalsHelper.NOT_EAT, goatEatResult);
    }

    @Test
    void testPlantEaterDoesntEatMeat() {
        String cowEatResult = cow.eat(lion);
        String goatEatResult = goat.eat(cow);

        assertEquals(AnimalsHelper.NOT_EAT, cowEatResult);
        assertEquals(AnimalsHelper.NOT_EAT, goatEatResult);
    }

    @Test
    void testPlantEaterEatsPlant() {
        String cowEatResult = cow.eat(grass);
        String goatEatResult = goat.eat(grass);

        assertNotEquals(cowEatResult, goatEatResult);
        assertEquals(AnimalsHelper.HAS_BEEN_EATEN + " " + cow.getType().getName(), cowEatResult);
        assertEquals(AnimalsHelper.HAS_BEEN_EATEN + " " + goat.getType().getName(), goatEatResult);
    }

    @Test
    void testNullAnimalType() {
        IllegalArgumentException illegalArgumentException
                = assertThrows(IllegalArgumentException.class, () -> lion = new MeatEaterAnimal(null));
        assertEquals("This type can't be null", illegalArgumentException.getMessage());
    }

    @Test
    void testNullFoodType() {
        String resultEat = lion.eat(null);
        assertEquals(AnimalsHelper.NOT_EAT, resultEat);
    }
}