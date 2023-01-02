package app_utils.ktteam.src.Models;

import java.util.UUID;

public class UserEditProfileModel {
    private UUID uid;
    private String hoTen;
    private String diaChi;
    private String email;

    public UserEditProfileModel(UUID uid, String hoTen, String diaChi, String email) {
        this.uid = uid;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.email = email;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
