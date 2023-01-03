package app_utils.ktteam.src.UI.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class XacNhanForgetPassword extends AppCompatActivity {
    EditText edtOTP;
    TextView txtMessXacNhanOTP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xacnhan_forgotpassword);
        init();
    }

    public void init(){
        edtOTP = findViewById(R.id.edtOTP);
        txtMessXacNhanOTP = findViewById(R.id.txtMessXacNhanOTP);
    }

    public void ClickBtnXacNhanOTP (View view)
    {
        String otp = edtOTP.getText().toString().trim();
        int iotp = Integer.parseInt(otp);
        UUID uuid = null;
        try {
            uuid = UUID.fromString(InformationUtil.readToFile(openFileInput(InformationUtil.FileUid)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ApiService.apiService.checkCode(uuid, iotp).enqueue(new Callback<DataUserApiResponse>() {
            @Override
            public void onResponse(Call<DataUserApiResponse> call, Response<DataUserApiResponse> response) {
                DataUserApiResponse res = response.body();
                if(res != null && res.isSuccess())
                {
                    Intent intent = new Intent(XacNhanForgetPassword.this, ChangePassword.class);
                    startActivity(intent);
                    return;
                }

                txtMessXacNhanOTP.setText("Mã xác nhận không đúng!");
            }

            @Override
            public void onFailure(Call<DataUserApiResponse> call, Throwable t) {

            }
        });
    }

}