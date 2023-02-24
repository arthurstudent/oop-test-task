package org.task.enums;

import org.task.abstracts.AnimalDescription;

/**
 * This Enum implements AnimalDescription to describe, which animal ate other animals or plants
 */
public enum MeatEater implements AnimalDescription {
    LION("Lion");

    private final String name;

    MeatEater(String name) {
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
