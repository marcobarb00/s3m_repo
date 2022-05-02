package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;

import java.util.ArrayList;

public class ThreePlayersGameInitializer extends GameInitializer {

    public ThreePlayersGameInitializer (Game game, ArrayList<String> playersNicknames) {
        super(game);
        playersSetup(playersNicknames);
        dashboardsSetup();
        studentsInHallSetup();
        cloudsSetup();
        islandsSetup();
    }

    @Override
    public void playersSetup(ArrayList<String> nicknames) {
        String firstPlayerNickname = nicknames.get(0);
        String secondPlayerNickname = nicknames.get(1);
        String thirdPlayerNickname = nicknames.get(2);
        game.getPlayerHashMap().put(firstPlayerNickname, new Player(firstPlayerNickname, TowerColor.WHITE));
        game.getPlayerHashMap().put(secondPlayerNickname, new Player(secondPlayerNickname, TowerColor.BLACK));
        game.getPlayerHashMap().put(thirdPlayerNickname, new Player(thirdPlayerNickname, TowerColor.GREY));
    }

    @Override
    public void dashboardsSetup() {
        for (Player player : game. getPlayerHashMap().values()) {
            player.getDashboard().setNumberOfTowers(6);
        }
    }

    @Override
    public void studentsInHallSetup() {
        for (Player player : game.getPlayerHashMap().values()) {
            ArrayList<Student> enteringHallStudents = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                try {
                    Student student = game.extractStudent();
                    enteringHallStudents.add(student);
                } catch (EmptyBagException e) {
                    e.printStackTrace();
                }
            }
            player.getDashboard().addStudentsInEntrance(enteringHallStudents);
        }
    }

    @Override
    public void cloudsSetup() {
        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            game.refillCloudStudents(game.getCloudsList().get(i), 4);
        }
    }
}
