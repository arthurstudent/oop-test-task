package org.task.models;

import org.task.abstracts.Animal;
import org.task.abstracts.AnimalDescription;
import org.task.abstracts.Food;
import org.task.enums.MeatEater;
import org.task.utils.Utils;

import java.util.Objects;

public class MeatEaterAnimal extends Animal {

    private final MeatEater type;

    public MeatEaterAnimal(MeatEater type) {
        this.type = type;
    }

    @Override
    public String eat(Food food) {
        if (food instanceof Animal) {
            return food.consume(getType());
        } else {
            return Utils.NOT_EAT;
        }
    }

    public MeatEater getType() {
        return type;
    }

    @Override
    public String consume(AnimalDescription animalDescription) {
        if (Objects.equals(getType().getName(), animalDescription.getName())) {
            return Utils.NOT_EAT;
        } else {
            return getType().getName() + " " +
                    Utils.HAS_BEEN_EATEN + " " + animalDescription.getName();
        }
    }
}
