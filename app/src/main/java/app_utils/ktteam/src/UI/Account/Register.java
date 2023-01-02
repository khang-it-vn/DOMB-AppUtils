package app_utils.ktteam.src.UI.Account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app_utils.ktteam.src.Apis.ApiService;
import app_utils.ktteam.src.Apis.Prototypes.DataUserApiResponse;
import app_utils.ktteam.src.Models.TaiKhoanModel;
import app_utils.ktteam.src.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Register extends AppCompatActivity {
    EditText edtSdtRegister, edtNameRegister, edtPasswordRegister, edtRePasswordRegister;
    Button btnRegister;
    TextView txtLogin, txtSaiThongTin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    public void init ()
    {
        edtNameRegister = findViewById(R.id.edtNameRegister);
        edtSdtRegister = findViewById(R.id.edtSdtRegister);
        edtPasswordRegister = findViewById(R.id.edtpasswordRegister);
        edtRePasswordRegister = findViewById(R.id.edtRepasswordRegister);
        btnRegister = findViewById(R.id.btnDangKy);
        txtLogin = findViewById(R.id.txtLogin);
        txtSaiThongTin = findViewById(R.id.txtSaiThongTin);
    }

    public void CallAPI (View view)
    {
        String name = edtNameRegister.getText().toString().trim();
        String sdt = edtSdtRegister.getText().toString().trim();
        String password = edtPasswordRegister.getText().toString().trim();
        String rePassword = edtRePasswordRegister.getText().toString().trim();
        boolean checkPhones = checkPhone(sdt);

        if(name.length() == 0 || sdt.length() == 0 || password.length() == 0 || rePassword.length() == 0){
            txtSaiThongTin.setText("Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        if(!checkPhones){
            txtSaiThongTin.setText("Số điện thoại không đúng định dạng!");
            return;
        }
        if(password.compareTo(rePassword) != 0){
            txtSaiThongTin.setText("Password không trùng khớp!");
            return;
        }
        ApiService.apiService.createAccount(new TaiKhoanModel(password, sdt, name)).enqueue(new Callback<DataUserApiResponse>() {
            @Override
            public void onResponse(Call<DataUserApiResponse> call, Response<DataUserApiResponse> response) {
                DataUserApiResponse res = response.body();
                if(res != null && res.isSuccess())
                {
                    txtSaiThongTin.setText("Đăng ký thành công!");
                    return;
                }

                txtSaiThongTin.setText("Số điện thoại đã được đăng ký!");

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

    public void ClickLogin (View view)
    {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
        return;
    }

}