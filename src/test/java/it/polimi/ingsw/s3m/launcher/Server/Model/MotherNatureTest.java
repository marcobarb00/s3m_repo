package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MotherNatureTest {

    @Test
    void setCurrentPosition() {
        ArrayList<Island> islands = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            islands.add(new Island(i+1));
        }
        MotherNature motherNature = new MotherNature();
        assertEquals(0, motherNature.getCurrentPosition());
        motherNature.setCurrentPosition(1, islands);
        assertEquals(1, motherNature.getCurrentPosition());
        motherNature.setCurrentPosition(2, islands);
        assertEquals(0, motherNature.getCurrentPosition());
        motherNature.setCurrentPosition(4, islands);
        assertEquals(1, motherNature.getCurrentPosition());
    }
}