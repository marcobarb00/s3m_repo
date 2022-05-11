package it.polimi.ingsw.s3m.launcher.Server.Model.Initializers;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import it.polimi.ingsw.s3m.launcher.Server.Model.CharacterCards.*;
import it.polimi.ingsw.s3m.launcher.Server.Model.Game;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Player;

public class ExpertModeInitializer{
	private final Game game;

	/**
	 * Constructor used to initialize a game in expert mode: give one coin to
	 * each player and draw three character cards
	 *
	 * @param game game to initialize to expert mode
	 */
	public ExpertModeInitializer(Game game) throws EmptyBagException {
		this.game = game;
		playersUpdate();
		// Character cards
		game.getCharacterCardsList().add(new Centaur());
		game.getCharacterCardsList().add(new Jester());
		game.getCharacterCardsList().add(new Knight());
		game.getCharacterCardsList().add(new MagicPostman());
		game.getCharacterCardsList().add(new Minstrel());
		game.getCharacterCardsList().add(new Mushroomer());
		characterCardsSetup();
	}

	/**
	 * Method used to give one coin to each player of the game
	 */
	public void playersUpdate(){
		for(Player player : game.getPlayerHashMap().values()){
			player.addCoins(1);
		}
	}

	/**
	 * Method used to draw three character cards and to initialize the
	 * Jester character card if present
	 */
	public void characterCardsSetup() throws EmptyBagException {
		game.drawThreeCharacterCards();
		for(CharacterCard characterCard : game.getCharacterCardsList()){
			if(characterCard instanceof Jester){
				game.initializeJesterStudents((Jester) characterCard);
			}
		}
	}
}
