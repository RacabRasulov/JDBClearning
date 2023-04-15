package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CarsDAO {

public void addCars (Cars Cars) throws SQLException;
public void removeCars(Cars Cars) throws SQLException;

public Cars getCars(Cars Cars) throws  SQLException;

public ArrayList<Cars> getAllCars() throws SQLException;


}
