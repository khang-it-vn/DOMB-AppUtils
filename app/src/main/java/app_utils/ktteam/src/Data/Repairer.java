package app_utils.ktteam.src.Data;

import java.util.Date;
import java.util.UUID;

public class Repairer extends Person{
    private UUID id;
    public boolean trangThaiHoatDong;

    public Repairer(String hoTen, String diaChi, boolean gioiTinh, Date dob, String numberPhone, String email, String avatar, String matKhau, UUID id, boolean trangThaiHoatDong) {
        super(hoTen, diaChi, gioiTinh, dob, numberPhone, email, avatar, matKhau);
        this.id = id;
        this.trangThaiHoatDong = trangThaiHoatDong;
    }

    public Repairer() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isTrangThaiHoatDong() {
        return trangThaiHoatDong;
    }

    public void setTrangThaiHoatDong(boolean trangThaiHoatDong) {
        this.trangThaiHoatDong = trangThaiHoatDong;
    }
}
