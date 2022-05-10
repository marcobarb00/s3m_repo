package it.polimi.ingsw.s3m.launcher.Server.Model;

import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.Dashboard;
import it.polimi.ingsw.s3m.launcher.Server.Model.GameElements.PawnColor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DashboardTest {
    @Test
    void newDashboardEntranceAndTablesAreEmpty() {
        Dashboard dashboard = new Dashboard();
        for (PawnColor color : PawnColor.values()) {
            assertEquals(0, dashboard.getEntrance().get(color));
            assertEquals(0, dashboard.getTables().get(color));
        }
    }

    @Test
    void newDashboardNumberOfTowersEqualsZero() {
        Dashboard dashboard = new Dashboard();
        assertEquals(0, dashboard.getNumberOfTowers());
    }

    @Test
    void DashboardNumberOfTowersLogic() {
        Dashboard dashboard = new Dashboard();
        dashboard.setNumberOfTowers(6);
        assertEquals(6, dashboard.getNumberOfTowers());

        dashboard.incrementTowers();
        assertEquals(7, dashboard.getNumberOfTowers());

        dashboard.decrementTowers();
        dashboard.decrementTowers();
        assertEquals(5, dashboard.getNumberOfTowers());
    }
}