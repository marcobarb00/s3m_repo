package it.polimi.ingsw.s3m.launcher.Server.Controller;

import java.util.ArrayList;

public class RoomsController {
    private RoomsController instance = null;
    private ArrayList<Room> rooms = new ArrayList<>();

    private RoomsController() {
        instance = new RoomsController();
    }

    public RoomsController instance(){
        if(instance == null)
            return new RoomsController();
        else
            return instance;
    }
}
