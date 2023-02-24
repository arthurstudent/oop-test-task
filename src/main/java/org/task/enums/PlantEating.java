package org.task.enums;

import org.task.abstracts.AnimalDescription;

public enum PlantEating implements AnimalDescription {
    COW("Cow"),
    GOAT("Goat");

    private final String name;
    PlantEating(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
