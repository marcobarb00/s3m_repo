package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CloudTest {

    @Test
    void returnThreeStudents() {
        Cloud cloud = new Cloud();
        ArrayList<Student> setStudents = new ArrayList<>();
        ArrayList<Student> returnedStudents;
        returnedStudents = cloud.returnStudents();
        assertNull(returnedStudents);
        setStudents.add(new Student(PawnColor.BLUE));
        setStudents.add(new Student(PawnColor.GREEN));
        cloud.setStudents(setStudents);
        assertEquals(2, cloud.getStudents().size());
        returnedStudents = cloud.returnStudents();
        assertNull(returnedStudents);
        setStudents.add(new Student(PawnColor.PINK));
        assertEquals(3, cloud.getStudents().size());
        returnedStudents = cloud.returnStudents();
        assertEquals(3, returnedStudents.size());
        assertEquals(0, cloud.getStudents().size());
    }
}