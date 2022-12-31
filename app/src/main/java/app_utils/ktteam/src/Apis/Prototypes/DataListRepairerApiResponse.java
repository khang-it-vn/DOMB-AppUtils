package app_utils.ktteam.src.Apis.Prototypes;

import java.util.ArrayList;

import app_utils.ktteam.src.Data.Repairer;


public class DataListRepairerApiResponse extends ApiResponse{
    private ArrayList<Repairer> data;

    public DataListRepairerApiResponse() {
    }

    public DataListRepairerApiResponse(boolean success, String message, ArrayList<Repairer> data) {
        super(success, message);
        this.data = data;
    }

    public ArrayList<Repairer> getData() {
        return data;
    }

    public void setData(ArrayList<Repairer> data) {
        this.data = data;
    }
}
