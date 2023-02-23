package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import controller.window_listener;
import modul.danhmucchi;
import modul.data_type;
import modul.giaodich;
import modul.request_mn;

public class Daogiaodich implements DaoInterface <giaodich>{
    private String email;

    public Daogiaodich (String email) {
        this.email = email;
    }

    @Override
    public ArrayList<giaodich> command_free() {
        return null;
    }
    // not finished


    @Override
    public Integer delete(giaodich id) {
        // TODO Auto-generated method stub
        Integer n = 0;

        try {
            java.sql.Statement st = window_listener.connect.createStatement();
            String command = "delete from giaodich where giadich.magiaodich = '" + id.getMagiaodich() + "'"; 

            n = st.executeUpdate(command);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public Integer insert(giaodich object) {
        return null;
    }

    public ArrayList<giaodich> searching_(giaodich id) {
        // TODO Auto-generated method stub
        
        ArrayList<giaodich> lst_giaodich = new ArrayList<>();

        try {
            String command = "";  
            PreparedStatement st = window_listener.connect.prepareStatement(command);
            st.setString(1, id.getMagiaodich());
            
            ResultSet rs = st.executeQuery();
            lst_giaodich = lst_giaodich(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }
        return lst_giaodich;
    }

    @Override
    public ArrayList<giaodich> searching(giaodich id) {
        // TODO Auto-generated method stub
        
        ArrayList<giaodich> lst_giaodich = new ArrayList<>();

        try {
            String command = "SELECT  giaodich.magiaodich, giaodich.thoigian, giaodich.lydo, giaodich.muctieuchi, giaodich.madanhmuc, giaodich.khoangchi, giaodich.mota FROM giaodich INNER JOIN quanlygiaodich WHERE quanlygiaodich.magiaodich = giaodich.magiaodich AND quanlygiaodich.email = '" + this.email + "' AND giaodich.magiaodich = ?";            
            PreparedStatement st = window_listener.connect.prepareStatement(command);
            st.setString(1, id.getMagiaodich());
            
            ResultSet rs = st.executeQuery();
            lst_giaodich = lst_giaodich(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();

        }
        
        return lst_giaodich;
    }

    public ArrayList<giaodich> searching_khoangchi (giaodich id) {
        
        ArrayList<giaodich> lst_giaodich = new ArrayList<>();

        try {
            String command = "SELECT giaodich.magiaodich, giaodich.thoigian, giaodich.lydo, giaodich.muctieuchi, giaodich.madanhmuc, giaodich.khoangchi, giaodich.mota FROM giaodich INNER JOIN quanlygiaodich WHERE quanlygiaodich.magiaodich = giaodich.magiaodich AND quanlygiaodich.email = '" + this.email + "' AND giaodich.khoangchi = " + id.getKhoangchi();            
            PreparedStatement st = window_listener.connect.prepareStatement(command);
            
            ResultSet rs = st.executeQuery();
            lst_giaodich = lst_giaodich(rs);
        } catch (Exception a) {
            // TODO: handle exception
            a.printStackTrace();
        }
        
        return lst_giaodich;
    }

    @Override
    public ArrayList<giaodich> show_value() {
        // TODO Auto-generated method stub
        
        ArrayList<giaodich> lst_giaodich = new ArrayList<>();

        try {
            String command = "SELECT * FROM giaodich WHERE giaodich.nguoinhan = ? OR giaodich.nguoigui = ?";
            System.out.println(email);
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.email);
            ps.setString(2, this.email);

            ResultSet rs = ps.executeQuery();
            lst_giaodich = lst_giaodich(rs);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return lst_giaodich;
    }
    
    public ArrayList<giaodich> lst_giaodich (ResultSet rs) {
        ArrayList<giaodich> lst_giaodich = new ArrayList<>();

        try {
            while(rs.next()){
                java.util.Date date = null;
                Timestamp timestamp = rs.getTimestamp(2);
                if (timestamp != null) date = new java.util.Date(timestamp.getTime());

                String magiaodich = rs.getString(1);
                String lido = rs.getString(3);
                String muctieuchi = rs.getString(4);

                String madanhmuc_str = rs.getString(5);
                danhmucchi madanhmuc = new danhmucchi(madanhmuc_str);

                Double khoangchi = rs.getDouble(6);
                String mota = rs.getString (7); 
                String phuongthuc = rs.getString(8);
                String email_nguoinhan = rs.getString(10);
                String email_nguoigui = rs.getString(9);

                giaodich giaodich = new giaodich(magiaodich, date, lido, muctieuchi, madanhmuc, khoangchi,mota, phuongthuc, email_nguoinhan, email_nguoigui);

                lst_giaodich.add(giaodich);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_giaodich;
    }

    public ArrayList<data_type> lst_data () {
        
        ArrayList<data_type> lst_data = new ArrayList<>();

        try {
            String command = "SELECT giaodich.thoigian, giaodich.khoangchi "
                                + " FROM giaodich "
                                + " WHERE giaodich.nguoigui =  ?"
                                + " AND MONTH(giaodich.thoigian) = MONTH(NOW())"
                                + " GROUP BY MONTH(giaodich.thoigian), DAY(giaodich.thoigian)";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.email);

            ResultSet rs = ps.executeQuery();
            lst_data = lst_giaodich_(rs);
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return lst_data;
    }

    public ArrayList<data_type> lst_giaodich_ (ResultSet rs) {
        ArrayList<data_type> lst_giaodich = new ArrayList<>();
        Date date = null;

        try {
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp(1);
                if (ts != null) date = new Date(ts.getTime());
                Double khoangchi = rs.getDouble(2);

                data_type data_type = new data_type(date, khoangchi);
                lst_giaodich.add(data_type);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_giaodich;
    }

    public Double get_daydiff () {
        Double n = 0d;
        try {
            String command = "SELECT "
                + " case "
                + "   when SUM(giaodich.khoangchi) IS NULL then 0"
                + "    ELSE SUM(giaodich.khoangchi)"
                + " END AS khoangchi"
            + " FROM giaodich"
            + " INNER JOIN quanlygiaodich"
            + " WHERE quanlygiaodich.magiaodich = giaodich.magiaodich"
            + " AND quanlygiaodich.email = ?"
            + " AND MONTH(giaodich.thoigian) = MONTH(NOW())";

            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            rs.next();
            n = rs.getDouble(1);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n/30;
    }

    public ArrayList<request_mn> lst_request_mn () {
        
        
        ArrayList<request_mn> lst_request_mn = new ArrayList<>();

        try {
            String command = "SELECT giaodich.thoigian, giaodich.khoangchi, giaodich.phuongthucgiaodich, giaodich.nguoigui FROM giaodich WHERE giaodich.nguoinhan = ?";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, this.email);

            ResultSet rs = ps.executeQuery();
            lst_request_mn = lst_request_mn_fill(rs);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return lst_request_mn;
    }

    public ArrayList<request_mn> lst_request_mn_fill (ResultSet rs) {
        ArrayList<request_mn> lst_request_mn  = new ArrayList<>();

        try {
            while(rs.next()) {
                java.util.Date date = null;
                Timestamp timestamp = rs.getTimestamp(1);
                if (timestamp != null) date = new java.util.Date(timestamp.getTime());               

                Double khoangchi = rs.getDouble(2);
                String phuongthucgiaodich = rs.getString(3);
                String nguoigui = rs.getString(4);

                request_mn request_mn = new request_mn(date, khoangchi, phuongthucgiaodich, nguoigui);
                lst_request_mn.add(request_mn);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return lst_request_mn;
    }
    public Double sum_giaodich_per_month() {
        Double n = 0d;
            
        try {
            String command = "SELECT SUM(giaodich.khoangchi) "
                            + " FROM giaodich "
                            + " WHERE giaodich.nguoigui = ?"
                            + " AND MONTH(giaodich.thoigian) = MONTH(NOW())";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            rs.next();
            n = rs.getDouble(1);
            System.out.println(n);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }
}
