package app_utils.ktteam.src.UI.Homes.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import app_utils.ktteam.src.Apis.ApiService;
import app_utils.ktteam.src.Apis.Prototypes.DataListRepairerDistanceApiResponse;
import app_utils.ktteam.src.Data.RepaierDistance;
import app_utils.ktteam.src.R;
import app_utils.ktteam.src.UI.Homes.Adapters.RepairerArroundAdapter;
import app_utils.ktteam.src.Utils.InformationUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuaDienFragment extends Fragment {

    ListView listViewSuaDien;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sua_dien,container,false);
        // ánh xạ
        listViewSuaDien = view.findViewById(R.id.listViewSuaDien);
        // gọi api lấy dữ liệu, đồng thời tạo và setdapter cho view
        getAndSetUpListRepairerDistance();

        return  view;
    }

    private void getAndSetUpListRepairerDistance() {

        try {
            String diaChi = InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileDiaChi));
            ApiService.apiService.getRepairerArround(diaChi).enqueue(new Callback<DataListRepairerDistanceApiResponse>() {
                @Override
                public void onResponse(Call<DataListRepairerDistanceApiResponse> call, Response<DataListRepairerDistanceApiResponse> response) {
                    DataListRepairerDistanceApiResponse res = response.body();
                    if(res != null && res.isSuccess())
                    {
                        RepairerArroundAdapter adapter = new RepairerArroundAdapter(getActivity(),R.layout.sua_dien_row_repairer,res.getData());
                        listViewSuaDien.setAdapter(adapter);
                        return;
                    }
                    Toast.makeText(getActivity(),"Không tìm thấy dữ liệu",Toast.LENGTH_LONG);
                }

                @Override
                public void onFailure(Call<DataListRepairerDistanceApiResponse> call, Throwable t) {
                    System.out.println("Có lỗi xảy ra");
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
