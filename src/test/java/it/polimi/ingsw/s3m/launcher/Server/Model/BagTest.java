package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void returnNumberOfStudents() {
        Bag bag = new Bag();
        assertEquals(130, bag.returnNumberOfStudents());
        Student student = bag.pickStudent();
        assertEquals(25, bag.getStudents().get(student.getColor()));
    }

}