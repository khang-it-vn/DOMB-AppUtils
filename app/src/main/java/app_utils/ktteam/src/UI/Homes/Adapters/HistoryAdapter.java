package app_utils.ktteam.src.UI.Homes.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app_utils.ktteam.src.ENVIROMENT;
import app_utils.ktteam.src.Entities.ERepaierDistance;
import app_utils.ktteam.src.R;
import app_utils.ktteam.src.Utils.LoadImageUtil;

public class HistoryAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<ERepaierDistance> repaierDistances;

    public HistoryAdapter(Context context, int layout, ArrayList<ERepaierDistance> repaierDistances) {
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

        ERepaierDistance repaierDistance = repaierDistances.get(i);

        TextView txtHoTenHistory = view.findViewById(R.id.txtHoTenHistory);
        Button btnPhoneHistory = view.findViewById(R.id.btnPhoneHistory);
        ImageButton imgButtonMapHistory = view.findViewById(R.id.imgButtonMapHistory);
        ImageView imgViewAvatarHistory = view.findViewById(R.id.imgViewAvatarHistory);

        setImage(imgViewAvatarHistory,repaierDistance.getAvatar());
        txtHoTenHistory.setText(repaierDistance.getHoTen());

        btnPhoneHistory.setText(repaierDistance.getNumberPhone());

        btnPhoneHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +repaierDistance.getNumberPhone()));
                context.startActivity(intent);
            }
        });

        imgButtonMapHistory.setOnClickListener(new View.OnClickListener() {
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
        return view;
    }
    private void setImage( ImageView img, String avatar) {
        LoadImageUtil.loadImageFor(new LoadImageUtil(img, ENVIROMENT.DOMAIN_GET_IMAGE,avatar));
    }
}
