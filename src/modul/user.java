package modul;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.window_listener;
import view.view_ver2;

public class user {
    
    private String email;
    private String user_name;
    private String password;

    public user(String email, String user_name, String password) {
        this.email = email;
        this.user_name = user_name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "user [email=" + email + ", user_name=" + user_name + ", password=" + password + "]";
    }

    public Double get_wallet (view_ver2 c_) {
        Double n = 0d;

        try {
            String command = "SELECT nguoidung.Sodu FROM nguoidung WHERE nguoidung.email = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, c_.getEmail());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n = rs.getDouble(1);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }

    public Integer change_wallet (Double wallet, view_ver2 c_) {
        Integer n = 0;

        try {
            String command = "UPDATE nguoidung SET nguoidung.Sodu = ? WHERE nguoidung.email = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setDouble(1, wallet);
            ps.setString(2, c_.getEmail());

            n = ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }
    
}
