package it.polimi.ingsw.s3m.launcher.Server.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class DashboardTest {
    /* @Test
    void moveStudentFromHallToTables() throws Exception {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(PawnColor.BLUE));
        students.add(new Student(PawnColor.BLUE));
        students.add(new Student(PawnColor.RED));

        ArrayList<Student> hall = new ArrayList<>();
        hall.add(new Student(PawnColor.BLUE));
        hall.add(new Student(PawnColor.BLUE));
        hall.add(new Student(PawnColor.RED));
        hall.add(new Student(PawnColor.RED));
        hall.add(new Student(PawnColor.PINK));
        hall.add(new Student(PawnColor.YELLOW));
        hall.add(new Student(PawnColor.GREEN));

        Dashboard dashboard = new Dashboard();
        dashboard.putStudentsInHall(hall);

        dashboard.moveStudentsFromHallToTables(students);
        assertEquals(2, dashboard.getTables(PawnColor.BLUE));                 //blue
        assertEquals(0, dashboard.getHall().stream().filter( a -> a.getColor() == PawnColor.BLUE).count());            //blue

        assertEquals(0, dashboard.getTables(PawnColor.GREEN));
        assertEquals(1, dashboard.getHall().stream().filter( a -> a.getColor() == PawnColor.GREEN).count());

        assertEquals(1, dashboard.getTables(PawnColor.RED));
        assertEquals(1, dashboard.getHall().stream().filter( a -> a.getColor() == PawnColor.RED).count());

        assertEquals(0, dashboard.getTables(PawnColor.YELLOW));
        assertEquals(1, dashboard.getHall().stream().filter( a -> a.getColor() == PawnColor.YELLOW).count());

        //testing the exceptions students empty arraylist
        Exception e = assertThrows(Exception.class,() -> dashboard.moveStudentsFromHallToTables(new ArrayList<>()));
        assertEquals("Empty hall or students", e.getMessage());

        hall = new ArrayList<>();
        hall.add(new Student(PawnColor.BLUE));
        hall.add(new Student(PawnColor.RED));
        hall.add(new Student(PawnColor.RED));
        hall.add(new Student(PawnColor.PINK));
        hall.add(new Student(PawnColor.YELLOW));
        hall.add(new Student(PawnColor.GREEN));

        //testing if student not in hall exception
        e = assertThrows(Exception.class,() -> dashboard.moveStudentsFromHallToTables(students));
        assertEquals("No such student in hall", e.getMessage());

    }

    @Test
    void putStudentsInHall() {
        ArrayList<Student> hall = new ArrayList<>();
        hall.add(new Student(PawnColor.BLUE));
        hall.add(new Student(PawnColor.BLUE));
        hall.add(new Student(PawnColor.BLUE));
        hall.add(new Student(PawnColor.GREEN));

        Dashboard dashboard = new Dashboard();
        dashboard.putStudentsInHall(hall);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(PawnColor.YELLOW));
        students.add(new Student(PawnColor.RED));
        students.add(new Student(PawnColor.RED));

        dashboard.putStudentsInHall(students);
        assertEquals(1, dashboard.getHall().stream().filter( a -> a.getColor() == PawnColor.GREEN).count());
        assertEquals(3, dashboard.getHall().stream().filter( a -> a.getColor() == PawnColor.BLUE).count());
        assertEquals(2, dashboard.getHall().stream().filter( a -> a.getColor() == PawnColor.RED).count());
        assertEquals(1, dashboard.getHall().stream().filter( a -> a.getColor() == PawnColor.YELLOW).count());
        assertEquals(0, dashboard.getHall().stream().filter( a -> a.getColor() == PawnColor.PINK).count());
    } */
}