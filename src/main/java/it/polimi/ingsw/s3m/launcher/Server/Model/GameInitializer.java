package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.ArrayList;

public abstract class GameInitializer {
    Game game;

    public GameInitializer(Game game) {
        this.game = game;
    }

    // Abstract methods
    public abstract void playersSetup(ArrayList<String> nicknames);
    public abstract void dashboardsSetup();
    public abstract void studentsInEntranceSetup();

    // Common method islandsSetup
    public void islandsSetup() {
        ArrayList<Student> firstStudentsOnIslands = new ArrayList<>();
        for (PawnColor color : PawnColor.values()) {
            firstStudentsOnIslands.add(new Student(color));
            firstStudentsOnIslands.add(new Student(color));
        }
        for (int i = 0; i < game.getIslandsList().size(); i++) {
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
}
