package modul;

public class transfer_history {
    private String nguoinhan;
    private Double khoangchi;

    public transfer_history (String nguoinhan, Double khoangchi) {
        this.nguoinhan = nguoinhan;
        this.khoangchi = khoangchi;
    }

    public String getNguoinhan() {
        return nguoinhan;
    }

    public void setNguoinhan(String nguoinhan) {
        this.nguoinhan = nguoinhan;
    }

    public Double getKhoangchi() {
        return khoangchi;
    }

    public void setKhoangchi(Double khoangchi) {
        this.khoangchi = khoangchi;
    }
    
}
