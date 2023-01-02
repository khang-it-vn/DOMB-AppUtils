package app_utils.ktteam.src.Apis.Prototypes;

import java.util.ArrayList;

import app_utils.ktteam.src.Data.RepaierDistance;

public class DataListRepairerDistanceApiResponse extends  ApiResponse{
    private ArrayList<RepaierDistance> data;

    public DataListRepairerDistanceApiResponse(boolean success, String message, ArrayList<RepaierDistance> data) {
        super(success, message);
        this.data = data;
    }

    public DataListRepairerDistanceApiResponse() {
    }

    public ArrayList<RepaierDistance> getData() {
        return data;
    }

    public void setData(ArrayList<RepaierDistance> data) {
        this.data = data;
    }
}
