package org.task.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.task.enums.MeatEater;
import org.task.enums.PlantEating;
import org.task.utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ModelsTest {
    MeatEaterAnimal lion;
    PlantEatingAnimal cow;
    PlantEatingAnimal goat;

    Grass grass;

    @BeforeAll
    void setUp() {
        lion = new MeatEaterAnimal(MeatEater.LION);
        cow = new PlantEatingAnimal(PlantEating.COW);
        goat = new PlantEatingAnimal(PlantEating.GOAT);
        grass = new Grass();
    }

    @Test
    void testMeatEaterNotEatPlants() {
        String result = lion.eat(grass);
        assertEquals(Utils.NOT_EAT, result);
    }

    @Test
    void testMeatEaterEatAnimals() {
        String firstEat = lion.eat(cow);
        String secondEat = lion.eat(goat);

        assertNotEquals(firstEat, secondEat);
        assertEquals(cow.getType().getName() + " " + Utils.HAS_BEEN_EATEN + " " + lion.getType().getName(), firstEat);
        assertEquals(goat.getType().getName() + " " + Utils.HAS_BEEN_EATEN + " " + lion.getType().getName(), secondEat);
    }

    @Test
    void testAnimalsDontEatThemself() {
        String lionEatResult = lion.eat(lion);
        String cowEatResult = cow.eat(cow);
        String goatEatResult = goat.eat(goat);

        assertEquals(Utils.NOT_EAT, lionEatResult);
        assertEquals(Utils.NOT_EAT, cowEatResult);
        assertEquals(Utils.NOT_EAT, goatEatResult);
    }

    @Test
    void testPlantEaterDoesntEatMeat() {
        String cowEatResult = cow.eat(lion);
        String goatEatResult = goat.eat(cow);

        assertEquals(Utils.NOT_EAT, cowEatResult);
        assertEquals(Utils.NOT_EAT, goatEatResult);
    }

    @Test
    void testPlantEaterEatsPlant() {
        String cowEatResult = cow.eat(grass);
        String goatEatResult = goat.eat(grass);

        assertNotEquals(cowEatResult, goatEatResult);
        assertEquals(Utils.HAS_BEEN_EATEN + " " + cow.getType().getName(), cowEatResult);
        assertEquals(Utils.HAS_BEEN_EATEN + " " + goat.getType().getName(), goatEatResult);
    }
}