package it.polimi.ingsw.s3m.launcher.Server.Model.GameElements;

public enum AssistantCard{
	TURTLE("Turtle", 1, 1),
	ELEPHANT("Elephant", 2, 1),
	DOG("Dog", 3, 2),
	OCTOPUS("Octopus", 4, 2),
	LIZARD("Lizard", 5, 3),
	FOX("Fox", 6, 3),
	EAGLE("Eagle", 7, 4),
	CAT("Cat", 8, 4),
	OSTRICH("Ostrich", 9, 5),
	CHEETAH("Cheetah", 10, 5);

	private final String type;
	private final int value;
	private final int movements;

	AssistantCard(String type, int value, int movements){
		this.type = type;
		this.value = value;
		this.movements = movements;
	}

	// GETTER
	public String getType(){
		return type;
	}

	public int getValue(){
		return value;
	}

	public int getMovements(){
		return movements;
	}
}
