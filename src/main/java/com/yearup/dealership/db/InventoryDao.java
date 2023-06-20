package com.yearup.dealership.db;

import com.yearup.dealership.models.Dealership;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        String query = "insert into inventory (dealership_id, vin) values (?,?) ";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {


            preparedStatement.setString(1,vin);
            preparedStatement.setInt(2,dealershipId);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + "rows affected!");

        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void removeVehicleFromInventory(String vin) {
        String query = "Delete from inventory where vin = ?";


        try(Connection connect = dataSource.getConnection();
            PreparedStatement PS = connect.prepareStatement(query);){

            PS.setString(1, vin);


            int rows = PS.executeUpdate();
            System.out.println(rows + "rows affected!");


        }  catch (Exception madness){
            madness.printStackTrace();
        }
    }
}

