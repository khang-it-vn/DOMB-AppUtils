package app_utils.ktteam.src.UI.Homes.Adapters;

import android.content.Context;
import android.content.Intent;;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;


import app_utils.ktteam.src.Data.RepaierDistance;
import app_utils.ktteam.src.DatabaseContext.RepairerDatabase;
import app_utils.ktteam.src.Entities.ERepaierDistance;
import app_utils.ktteam.src.R;

public class RepairerArroundAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<RepaierDistance> repaierDistances;

    public RepairerArroundAdapter(Context context, int layout, ArrayList<RepaierDistance> repaierDistances) {
        this.context = context;
        this.layout = layout;
        this.repaierDistances = repaierDistances;
    }

    @Override
    public int getCount() {
        return repaierDistances.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        //Ánh xạ
        TextView txtTenThoSua = view.findViewById(R.id.txtHoTenSuaDien);
        TextView txtKhoangCach = view.findViewById(R.id.txtKhoangCachSuaDien);
        Button btnCallSuaDien = view.findViewById(R.id.btnCallSuaDien);

        RepaierDistance repaierDistance = repaierDistances.get(i);
        txtTenThoSua.setText(repaierDistance.getHoTen());
        // làm tròn khoảng cách về 2 chữ số thập phân
        double roundOff = Math.round(repaierDistance.getDistance() * 100.0) / 100.0;
        txtKhoangCach.setText( roundOff+ " m");

        txtKhoangCach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri gmmIntentUri = Uri.parse("google.streetview:cbll="+repaierDistance.getLatitude()+"," +repaierDistance.getLongitude());

                // Intent.ACTION_VIEW, với phương thức này, mục đích là hiển thị thông tin cho người dùng

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // set packet sử dụng cho mapintent
                mapIntent.setPackage("com.google.android.apps.maps");


                context.startActivity(mapIntent);
            }
        });

        btnCallSuaDien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveToSqlLite(repaierDistance);
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +repaierDistance.getNumberPhone()));
                context.startActivity(intent);
            }
        });
        return view;
    }

    private void saveToSqlLite(RepaierDistance repaierDistance) {
        ERepaierDistance eRepaierDistance = new ERepaierDistance(
                repaierDistance.getId().toString(),
                repaierDistance.getDistance(),
                repaierDistance.isTrangThaiHoatDong(),
                repaierDistance.getLatitude(),
                repaierDistance.getLongitude(),
                repaierDistance.getHoTen(),
                repaierDistance.getDiaChi(),
                repaierDistance.isGioiTinh(),
                repaierDistance.getDob().toLocaleString(),
                repaierDistance.getNumberPhone(),
                repaierDistance.getEmail(),
                repaierDistance.getAvatar(),
                repaierDistance.getMatKhau()
        );

        try
        {
            RepairerDatabase.getInstance(context.getApplicationContext()).repairerDao().insertRepairer(eRepaierDistance);
            System.out.println("insert database success");
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


}
