package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.window_listener;
import controller.login_register_listener.login_register_window_listener;
import modul.user;

public class Daouser implements DaoInterface<user>{

    @Override
    public ArrayList<user> command_free() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer delete(user id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer insert(user object) {
        // TODO Auto-generated method stub
        Integer n = 0;

        try {
            String command = "INSERT INTO nguoidung VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = login_register_window_listener.connect.prepareStatement(command);
            ps.setString(1, object.getEmail());
            ps.setString(2, object.getUser_name());
            ps.setString(3, object.getPassword());
            ps.setDouble(4, 0);
            ps.setDouble(5, 0);

            n = ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public ArrayList<user> searching(user id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<user> show_value() {
        // TODO Auto-generated method stub

        return null;
    }

    public ArrayList<user> check_exist (String email) {
        
        ArrayList<user> lst_user = new ArrayList<>();

        try {
            String command = "SELECT * FROM nguoidung WHERE nguoidung.email = ? ";
            PreparedStatement ps = login_register_window_listener.connect.prepareStatement(command);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            lst_user = lst_user(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_user;
    }
    
    public ArrayList<user> check_exist1 (String email) {
        
        ArrayList<user> lst_user = new ArrayList<>();

        try {
            String command = "SELECT * FROM nguoidung WHERE nguoidung.email = ? ";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            lst_user = lst_user(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_user;
    }

    public ArrayList<user> login (String email, String pass) {
        
        ArrayList<user> lst_user = new ArrayList<>();

        try {
            String command = "SELECT * FROM nguoidung WHERE nguoidung.email = ? AND nguoidung.PASSWORD = ?";
            PreparedStatement ps = login_register_window_listener.connect.prepareStatement(command);
            ps.setString(1, email);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            lst_user = lst_user(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return lst_user;
    }

    public ArrayList<user> account (String email) {
        
        ArrayList<user> lst_user = new ArrayList<>();

        try {
            String command = "SELECT * FROM nguoidung WHERE nguoidung.email = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            lst_user = lst_user(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return lst_user;
    }
    public ArrayList<user> lst_user (ResultSet rs) {
        ArrayList<user> lst_user = new ArrayList<>();

        try {
            while(rs.next()){
                String email = rs.getString(1);
                String user_name = rs.getString(2);
                String pass = rs.getString(3);

                user user = new user(email, user_name, pass);
                lst_user.add(user);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_user;
    }

    public Double get_wallet (String email) {
        
        Double wallet = 0d;

        try {
            String command = "SELECT nguoidung.Sodu FROM nguoidung WHERE nguoidung.email = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            rs.next();
            wallet = rs.getDouble(1);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return wallet;
    }

    public Double get_limit (String email) {
        
        Double limit = 0d;

        try {
            String command = "SELECT nguoidung.gioihan FROM nguoidung WHERE nguoidung.email = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            rs.next();
            limit = rs.getDouble(1);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return limit;
    }

    public String get_pass (String email) {
        
        String pass = "";

        try {
            String command = "SELECT nguoidung.PASSWORD FROM nguoidung WHERE nguoidung.email = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            rs.next();
            pass = rs.getString(1);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return pass;
    }

    public Integer reset_limit (String email) {
        Integer n = 0;
        try {
            String command = "UPDATE nguoidung SET nguoidung.gioihan = 0 "
                                + "WHERE nguoidung.email = ? "
                                + "AND ( (SELECT MAX(month(giaodich.thoigian)) FROM giaodich "
                                + "INNER JOIN quanlygiaodich "
                                + "WHERE giaodich.magiaodich = quanlygiaodich.magiaodich "
                                + "AND quanlygiaodich.email = ? ) <> month(NOW()) "
                                + "OR (SELECT MAX(month(giaodich.thoigian)) FROM giaodich "
                                + "INNER JOIN quanlygiaodich "
                                + "WHERE giaodich.magiaodich = quanlygiaodich.magiaodich "
                                + "AND quanlygiaodich.email = ?) <> YEAR(NOW()));";

            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, email);
            ps.setString(2, email);
            ps.setString(3, email);

            n = ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }

}
