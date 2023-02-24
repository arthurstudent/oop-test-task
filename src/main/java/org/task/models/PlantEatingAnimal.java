package org.task.models;

import org.task.abstracts.Animal;
import org.task.abstracts.AnimalDescription;
import org.task.abstracts.Food;
import org.task.enums.PlantEating;
import org.task.utils.Utils;

public class PlantEatingAnimal extends Animal {

    private final PlantEating type;

    public PlantEatingAnimal(PlantEating type) {
        this.type = type;
    }

    @Override
    public String eat(Food food) {
        if (food instanceof Animal) {
            return Utils.NOT_EAT;
        } else {
            return food.consume(this.getType());
        }
    }

    @Override
    public String consume(AnimalDescription animalDescription) {
        return getType().getName() + " " + Utils.HAS_BEEN_EATEN + " " + animalDescription.getName();
    }

    public PlantEating getType() {
        return type;
    }
}
