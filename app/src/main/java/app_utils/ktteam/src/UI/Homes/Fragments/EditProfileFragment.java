package app_utils.ktteam.src.UI.Homes.Fragments;

import static android.content.Context.MODE_PRIVATE;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.FileNotFoundException;

import app_utils.ktteam.src.R;
import app_utils.ktteam.src.Utils.InformationUtil;

public class EditProfileFragment extends Fragment {

    ImageView imgEditProfile;
    EditText edtNameProfile, edtDiaChiProfile, edtEmailProfile;
    Button btnChangeInforEditProfile;
    TextView txtNameEditProfile;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_profile,container,false);
        init(view);
        setImageViewOnClickListener(btnChangeInforEditProfile, R.id.fragment_edit_profile,new ProfileFragment());
        return view;
    }

    public  void init(View view){
        imgEditProfile = view.findViewById(R.id.imgEditFace);
        edtDiaChiProfile = view.findViewById(R.id.edtDiaChiEditProfile);
        edtNameProfile = view.findViewById(R.id.edtNameEditProfile);

        edtEmailProfile = view.findViewById(R.id.edtEmailEditProfile);
        btnChangeInforEditProfile = view.findViewById(R.id.btnChangeInforEditProfile);
        txtNameEditProfile = view.findViewById(R.id.txtNameEditProfile);
        try {
            edtDiaChiProfile.setText(InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileDiaChi)));

            String name = InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileHoTen));
            edtNameProfile.setText(name);
            edtEmailProfile.setText(InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileEmail)));
            txtNameEditProfile.setText(name);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void setImageViewOnClickListener(Button btnClick, int fragment, Fragment InstanceFragment) {
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diaChi = edtDiaChiProfile.getText().toString().trim();
                String name = edtNameProfile.getText().toString().trim();

                String email = edtEmailProfile.getText().toString().trim();
                try {
                    InformationUtil.writeToFile(diaChi, getActivity().openFileOutput(InformationUtil.FileDiaChi, MODE_PRIVATE));
                    InformationUtil.writeToFile(name, getActivity().openFileOutput(InformationUtil.FileHoTen, MODE_PRIVATE));

                    InformationUtil.writeToFile(email, getActivity().openFileOutput(InformationUtil.FileEmail, MODE_PRIVATE));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(fragment, InstanceFragment);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.commit();
            }
        });
    }

    private void CallAPI ()
    {
        String diaChi = edtDiaChiProfile.getText().toString().trim();
        String name = edtNameProfile.getText().toString().trim();
        String email = edtEmailProfile.getText().toString().trim();

    }
}
