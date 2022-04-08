package Model;

/**
 * Enum class that manages Assistant types.
 * "Maybe" no need for AssistantCard class.
 *
 */

public enum AssistantCard {
    EAGLE(7,4), DOG(3,2), ELEPHANT(2,1),
    CAT(8,4), CHEETAH(10,5), LIZARD(5,3),
    OCTOPUS(4,2), OSTRICH(9,5), TURTLE(1,1),
    FOX(6,3);

    private final int value;
    private final int movements;

    AssistantCard(int value, int movements) {
        this.value = value;
        this.movements = movements;
    }

    public int getValue() {
        return value;
    }

    public int getMovements() {
        return movements;
    }
}
