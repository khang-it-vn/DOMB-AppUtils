package app_utils.ktteam.src.UI.Homes.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import java.io.FileNotFoundException;
import app_utils.ktteam.src.R;
import app_utils.ktteam.src.Utils.InformationUtil;

public class ProfileFragment extends Fragment {
    ImageView imgEditProfile;
    TextView txtNameProfile, txtDiaChiProfile, txtSDTProfile, txtEmailProfile;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        init(view);
        setImageViewOnClickListener(imgEditProfile, R.id.fragment_profile,new EditProfileFragment());
        return view;
    }

    public  void init(View view){
        imgEditProfile = view.findViewById(R.id.imgEditProfile);
        txtDiaChiProfile = view.findViewById(R.id.txtDiaChiProFile);
        txtNameProfile = view.findViewById(R.id.txtNameProfile);
        txtSDTProfile = view.findViewById(R.id.txtPhoneProfile);
        txtEmailProfile = view.findViewById(R.id.txtEmailProfile);
        try {
            txtDiaChiProfile.setText(InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileDiaChi)));
            txtSDTProfile.setText(InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileSDT)));
            txtNameProfile.setText(InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileHoTen)));
            txtEmailProfile.setText(InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileEmail)));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
