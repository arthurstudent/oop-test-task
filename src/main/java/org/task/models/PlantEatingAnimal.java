package org.task.models;

import lombok.Getter;
import lombok.ToString;
import org.task.abstracts.Animal;
import org.task.abstracts.AnimalDescription;
import org.task.abstracts.Food;
import org.task.enums.PlantEating;
import org.task.models.utils.AnimalsHelper;

@Getter
@ToString
public class PlantEatingAnimal extends Animal {

    private final PlantEating type;

    /**
     * Parameterized constructor.
     *
     * @param type The value that will be set to this {@link #PlantEatingAnimal} instance.
     */
    public PlantEatingAnimal(PlantEating type) {
        if (type == null) throw new IllegalArgumentException("This type can't be null");
        this.type = type;
    }

    /**
     * Animal can't eat itself
     *
     * @param food All animals implement Food, needed to check, what animal try to eat
     * @return The result will be a value that inform about has animal eaten plant
     */

    @Override
    public String eat(Food food) {
        if (food instanceof Animal) {
            return AnimalsHelper.NOT_EAT;
        } else {
            return food.consume(getType());
        }
    }

    /**
     * Animal can't eat itself
     * Plant eaters can be eaten by meat eater animals
     *
     * @param animalDescription The value that needed to identify the type of animal
     *
     * @return The result will be a value inform about that this animal has been eaten by meat eater
     */

    @Override
    public String consume(AnimalDescription animalDescription) {
        return getType().getName() + " " + AnimalsHelper.HAS_BEEN_EATEN + " " + animalDescription.getName();
    }
}
