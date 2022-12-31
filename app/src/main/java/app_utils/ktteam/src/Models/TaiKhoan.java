package app_utils.ktteam.src.Models;

public class TaiKhoan {
    private String matKhau;
    private String soDienThoai;

    public TaiKhoan() {
    }

    public TaiKhoan(String matKhau, String soDienThoai) {
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
