package org.task.enums;

import org.task.abstracts.AnimalDescription;

/**
 * This Enum implements AnimalDescription to describe, which animal ate plants
 */

public enum PlantEating implements AnimalDescription {
    COW("Cow"),
    GOAT("Goat");

    private final String name;

    PlantEating(String name) {
        this.name = name;
    }

    /**
     * Implementation of AnimalDescription
     *
     * @return The result will be a value that inform about animal type
     */

    public String getName() {
        return name;
    }
}
