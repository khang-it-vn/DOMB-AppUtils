package app_utils.ktteam.src.Entities;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


@Entity(tableName = "Repairer")
public class ERepaierDistance  {



    @PrimaryKey
    @NonNull
    private String id;

    //@ColumnInfo(name = "distance")
    private double distance;

    private boolean trangThaiHoatDong;

    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    private double longitude;

    private String hoTen ;// Họ tên

    private String diaChi;// Địa chỉ

    private boolean gioiTinh ;// Giới tính

    private String dob ;// Ngày tháng năm sinh

    private String numberPhone ;// Số điện thoại

    private String email ;// Email liên hệ

    private String avatar ;// Tên hình ảnh

    private String matKhau ; // passwrod tài khoản

    public ERepaierDistance(@NonNull String id, double distance, boolean trangThaiHoatDong, double latitude, double longitude, String hoTen, String diaChi, boolean gioiTinh, String dob, String numberPhone, String email, String avatar, String matKhau) {
        this.id = id;
        this.distance = distance;
        this.trangThaiHoatDong = trangThaiHoatDong;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.dob = dob;
        this.numberPhone = numberPhone;
        this.email = email;
        this.avatar = avatar;
        this.matKhau = matKhau;
    }

    public ERepaierDistance() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isTrangThaiHoatDong() {
        return trangThaiHoatDong;
    }

    public void setTrangThaiHoatDong(boolean trangThaiHoatDong) {
        this.trangThaiHoatDong = trangThaiHoatDong;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}

