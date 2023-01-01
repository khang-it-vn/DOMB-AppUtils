package app_utils.ktteam.src.UI.Account;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app_utils.ktteam.src.Apis.ApiService;
import app_utils.ktteam.src.Apis.Prototypes.DataUserApiResponse;
import app_utils.ktteam.src.Models.TaiKhoan;
import app_utils.ktteam.src.R;
import app_utils.ktteam.src.UI.Homes.NavigationMain;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity {

    EditText edtSdtLogin, edtPasswordLogin;
    TextView txtForgotPass, txtRegister, txtMessageStateLogin;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();


    }

    public void init(){
        edtSdtLogin = findViewById(R.id.edtSdtLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        txtForgotPass = findViewById(R.id.txtForgotPass);
        txtRegister = findViewById(R.id.txtRegister);
        btnLogin = findViewById(R.id.btnLogin);
        txtMessageStateLogin = findViewById(R.id.txtNotifyStateLogin);

    }
    public void callApi(View view) {
        String matKhau = edtPasswordLogin.getText().toString().trim();
        String soDienThoai = edtSdtLogin.getText().toString().trim();
        if(matKhau.length()== 0 || soDienThoai.length()==0)
        {
            txtMessageStateLogin.setText("Sai số điện thoại hoặc mật khẩu");
            return;
        }
       ApiService.apiService.login(new TaiKhoan(matKhau,soDienThoai)).enqueue(new Callback<DataUserApiResponse>() {
           @Override
           public void onResponse(Call<DataUserApiResponse> call, Response<DataUserApiResponse> response) {
               DataUserApiResponse res = response.body();

               if(res != null && res.isSuccess())
               {
                   Intent intent = new Intent(Login.this, NavigationMain.class);
                   startActivity(intent);
                    return;
               }

               txtMessageStateLogin.setText("Sai số điện thoại hoặc mật khẩu");
           }

           @Override
           public void onFailure(Call<DataUserApiResponse> call, Throwable t) {
               System.out.println(t.getMessage());
           }
       });


    }



}