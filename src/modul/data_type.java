package modul;

import java.util.Date;

public class data_type {
    private Date date;
    private Double khoangchi;

    public data_type(Date date, Double khoangchi) {
        this.date = date;
        this.khoangchi = khoangchi;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getKhoangchi() {
        return khoangchi;
    }

    public void setKhoangchi(Double khoangchi) {
        this.khoangchi = khoangchi;
    }


}