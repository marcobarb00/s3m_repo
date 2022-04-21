package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Test
    void changePlayer() {
        Professor professor = new Professor(PawnColor.BLUE);
        assertNull(professor.getPlayer());
        Player pippo = new Player("Pippo");
        professor.changePlayer(pippo);
        assertEquals(pippo, professor.getPlayer());
        assertNotNull(professor.getPlayer());
    }

}