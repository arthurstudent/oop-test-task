package org.task.models;

import org.task.abstracts.AnimalDescription;
import org.task.abstracts.Plants;
import org.task.models.utils.AnimalsHelper;

public class Grass extends Plants {
    @Override
    public String consume(AnimalDescription animalDescription) {
        return AnimalsHelper.HAS_BEEN_EATEN + " " + animalDescription.getName();
    }
}
