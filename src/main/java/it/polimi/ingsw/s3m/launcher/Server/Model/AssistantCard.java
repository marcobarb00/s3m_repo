package it.polimi.ingsw.s3m.launcher.Server.Model;

public enum AssistantCard {

    CHEETAH     (1, 1, "cheetah"),
    OSTRICH     (2, 1, "ostrich"),
    CAT         (3, 2, "cat"),
    EAGLE       (4, 2, "eagle"),
    FOX         (5, 3, "fox"),
    LIZARD      (6, 3, "lizard"),
    OCTOPUS     (7, 4, "octopus"),
    DOG         (8, 4, "dog"),
    ELEPHANT    (9, 5, "elephant"),
    TURTLE      (10, 5, "turtle");


    private final String type;
    private final int value;
    private int movements;

    AssistantCard(int value, int movements, String type) {
        this.type = type;
        this.value = value;
        this.movements = movements;
    }

    public void incrementMovementsByTwo() { movements += 2; }

    // GETTER
    public String getType() { return type; }
    public int getValue() { return value; }
    public int getMovements() { return movements; }
}
