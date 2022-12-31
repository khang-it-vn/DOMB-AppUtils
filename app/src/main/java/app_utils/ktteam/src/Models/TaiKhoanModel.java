package app_utils.ktteam.src.Models;

public class TaiKhoanModel extends TaiKhoan{
    private String hoTen;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public TaiKhoanModel() {
    }

    public TaiKhoanModel(String matKhau, String soDienThoai, String hoTen) {
        super(matKhau, soDienThoai);
        this.hoTen = hoTen;
    }
}
