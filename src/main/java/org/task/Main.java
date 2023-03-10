package org.task;

import org.task.enums.MeatEater;
import org.task.enums.PlantEating;
import org.task.models.MeatEaterAnimal;
import org.task.models.PlantEaterAnimal;

public class Main {
    public static void main(String[] args) {
        MeatEaterAnimal lion = new MeatEaterAnimal(MeatEater.LION);
        PlantEaterAnimal cow = new PlantEaterAnimal(PlantEating.COW);
        PlantEaterAnimal goat = new PlantEaterAnimal(PlantEating.GOAT);
        System.out.println(lion.eat(cow));
        System.out.println(lion.eat(lion));
        System.out.println(cow.eat(cow));
        System.out.println(cow.eat(goat));
    }
}