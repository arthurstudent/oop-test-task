package org.task.enums;

import org.task.abstracts.AnimalDescription;

public enum MeatEater implements AnimalDescription {
    LION("Lion");

    private final String name;
    MeatEater(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
