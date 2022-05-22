package it.polimi.ingsw.s3m.launcher.DTOs;

import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.AssistantCard;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MapperTest{
	Mapper mapper;

	@BeforeEach
	void mapperSetup(){
		mapper = new Mapper();
	}

	// stringToColor
	@Test
	void nullColorStringReturnsNull(){
		assertNull(mapper.stringToColor(null));
	}

	@Test
	void lowercaseRedColorStringReturnsRedPawnColor(){
		PawnColor color = mapper.stringToColor("red");
		assertEquals(PawnColor.RED, color);
	}

	@Test
	void uppercaseBlueColorStringReturnsBluePawnColor(){
		PawnColor color = mapper.stringToColor("BLUE");
		assertEquals(PawnColor.BLUE, color);
	}

	@Test
	void upperAndLowercaseGreenColorStringReturnsGreenPawnColor(){
		PawnColor color = mapper.stringToColor("gReeN");
		assertEquals(PawnColor.GREEN, color);
	}

	@Test
	void yellowColorStringReturnsYellowPawnColor(){
		PawnColor color = mapper.stringToColor("Yellow");
		assertEquals(PawnColor.YELLOW, color);
	}

	@Test
	void pinkColorStringReturnsPinkPawnColor(){
		PawnColor color = mapper.stringToColor("Pink");
		assertEquals(PawnColor.PINK, color);
	}

	@Test
	void incorrectInputStringReturnsNull(){
		assertNull(mapper.stringToColor("Yellow6"));
	}


	// stringListToColor
	@Test
	void nullColorStringListReturnsNull(){
		assertNull(mapper.stringListToColor(null));
	}

	@Test
	void colorStringListSizeEquals0ReturnsAnEmptyArray(){
		ArrayList<String> colorStringList = new ArrayList<>();
		ArrayList<PawnColor> colors = mapper.stringListToColor(colorStringList);
		assertEquals(0, colors.size());
	}

	@Test
	void colorStringListContainingOneStringPerColorReturnsAnArrayWithOnePawnColorPerColor(){
		ArrayList<String> colorStringList = new ArrayList<>();
		colorStringList.add("Blue");
		colorStringList.add("Green");
		colorStringList.add("Pink");
		colorStringList.add("Red");
		colorStringList.add("Yellow");

		ArrayList<PawnColor> colors = mapper.stringListToColor(colorStringList);
		assertEquals(5, colors.size());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.BLUE).count());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.GREEN).count());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.PINK).count());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.RED).count());
		assertEquals(1, colors.stream().filter(color -> color == PawnColor.YELLOW).count());
	}


	// assistantCardToDTO
	@Test
	void assistantCardToDTOWithNullAssistantCardCreatesANullTypeAssistantCard(){
		AssistantCardDTO assistantCardDTO = mapper.assistantCardToDTO(null);
		assertNull(assistantCardDTO.getType());
		assertEquals(0, assistantCardDTO.getValue());
		assertEquals(0, assistantCardDTO.getMovements());
	}

	@Test
	void assistantCardToDTOWithDogAssistantCardReturnsAValidAssistantCard(){
		AssistantCardDTO assistantCardDTO = mapper.assistantCardToDTO(AssistantCard.DOG);
		assertEquals("Dog", assistantCardDTO.getType());
		assertEquals(3, assistantCardDTO.getValue());
		assertEquals(2, assistantCardDTO.getMovements());
	}


	// assistantCardListToDTO
	@Test
	void nullAssistantCardListReturnsNull(){
		assertNull(mapper.assistantCardListToDTO(null));
	}

	@Test
	void assistantCardListSizeEquals0ReturnsAnEmptyArray(){
		ArrayList<AssistantCard> assistantCards = new ArrayList<>();

		ArrayList<AssistantCardDTO> assistantCardDTOS = mapper.assistantCardListToDTO(assistantCards);
		assertEquals(0, assistantCardDTOS.size());
	}

	@Test
	void assistantCardListContainingTwoAssistantCardReturnsAnArrayWithLengthEqualsTwo(){
		ArrayList<AssistantCard> assistantCards = new ArrayList<>();
		assistantCards.add(AssistantCard.TURTLE);
		assistantCards.add(AssistantCard.ELEPHANT);

		ArrayList<AssistantCardDTO> assistantCardDTOS = mapper.assistantCardListToDTO(assistantCards);
		assertEquals(2, assistantCardDTOS.size());
		assertEquals("Turtle", assistantCardDTOS.get(0).getType());
		assertEquals("Elephant", assistantCardDTOS.get(1).getType());
	}


	// dashboardToDTO








	@Test
	void playerToDTO(){
	}

	@Test
	void playerListToDTO(){
	}

	@Test
	void playerHashMapToDTO(){
	}

	@Test
	void islandToDTO(){
	}

	@Test
	void islandListToDTO(){
	}

	@Test
	void characterCardToDTO(){
	}

	@Test
	void characterCardListToDTO(){
	}

	@Test
	void cloudToDTO(){
	}

	@Test
	void cloudListToDTO(){
	}

	@Test
	void gameToDTO(){
	}
}