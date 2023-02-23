package modul;

public class quanlygiaodich {
    
    private String magiaodich;
    private String email;

    public quanlygiaodich(String magiaodich, String email) {
        this.magiaodich = magiaodich;
        this.email = email;
    }

    public String getMagiaodich() {
        return magiaodich;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "quanlygiaodich [magiaodich=" + magiaodich + ", email=" + email + "]";
    }
    

}
