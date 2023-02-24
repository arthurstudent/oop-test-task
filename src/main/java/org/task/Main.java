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
        System.out.println(lion.eat(cow));
        System.out.println(lion.eat(lion));
        System.out.println(cow.eat(cow));
        System.out.println(cow.eat(goat));
    }
}