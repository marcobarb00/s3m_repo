package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Bag;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BagTest {
    @Test
    void bagDecreasingNumberOfStudentsAfterExtractionForEachColor() {
        Bag bag = new Bag();
        Student extractedStudent;
        PawnColor studentColor;

        // Blue
        extractedStudent = new Student(PawnColor.BLUE);
        studentColor = extractedStudent.getColor();
        bag.decrementStudentsColor(extractedStudent);
        assertEquals(119, bag.getTotalNumberOfStudents());
        assertEquals(23, bag.getStudents().get(studentColor));

        // Green
        extractedStudent = new Student(PawnColor.GREEN);
        studentColor = extractedStudent.getColor();
        bag.decrementStudentsColor(extractedStudent);
        assertEquals(118, bag.getTotalNumberOfStudents());
        assertEquals(23, bag.getStudents().get(studentColor));

        // Pink
        extractedStudent = new Student(PawnColor.PINK);
        studentColor = extractedStudent.getColor();
        bag.decrementStudentsColor(extractedStudent);
        assertEquals(117, bag.getTotalNumberOfStudents());
        assertEquals(23, bag.getStudents().get(studentColor));

        // Red
        extractedStudent = new Student(PawnColor.RED);
        studentColor = extractedStudent.getColor();
        bag.decrementStudentsColor(extractedStudent);
        assertEquals(116, bag.getTotalNumberOfStudents());
        assertEquals(23, bag.getStudents().get(studentColor));

        // Yellow
        extractedStudent = new Student(PawnColor.YELLOW);
        studentColor = extractedStudent.getColor();
        bag.decrementStudentsColor(extractedStudent);
        assertEquals(115, bag.getTotalNumberOfStudents());
        assertEquals(23, bag.getStudents().get(studentColor));
    }

    @Test
    void newBagSumOfStudentsEquals120() {
        Bag bag = new Bag();
        assertEquals(120, bag.getTotalNumberOfStudents());
    }

    @Test
    void zeroRedStudentsLeft() {
        Bag bag = new Bag();
        PawnColor red = PawnColor.RED;
        assertEquals(24, bag.getStudents().get(red));

        for (int i = 0; i < 24; i++)
            bag.decrementStudentsColor(new Student(red));
        assertEquals(0, bag.getStudents().get(red));
    }
}