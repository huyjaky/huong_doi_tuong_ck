package modul;

public class danhmucchi {
    
    private String madanhmuc;
    private String tendanhmuc;

    public danhmucchi(String madanhmuc, String tendanhmuc) {
        this.madanhmuc = madanhmuc;
        this.tendanhmuc = tendanhmuc;
    }
    
    public danhmucchi (String madanhmuc) {
        this.madanhmuc = madanhmuc;
    }

    public String getMadanhmuc() {
        return madanhmuc;
    }

    public String getTendanhmuc() {
        return tendanhmuc;
    }

    @Override
    public String toString() {
        return "danhmucchi [madanhmuc=" + madanhmuc + ", tendanhmuc=" + tendanhmuc + "]";
    }
    
}
