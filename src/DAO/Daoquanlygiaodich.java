package DAO;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import controller.window_listener;
import modul.quanlygiaodich;

public class Daoquanlygiaodich implements DaoInterface <quanlygiaodich>{

    @Override
    public ArrayList<quanlygiaodich> command_free() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer delete(quanlygiaodich id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer insert(quanlygiaodich object) {
        // TODO Auto-generated method stub
        Integer n = 0;
        try {
            String command = "INSERT INTO quanlygiaodich (email, magiaodich) VALUES (?, ?)";
            PreparedStatement ps = window_listener.connect.prepareStatement(command);
            ps.setString(1, object.getEmail());
            ps.setString(2, object.getMagiaodich());

            n = ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public ArrayList<quanlygiaodich> searching(quanlygiaodich id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<quanlygiaodich> show_value() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
