package app_utils.ktteam.src.UI.Homes.Fragments;

import static android.content.Context.MODE_PRIVATE;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.FileNotFoundException;
import java.util.UUID;

import app_utils.ktteam.src.Apis.ApiService;
import app_utils.ktteam.src.Apis.Prototypes.DataUserApiResponse;
import app_utils.ktteam.src.ENVIROMENT;
import app_utils.ktteam.src.Models.UserEditProfileModel;
import app_utils.ktteam.src.R;
import app_utils.ktteam.src.UI.Account.Login;
import app_utils.ktteam.src.Utils.InformationUtil;
import app_utils.ktteam.src.Utils.LoadImageUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfileFragment extends Fragment {

    ImageView imgEditProfile;
    EditText edtNameProfile, edtDiaChiProfile, edtEmailProfile;
    Button btnChangeInforEditProfile;
    TextView txtNameEditProfile, txtThieuThongTin;
    UUID uuid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_profile,container,false);
        init(view);
        setImageViewOnClickListener(btnChangeInforEditProfile, R.id.fragment_edit_profile,new ProfileFragment());
        // lấy và hiển thị avatar
        setImage();
        return view;
    }

    public  void init(View view){

        imgEditProfile = view.findViewById(R.id.imgEditFace);
        edtDiaChiProfile = view.findViewById(R.id.edtDiaChiEditProfile);
        edtNameProfile = view.findViewById(R.id.edtNameEditProfile);

        edtEmailProfile = view.findViewById(R.id.edtEmailEditProfile);
        btnChangeInforEditProfile = view.findViewById(R.id.btnChangeInforEditProfile);
        txtNameEditProfile = view.findViewById(R.id.txtNameEditProfile);
        txtThieuThongTin = view.findViewById(R.id.txtThieuThongTinEditProfile);
        try {
            edtDiaChiProfile.setText(InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileDiaChi)));

            String name = InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileHoTen));
            edtNameProfile.setText(name);
            edtEmailProfile.setText(InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileEmail)));
            txtNameEditProfile.setText(name);
            uuid = UUID.fromString(InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileUid)));
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
                if(name.length() == 0 || diaChi.length() == 0 || name.length() == 0 || email.length() == 0){
                    txtThieuThongTin.setText("Vui lòng không để trống thông tin");
                    return;
                }
                try {
                    InformationUtil.writeToFile(diaChi, getActivity().openFileOutput(InformationUtil.FileDiaChi, MODE_PRIVATE));
                    InformationUtil.writeToFile(name, getActivity().openFileOutput(InformationUtil.FileHoTen, MODE_PRIVATE));

                    InformationUtil.writeToFile(email, getActivity().openFileOutput(InformationUtil.FileEmail, MODE_PRIVATE));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                CallAPI(diaChi, name, email);
                btnChangeInforEditProfile.setVisibility(View.INVISIBLE);
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                trans.replace(fragment, InstanceFragment);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.commit();
            }
        });
    }

    private void CallAPI (String diaChi, String name, String email)
    {
        ApiService.apiService.updateInformation(new UserEditProfileModel(uuid, name, diaChi, email)).enqueue(new Callback<DataUserApiResponse>() {
            @Override
            public void onResponse(Call<DataUserApiResponse> call, Response<DataUserApiResponse> response) {
                DataUserApiResponse res = response.body();
                if(res== null || !res.isSuccess())
                {
                    return;
                }
            }

            @Override
            public void onFailure(Call<DataUserApiResponse> call, Throwable t) {

            }
        });

    }
    private void setImage() {
        try {
            String avatar = InformationUtil.readToFile(getActivity().openFileInput(InformationUtil.FileAvatar));
            LoadImageUtil.loadImageFor(new LoadImageUtil(imgEditProfile, ENVIROMENT.DOMAIN_GET_IMAGE,avatar));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
