package org.task.models;

import org.task.abstracts.AnimalDescription;
import org.task.abstracts.Plants;
import org.task.utils.Utils;

public class Grass extends Plants {
    @Override
    public String consume(AnimalDescription animalDescription) {
        return Utils.HAS_BEEN_EATEN + " " + animalDescription.getName();
    }
}
