package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        String query = "insert into vehicles (make, model, year, SOLD, color, vehicleType, odometer, price) values (?,?,?,?,?,?,?,?) ";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setString(1, vehicle.getMake());
            preparedStatement.setString(2, vehicle.getModel());
            preparedStatement.setInt(3,vehicle.getYear());
            preparedStatement.setBoolean(4, vehicle.isSold());
            preparedStatement.setString(5, vehicle.getColor());
            preparedStatement.setString(6, vehicle.getVehicleType());
            preparedStatement.setInt(7, vehicle.getOdometer());
            preparedStatement.setDouble(8,vehicle.getPrice());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + "rows affected!");

        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
        public void removeVehicle (String VIN){
           String query = "Delete from vehicles where vin = ?";


           try(Connection connect = dataSource.getConnection();
            PreparedStatement PS = connect.prepareStatement(query);){

               PS.setString(1, VIN);


               int rows = PS.executeUpdate();
               System.out.println(rows + "rows affected!");


        }  catch (Exception madness){
                madness.printStackTrace();
            }
        }
        public List<Vehicle> searchByPriceRange ( double minPrice, double maxPrice){



        String query = "Select price from vehicles where price between ? AND ?; ";
        Vehicle vehicle = null;


            try(Connection connect = dataSource.getConnection();
                PreparedStatement PS = connect.prepareStatement(query);){

                PS.setDouble(1, minPrice);
                PS.setDouble(1, maxPrice);


            try(ResultSet results = PS.executeQuery()){
                List <Vehicle> vehicles = new ArrayList<>();
                while (results.next()) {
                    vehicle = createVehicleFromResultSet(results);
                    vehicles.add(vehicle);
                }

                return vehicles;
            }





            }  catch (Exception madness){
                madness.printStackTrace();
            }
            return new ArrayList<>();
        }

        public List<Vehicle> searchByMakeModel (String make, String model){
                List<Vehicle> vehicles = new ArrayList<>();
            String query = "Select * from vehicles where make = ? AND model = ?; ";


            try(Connection connect = dataSource.getConnection();
                PreparedStatement PS = connect.prepareStatement(query);){

                PS.setString(1,make);
                PS.setString(1,model);

                ResultSet results = PS.executeQuery();
                while (results.next()){

                    String vin = results.getString("VIN");
                    String Make = results.getString("make");
                    String Model = results.getString("model");
                    int setYear = results.getInt("year");
                    boolean setSold = results.getBoolean("SOLD");
                    String setColor = results.getString("color");
                    String setVehicleType = results.getString("vehicleType");
                    int setOdometer = results.getInt("odometer");
                    double setPrice = results.getDouble("price");



                    Vehicle vehicle = new Vehicle(vin,Make, Model, setYear, setSold,setColor,setVehicleType,setOdometer,setPrice);
                    vehicles.add(vehicle);

                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            return new ArrayList<>();
        }

        public List<Vehicle> searchByYearRange ( int minYear, int maxYear){
            String query = "Select make, model, year from vehicles where year between ? AND ?; ";
            Vehicle vehicle = null;


            try(Connection connect = dataSource.getConnection();
                PreparedStatement PS = connect.prepareStatement(query);){

                PS.setInt(1, minYear);
                PS.setInt(1, maxYear);


                try(ResultSet results = PS.executeQuery()){
                    List <Vehicle> vehicles = new ArrayList<>();
                    while (results.next()) {
                        vehicle = createVehicleFromResultSet(results);
                        vehicles.add(vehicle);
                    }

                    return vehicles;
                }





            }  catch (Exception madness){
                madness.printStackTrace();
            }
            return new ArrayList<>();
        }

        public List<Vehicle> searchByColor (String color){
            List<Vehicle> vehicles = new ArrayList<>();
            String query = "Select * from vehicles where color = ?; ";


            try(Connection connect = dataSource.getConnection();
                PreparedStatement PS = connect.prepareStatement(query);){

                PS.setString(1,color);


                ResultSet results = PS.executeQuery();
                while (results.next()){

                    String vin = results.getString("VIN");
                    String Make = results.getString("make");
                    String Model = results.getString("model");
                    int setYear = results.getInt("year");
                    boolean setSold = results.getBoolean("SOLD");
                    String setColor = results.getString("color");
                    String setVehicleType = results.getString("vehicleType");
                    int setOdometer = results.getInt("odometer");
                    double setPrice = results.getDouble("price");



                    Vehicle vehicle = new Vehicle(vin,Make, Model, setYear, setSold,setColor,setVehicleType,setOdometer,setPrice);
                    vehicles.add(vehicle);

                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return new ArrayList<>();
        }

        public List<Vehicle> searchByMileageRange ( int minMileage, int maxMileage){
            String query = "Select make, model, year from vehicles where odometer between ? AND ?; ";
            Vehicle vehicle = null;


            try(Connection connect = dataSource.getConnection();
                PreparedStatement PS = connect.prepareStatement(query);){

                PS.setInt(1, minMileage);
                PS.setInt(1, maxMileage);


                try(ResultSet results = PS.executeQuery()){
                    List <Vehicle> vehicles = new ArrayList<>();
                    while (results.next()) {
                        vehicle = createVehicleFromResultSet(results);
                        vehicles.add(vehicle);
                    }

                    return vehicles;
                }





            }  catch (Exception madness){
                madness.printStackTrace();
            }
            return new ArrayList<>();
        }

        public List<Vehicle> searchByType (String type){
            List<Vehicle> vehicles = new ArrayList<>();
            String query = "Select * from vehicles where vehicleType = ?; ";


            try(Connection connect = dataSource.getConnection();
                PreparedStatement PS = connect.prepareStatement(query);){

                PS.setString(1,type);


                ResultSet results = PS.executeQuery();
                while (results.next()){

                    String vin = results.getString("VIN");
                    String Make = results.getString("make");
                    String Model = results.getString("model");
                    int setYear = results.getInt("year");
                    boolean setSold = results.getBoolean("SOLD");
                    String setColor = results.getString("color");
                    String setVehicleType = results.getString("vehicleType");
                    int setOdometer = results.getInt("odometer");
                    double setPrice = results.getDouble("price");



                    Vehicle vehicle = new Vehicle(vin,Make, Model, setYear, setSold,setColor,setVehicleType,setOdometer,setPrice);
                    vehicles.add(vehicle);

                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return new ArrayList<>();
        }

        private Vehicle createVehicleFromResultSet (ResultSet resultSet) throws SQLException {
            Vehicle vehicle = new Vehicle();
            vehicle.setVin(resultSet.getString("VIN"));
            vehicle.setMake(resultSet.getString("make"));
            vehicle.setModel(resultSet.getString("model"));
            vehicle.setYear(resultSet.getInt("year"));
            vehicle.setSold(resultSet.getBoolean("SOLD"));
            vehicle.setColor(resultSet.getString("color"));
            vehicle.setVehicleType(resultSet.getString("vehicleType"));
            vehicle.setOdometer(resultSet.getInt("odometer"));
            vehicle.setPrice(resultSet.getDouble("price"));
            return vehicle;
        }
    }
