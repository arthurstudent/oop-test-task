package org.task;

import org.task.enums.MeatEater;
import org.task.enums.PlantEating;
import org.task.models.MeatEaterAnimal;
import org.task.models.PlantEatingAnimal;

public class Main {
    public static void main(String[] args) {
        MeatEaterAnimal lion = new MeatEaterAnimal(MeatEater.LION);
        PlantEatingAnimal cow = new PlantEatingAnimal(PlantEating.COW);
        PlantEatingAnimal goat = new PlantEatingAnimal(PlantEating.GOAT);
        lion.eat(cow);
        lion.eat(lion);
        cow.eat(cow);
        cow.eat(goat);
    }
}