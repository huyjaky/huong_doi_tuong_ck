package modul;

import java.util.Date;

public class request_mn {
    private Date thoigian;
    private Double khoangchi;
    private String phuongthuc;
    private String nguoigui;
    public request_mn(Date thoigian, Double khoangchi, String phuongthuc, String nguoigui) {
        this.thoigian = thoigian;
        this.khoangchi = khoangchi;
        this.phuongthuc = phuongthuc;
        this.nguoigui = nguoigui;
    }
    public Date getThoigian() {
        return thoigian;
    }
    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }
    public Double getKhoangchi() {
        return khoangchi;
    }
    public void setKhoangchi(Double khoangchi) {
        this.khoangchi = khoangchi;
    }
    public String getPhuongthuc() {
        return phuongthuc;
    }
    public void setPhuongthuc(String phuongthuc) {
        this.phuongthuc = phuongthuc;
    }
    public String getNguoigui() {
        return nguoigui;
    }
    public void setNguoigui(String nguoigui) {
        this.nguoigui = nguoigui;
    }

    

}
