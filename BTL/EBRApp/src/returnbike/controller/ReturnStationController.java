package returnbike.controller;

import abstractdata.gui.ADataListPane;
import returnbike.gui.ReturnListStationPane;
import station.controller.StationController;


public class ReturnStationController extends StationController {
    private ViewRentingBikeController viewRentingBikeController;

    public ReturnStationController(ViewRentingBikeController controller) {
        viewRentingBikeController = controller;
    }

    @Override
    public ADataListPane createListPane() {
        return new ReturnListStationPane(this);
    }

    public void getSelectStationID(String id) {
        viewRentingBikeController.setSelectedStationID(id);
    }
}
