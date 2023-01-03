package app_utils.ktteam.src.UI.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.UUID;

import app_utils.ktteam.src.Apis.ApiService;
import app_utils.ktteam.src.Apis.Prototypes.DataUserApiResponse;
import app_utils.ktteam.src.R;
import app_utils.ktteam.src.Utils.InformationUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {
    EditText edtSDTForgotPassword;
    TextView txtMessForgetPass;
    Button btnForgotPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        init();
    }
    public void init(){
        edtSDTForgotPassword = findViewById(R.id.edtSDTForgotPassword);
        txtMessForgetPass = findViewById(R.id.txtMessForgetPass);
        btnForgotPass = findViewById(R.id.btnForgotPassword);
    }

    public void clickBtnSendCode(View view)
    {
        String sdt = edtSDTForgotPassword.getText().toString().trim();
        if(!checkPhone(sdt))
        {
            txtMessForgetPass.setText("Số điện thoại không hợp lệ!");
        }
        ApiService.apiService.getUUIDByNumberPhone(sdt).enqueue(new Callback<DataUserApiResponse>() {
            @Override
            public void onResponse(Call<DataUserApiResponse> call, Response<DataUserApiResponse> response) {
                    DataUserApiResponse res = response.body();
                System.out.println(res);
                    if(res != null && res.isSuccess())
                    {
                        UUID uuid;
                        try {
                            InformationUtil.writeToFile(res.getData().getUid().toString(), openFileOutput(InformationUtil.FileUid, MODE_PRIVATE));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        };
                        Intent intent =  new Intent(ForgotPassword.this, XacNhanForgetPassword.class);
                        startActivity(intent);
                        return;
                    }
                    txtMessForgetPass.setText("Số điện thoại chưa được đăng ký!");
            }

            @Override
            public void onFailure(Call<DataUserApiResponse> call, Throwable t) {

            }
        });


    }

    public boolean checkPhone(String str) {
        // Bieu thuc chinh quy mo ta dinh dang so dien thoai
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";

        // Kiem tra dinh dang
        boolean kt = str.matches(reg);

        return kt;
    }

}