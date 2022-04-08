package it.polimi.ingsw.s3m.launcher.Server.Model;

import java.util.*;
import java.time.*;


public interface Deck {

    void draw();            //Method draws cards to each player
    void shuffle();         //Method shuffles cards to each player

}