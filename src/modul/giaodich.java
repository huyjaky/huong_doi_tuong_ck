package modul;

import java.util.*;

public class giaodich {
    
    private String magiaodich;
    private Date thoigian;
    private String lido;
    private String muctieuchi;
    private danhmucchi madanhmuc;
    private Double khoangchi;
    private String mota;
    private String email_nguoinhan;
    private String phuongthuc;
    private String email_nguoigui;

    public giaodich(String magiaodich, Date thoigian, String lido, String muctieuchi, danhmucchi madanhmuc,
            Double khoangchi,  String mota, String  phuongthuc, String email_nguoinhan, String email_nguoigui) {
        this.magiaodich = magiaodich;
        this.thoigian = thoigian;
        this.lido = lido;
        this.muctieuchi = muctieuchi;
        this.madanhmuc = madanhmuc;
        this.khoangchi = khoangchi;
        this.mota = mota;
        this.phuongthuc = phuongthuc;
        this.email_nguoinhan = email_nguoinhan;
        this.email_nguoigui = email_nguoigui;
    }

    public giaodich (String magiaodich) {
        this.magiaodich = magiaodich;
    }

    public giaodich (Double khoangchi) {
        this.khoangchi = khoangchi;
    }

    public String getMagiaodich() {
        return magiaodich;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public String getLido() {
        return lido;
    }

    public String getMuctieuchi() {
        return muctieuchi;
    }

    public danhmucchi getMadanhmuc() {
        return madanhmuc;
    }

    public Double getKhoangchi() {
        return khoangchi;
    }


    public String getMota() {
        return mota;
    }

    @Override
    public String toString() {
        return "giaodich [magiaodich=" + magiaodich + ", thoigian=" + thoigian + ", lido=" + lido + ", muctieuchi="
                + muctieuchi + ", madanhmuc=" + madanhmuc + ", khoangchi=" + khoangchi +", mota="
                + mota + "]";
    }

    public void setMagiaodich(String magiaodich) {
        this.magiaodich = magiaodich;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public void setLido(String lido) {
        this.lido = lido;
    }

    public void setMuctieuchi(String muctieuchi) {
        this.muctieuchi = muctieuchi;
    }

    public void setMadanhmuc(danhmucchi madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public void setKhoangchi(Double khoangchi) {
        this.khoangchi = khoangchi;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getEmail_nguoinhan() {
        return email_nguoinhan;
    }

    public void setEmail_nguoinhan(String email_nguoinhan) {
        this.email_nguoinhan = email_nguoinhan;
    }

    public String getPhuongthuc() {
        return phuongthuc;
    }

    public void setPhuongthuc(String phuongthuc) {
        this.phuongthuc = phuongthuc;
    }

    public String getEmail_nguoigui() {
        return email_nguoigui;
    }

    public void setEmail_nguoigui(String email_nguoigui) {
        this.email_nguoigui = email_nguoigui;
    }

    
}
