package app_utils.ktteam.src.Apis;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.UUID;

import app_utils.ktteam.src.Apis.Prototypes.DataListRepairerApiResponse;
import app_utils.ktteam.src.Apis.Prototypes.DataListRepairerDistanceApiResponse;
import app_utils.ktteam.src.Apis.Prototypes.DataUserApiResponse;
import app_utils.ktteam.src.Models.TaiKhoan;
import app_utils.ktteam.src.Models.TaiKhoanModel;
import app_utils.ktteam.src.Models.UserEditProfileModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    ApiService apiService = new Retrofit.Builder().baseUrl("http://192.168.1.182:5000/v1/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(ApiService.class);

    // Đăng nhập
    @POST("User/Login")
    Call<DataUserApiResponse> login(@Body TaiKhoan taiKhoan) ;


    // Đăng ký tài khoản
    @POST("User")
    Call<DataUserApiResponse> createAccount(@Body TaiKhoanModel taiKhoanModel);


    // Tìm kiếm thợ sửa chữa gần đây
    @GET("User/GetRepairerArround")
    Call<DataListRepairerDistanceApiResponse> getRepairerArround(@Query("diaChi") String diaChi);

    @PATCH("User/EditInfo")
    Call<DataUserApiResponse> updateInformation(@Body UserEditProfileModel model);

    //Quên Mật Khẩu
    @GET("User/CompareCode")
    Call<DataUserApiResponse> checkCode(@Query("uid") UUID uuid, @Query("code") int code);

    // Lấy uid bằng số điện thoại
    @GET("User/GetUIDByNumberPhone")
    Call<DataUserApiResponse> getUUIDByNumberPhone(@Query("numberPhone") String soDienThoai);

    @PATCH("User/UpdatePassword")
    Call<DataUserApiResponse> updatePassword(@Query("uid") UUID uuid, @Query("matKhau") String matKhau);

}
