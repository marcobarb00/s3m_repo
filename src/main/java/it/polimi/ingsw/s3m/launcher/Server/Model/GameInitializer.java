package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;

import java.util.ArrayList;

public class GameInitializer {
    private Game game;
    private ArrayList<Student> firstStudentsOnIslands;

    public GameInitializer (Game game) {
        this.game = game;
        // Initializing first students on islands
        firstStudentsOnIslands = new ArrayList<>();
        for (PawnColor color : PawnColor.values()) {
            firstStudentsOnIslands.add(new Student(color));
            firstStudentsOnIslands.add(new Student(color));
        }
        islandsSetup();
        // Pick character cards
        characterCardsSetup();
        // Inserting students in the hall of the Dashboard of each Player
        studentsInHallSetup();
    }

    public void islandsSetup() {
        for (int i = 0; i < game.getIslandsList().size(); i++) {
            if (i == 0) {
                game.getIslandsList().get(i).setNextIsland(game.getIslandsList().get(i+1));
                game.getIslandsList().get(i).setPreviousIsland(game.getIslandsList().get(11));
            } else if (i == 11) {
                game.getIslandsList().get(i).setNextIsland(game.getIslandsList().get(0));
                game.getIslandsList().get(i).setPreviousIsland(game.getIslandsList().get(i-1));
            } else {
                game.getIslandsList().get(i).setNextIsland(game.getIslandsList().get(i+1));
                game.getIslandsList().get(i).setPreviousIsland(game.getIslandsList().get(i-1));
            }
            if (i != 0 && i != 6) {
                Student student = extractStudent(firstStudentsOnIslands);
                game.getIslandsList().get(i).addStudent(student);
            }
        }
    }

    private Student extractStudent(ArrayList<Student> students) {
        Student returnedStudent;
        int extractedNumber = (int) (Math.random()*(students.size()));
        returnedStudent = students.get(extractedNumber);
        students.remove(extractedNumber);
        return returnedStudent;
    }

    public void characterCardsSetup() {
        game.setCharacterCardsList(game.getCharacterDeck().drawThreeCharacterCards());
    }

    public void studentsInHallSetup() {
        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            ArrayList<Student> enteringHallStudents = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                try {
                    Student student = game.extractStudent();
                    enteringHallStudents.add(student);
                } catch (EmptyBagException e) {
                    e.printStackTrace();
                }
            }
            game.getPlayersList().get(i).getDashboard().putStudentsInHall(enteringHallStudents);
        }
    }

    public ArrayList<Student> getFirstStudentsOnIslands() { return firstStudentsOnIslands; }

    private ArrayList<Island> getGameIslandsList () { return game.getIslandsList(); }
}
