package DAO;

import java.util.ArrayList;

public interface DaoInterface <T>{

    public ArrayList<T> show_value ();

    public Integer delete (T id); 

    public Integer insert (T object);

    public ArrayList<T> searching (T id);

    public ArrayList<T> command_free ();
}
