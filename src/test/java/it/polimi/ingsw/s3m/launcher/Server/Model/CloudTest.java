package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Cloud;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Student;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CloudTest {
    @Test
    void emptyStudentsArrayListAfterReturnOfStudents() {
        Cloud cloud = new Cloud();
        ArrayList<Student> refillingCloudStudents = new ArrayList<>();
        refillingCloudStudents.add(new Student(PawnColor.BLUE));
        refillingCloudStudents.add(new Student(PawnColor.GREEN));
        refillingCloudStudents.add(new Student(PawnColor.PINK));
        cloud.setStudents(refillingCloudStudents);
        assertEquals(3, cloud.getStudents().size());

        cloud.returnStudents();
        assertEquals(0, cloud.getStudents().size());
    }

    @Test
    void newCloudStudentsArrayListIsEmpty() {
        Cloud cloud = new Cloud();
        assertEquals(0, cloud.getStudents().size());
    }
}