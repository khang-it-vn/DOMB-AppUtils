package app_utils.ktteam.src.UI.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

import app_utils.ktteam.src.Apis.ApiService;
import app_utils.ktteam.src.Apis.Prototypes.DataUserApiResponse;
import app_utils.ktteam.src.R;
import app_utils.ktteam.src.UI.Homes.NavigationMain;
import app_utils.ktteam.src.Utils.InformationUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePassword extends AppCompatActivity {
    EditText edtNewPass, edtReNewPass;
    TextView txtMessChangePass;
    Button btnChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        init();
    }

    public  void init(){
        edtNewPass = findViewById(R.id.edtNewPassChangePass);
        edtReNewPass = findViewById(R.id.edtReNewPassChangePass);
        txtMessChangePass = findViewById(R.id.txtMessChangePass);
        btnChangePassword = findViewById(R.id.btnChangePassword);
    }

    public void ClickBtnChangePass(View view)
    {
        UUID uuid = null;
        String newPass = edtNewPass.getText().toString().trim();
        String reNewPass = edtReNewPass.getText().toString().trim();

        if(newPass.length() == 0 || reNewPass.length() == 0)
        {
            txtMessChangePass.setText("Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        if(newPass.compareTo(reNewPass) != 0)
        {
            txtMessChangePass.setText("Mật khẩu nhập lại không trùng khớp!");
            return;
        }
        try {
            uuid = UUID.fromString(InformationUtil.readToFile(openFileInput(InformationUtil.FileUid)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ApiService.apiService.updatePassword(uuid, newPass).enqueue(new Callback<DataUserApiResponse>() {
            @Override
            public void onResponse(Call<DataUserApiResponse> call, Response<DataUserApiResponse> response) {
                DataUserApiResponse res = response.body();
                if(res != null && res.isSuccess())
                {
                    txtMessChangePass.setText("Cập nhật mật khẩu thành công!");
                    try {
                        InformationUtil.writeToFile(res.getData().getHoTen().trim(),  openFileOutput(InformationUtil.FileHoTen, MODE_PRIVATE));
                        InformationUtil.writeToFile(res.getData().getDiaChi().trim(), openFileOutput(InformationUtil.FileDiaChi, MODE_PRIVATE));
                        InformationUtil.writeToFile(res.getData().getNumberPhone().trim(),  openFileOutput(InformationUtil.FileSDT, MODE_PRIVATE));
                        InformationUtil.writeToFile(res.getData().getEmail().trim(), openFileOutput(InformationUtil.FileEmail, MODE_PRIVATE));
                        InformationUtil.writeToFile(res.getData().getUid().toString().trim(), openFileOutput(InformationUtil.FileUid, MODE_PRIVATE));
                        Intent intent = new Intent(ChangePassword.this, NavigationMain.class);
                        startActivity(intent);
                    }catch (Exception e)
                    {
                        Toast.makeText(ChangePassword.this,e.getMessage(),Toast.LENGTH_LONG);
                    }
                    return;
                }
                txtMessChangePass.setText("Loi");
            }

            @Override
            public void onFailure(Call<DataUserApiResponse> call, Throwable t) {

            }
        });
    }
}