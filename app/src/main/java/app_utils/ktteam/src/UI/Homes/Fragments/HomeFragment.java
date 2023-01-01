package app_utils.ktteam.src.UI.Homes.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import app_utils.ktteam.src.R;

public class HomeFragment  extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        // ánh xạ
        ImageView imgSuaDien = view.findViewById(R.id.imgViewSuaDien);
        ImageView imgSuaNuoc = view.findViewById(R.id.imgViewSuaNuoc);
        ImageView imgSuaXe = view.findViewById(R.id.imgViewSuaXe);
        ImageView imgTramXang = view.findViewById(R.id.imgViewTramXang);
        ImageView imgSuaOto = view.findViewById(R.id.imgViewSuaOto);
        ImageView imgCuuHoOto = view.findViewById(R.id.imgViewCapCuuOto);
        ImageView imgCuuHoXeMay = view.findViewById(R.id.imgViewCapCuuXeMay);

        // set sự kiện
        setImageViewOnClickListener(imgSuaDien, R.id.fragment_home,new SuaDienFragment());
        setImageViewOnClickListener(imgSuaNuoc, R.id.fragment_home,new SuaNuocFragment());
        setImageViewOnClickListener(imgSuaXe, R.id.fragment_home,new SuaXeFragment());
        setImageViewOnClickListener(imgTramXang, R.id.fragment_home,new TramXangFragment());
        setImageViewOnClickListener(imgSuaOto, R.id.fragment_home,new SuaOtoFragment());
        setImageViewOnClickListener(imgCuuHoOto, R.id.fragment_home,new CuuHoOtoFragment());
        setImageViewOnClickListener(imgCuuHoXeMay, R.id.fragment_home,new CuuHoXeMayFragment());

        return view;
    }

    private void setImageViewOnClickListener(ImageView imgClicked, int fragment, Fragment InstanceFragment) {
        imgClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(fragment, InstanceFragment);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.commit();
            }
        });
    }

}
