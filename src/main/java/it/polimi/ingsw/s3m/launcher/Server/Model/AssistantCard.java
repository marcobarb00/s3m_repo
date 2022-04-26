package it.polimi.ingsw.s3m.launcher.Server.Model;

/**
 * Enum class that manages Assistant types.
 * "Maybe" no need for AssistantCard class.
 *
 */

public enum AssistantCard {

    EAGLE(7, 4, "eagle"), DOG(3, 2, "dog"),
    ELEPHANT(2, 1, "elephant"), CAT(8, 4, "cat"),
    CHEETAH(10, 5, "cheetah"), LIZARD(5, 3, "lizard"),
    OCTOPUS(4, 2, "octopus"), OSTRICH(9, 5, "ostrich"),
    TURTLE(1, 1, "turtle"), FOX(6, 3, "fox");

    private final int value;
    private final int movements;
    private final String type;

    AssistantCard(int value, int movements, String type) {
        this.value = value;
        this.movements = movements;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public int getMovements() {
        return movements;
    }

    public String getType() {
        return type;
    }
}
