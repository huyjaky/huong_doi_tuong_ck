package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.window_listener;
import modul.danhmucchi;
import view.view_ver2;

public class Daodanhmuchi implements DaoInterface <danhmucchi>{
    private view_ver2 c;

    public Daodanhmuchi (view_ver2 c) {
        this.c = c;
    }

    @Override
    public ArrayList<danhmucchi> command_free() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer delete(danhmucchi id) {
        // TODO Auto-generated method stub
        Integer n = 0;

        try {
            String command = "DELETE FROM quanlydanhmuc WHERE quanlydanhmuc.email = ? AND quanlydanhmuc.madanhmuc = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.c.getEmail());
            ps.setString(2, id.getMadanhmuc());

            n = ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }

    public Integer delete_through_name (String name) {
        Integer n = 0;

        try {
            String command = "dDELETE FROM quanlydanhmuc WHERE quanlydanhmuc.email = ? AND quanlydanhmuc.tendanhmuc = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.c.getEmail());
            ps.setString(2, name);

            n = ps.executeUpdate();
            // tim kiem va xoa danh muc chi
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }  


    @Override
    public Integer insert(danhmucchi object) {
        // TODO Auto-generated method stub
        Integer n = 0;

        try {
            String count_command = "SELECT COUNT(1) FROM danhmucchi";
            String command = "insert into danhmucchi (madanhmucchi, tendanhmuc) values (?,?)";
            String command_ = "INSERT INTO quanlydanhmuc (email, madanhmuc) VALUES (?,?)";
            PreparedStatement ps = window_listener.connect.prepareStatement(count_command);
            PreparedStatement ps_ = window_listener.connect.prepareStatement(command);
            PreparedStatement ps__ = window_listener.connect.prepareStatement(command_); 

            ResultSet rs = ps.executeQuery();
            rs.next();
            Integer count = rs.getInt(1);
            String madanhmuc = "dm" + (count + 1);

            ps_.setString(1, madanhmuc);
            if (object.getTendanhmuc().equals("")) {
                JOptionPane.showConfirmDialog(null, "ten danh muc khong duoc de trong!", "error", JOptionPane.OK_OPTION);
                return 0;
            }
            ps_.setString(2, object.getTendanhmuc());

            ps__.setString(1, this.c.getEmail());
            ps__.setString(2, madanhmuc);

            n = ps_.executeUpdate();
            ps__.executeUpdate();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public ArrayList<danhmucchi> searching(danhmucchi id) {
        // TODO Auto-generated method stub
        ArrayList<danhmucchi> lst_danhmucchi = new ArrayList<>();

        try {
            String command = "SELECT danhmucchi.madanhmucchi, danhmucchi.tendanhmuc FROM danhmucchi INNER JOIN quanlydanhmuc WHERE quanlydanhmuc.madanhmuc = danhmucchi.madanhmucchi AND quanlydanhmuc.email = ? AND danhmucchi.madanhmucchi = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.c.getEmail());
            ps.setString(2, id.getMadanhmuc());

            ResultSet rs = ps.executeQuery();
            lst_danhmucchi = lst_Danhmucchi(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return lst_danhmucchi;
    }

    @Override
    public ArrayList<danhmucchi> show_value() {
        // TODO Auto-generated method stub
        
        ArrayList<danhmucchi> lst_danhmucchi = new ArrayList<>();
        
        try {
            String command = "SELECT danhmucchi.madanhmucchi, danhmucchi.tendanhmuc FROM danhmucchi INNER JOIN quanlydanhmuc WHERE quanlydanhmuc.madanhmuc = danhmucchi.madanhmucchi AND quanlydanhmuc.email = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.c.getEmail());
            
            ResultSet rs = ps.executeQuery();
            lst_danhmucchi = lst_Danhmucchi(rs);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return lst_danhmucchi;
    }

    public ArrayList<danhmucchi> search_through_name (String name) {
        
        ArrayList<danhmucchi> lst_Danhmucchi = new ArrayList<>();

        try {
            String command = "SELECT danhmucchi.madanhmucchi, danhmucchi.tendanhmuc FROM danhmucchi INNER JOIN quanlydanhmuc WHERE quanlydanhmuc.madanhmuc = danhmucchi.madanhmucchi AND quanlydanhmuc.email = ? AND danhmucchi.tendanhmuc = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.c.getEmail());
            ps.setString(2, name);

            ResultSet rs = ps.executeQuery();

            lst_Danhmucchi = lst_Danhmucchi(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_Danhmucchi;
    } 


    public ArrayList<danhmucchi> lst_Danhmucchi (ResultSet rs) {
        ArrayList<danhmucchi> lst_danhmucchi = new ArrayList<>();

        try {
            while (rs.next()) {
                String madanhmuc = rs.getString(1);
                String tendanhmuc = rs.getString(2);

                danhmucchi danhmucchi = new danhmucchi(madanhmuc, tendanhmuc);
                lst_danhmucchi.add(danhmucchi);
            }           
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_danhmucchi;
    }

    public ArrayList<danhmucchi> lst_madanhmucchi () {
        
        ArrayList<danhmucchi> lst_madanhmuc = new ArrayList<>();

        try {
            String command = "select danhmucchi.madanhmucchi from danhmucchi";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);

            ResultSet rs = ps.executeQuery();
            lst_madanhmuc = lst_madanhmuc(rs);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_madanhmuc;
    }

    public ArrayList<danhmucchi> lst_madanhmuc (ResultSet rs) {
        ArrayList<danhmucchi> lst_madanhmuc = new ArrayList<>();

        try {
            while (rs.next()) {
                String madanhmuc = rs.getString(1);

                danhmucchi madanhmuc_ = new danhmucchi(madanhmuc);
                lst_madanhmuc.add(madanhmuc_);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_madanhmuc;
    } 
}
