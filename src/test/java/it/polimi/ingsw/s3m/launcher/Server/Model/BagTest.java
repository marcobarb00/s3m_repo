package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void returnNumberOfStudentsAfterPickingOne() {
        Bag bag = new Bag();
        assertNotNull(bag);
        assertEquals(130, bag.getNumberOfStudents());
        Student student = null;
        try {
            student = bag.pickStudent();
        } catch (EmptyBagException e) {
            System.out.println("Error: empty bag");
        }
        assertEquals(25, bag.getStudents().get(student.getColor()));
        assertEquals(129, bag.getNumberOfStudents());
    }

    @Test
    void emptyBagAfterPickingAllStudents() {
        Bag bag = new Bag();
        assertEquals(130, bag.getNumberOfStudents());
        for (int i = 0; i < 130; i++) {
            try {
                bag.pickStudent();
            } catch (EmptyBagException e) {
                System.out.println("Error: empty bag");
            }
        }
        assertEquals(0, bag.getNumberOfStudents());

        //TODO review this assertion
        Class<? extends Throwable> EmptyBagException = null;
        try {
            assertThrows(EmptyBagException, (Executable) bag.pickStudent());
        } catch (it.polimi.ingsw.s3m.launcher.Server.Exception.EmptyBagException e) {
            e.printStackTrace();
        }

    }

}