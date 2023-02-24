package org.task.models;

import lombok.Getter;
import lombok.ToString;
import org.task.abstracts.Animal;
import org.task.abstracts.AnimalDescription;
import org.task.abstracts.Food;
import org.task.enums.MeatEater;
import org.task.models.utils.AnimalsHelper;

import java.util.Objects;

@Getter
@ToString
public class MeatEaterAnimal extends Animal {

    private final MeatEater type;

    /**
     * Parameterized constructor.
     *
     * @param type The value that will be set to this {@link #MeatEaterAnimal} instance.
     */

    public MeatEaterAnimal(MeatEater type) {
        if (type == null) throw new IllegalArgumentException("This type can't be null");
        this.type = type;
    }

    /**
     * Animal can't eat itself
     *
     * @param food All animals implement Food, needed to check, what animal try to eat
     * @return The result will be a value that inform about has animal eaten other animal or plant
     */

    @Override
    public String eat(Food food) {
        if (food instanceof Animal) {
            return food.consume(getType());
        } else {
            return AnimalsHelper.NOT_EAT;
        }
    }

    /**
     * Animal can't eat itself
     *
     * @param animalDescription The value that needed to identify the type of animal
     * @return The result will be a value that inform about has animal been eaten or not
     */

    @Override
    public String consume(AnimalDescription animalDescription) {
        if (Objects.equals(getType().getName(), animalDescription.getName())) {
            return AnimalsHelper.HAS_NOT_BEEN_EATEN + " " + animalDescription.getName();
        } else {
            return getType().getName() + " " +
                    AnimalsHelper.HAS_BEEN_EATEN + " " + animalDescription.getName();
        }
    }
}
