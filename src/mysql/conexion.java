package mysql;
import java.sql.*;
public class conexion {
    //declaramos la url de la base de datos
    static final String DATABASE_URL = "jdbc:mysql://localhost/basededatos";
    //declaramos el usuario que se conectará
    String usuario = "root";
    //declaramos las atributos de la clase
    Connection connection = null;
    Statement statement = null; 
    ResultSet resultSet = null; 
   //constructor 
    public conexion() throws SQLException { 
        //intentamos conectar con la base de datos
        try {
            connection = DriverManager.getConnection(DATABASE_URL,usuario , "");
             
//en el caso de que se encuentre un error se alertará por consola
        } catch (SQLException ex) {
            System.out.println("Ocurrió un error :" + ex.getMessage());
        }
    }

    public void DisconnectFromDB() {

        try {
            resultSet.close();
            statement.close();
            connection.close();
        }                                              
        catch (Exception ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        } 
    }

    public ResultSet obtenerDatos(String sql_stmt) {
        try {
            statement = connection.createStatement();                                   
            resultSet = statement.executeQuery(sql_stmt);
             System.out.println(resultSet);  
            return resultSet;          
        } 
        catch (SQLException ex) {
            System.out.println("Hay un error :( " + ex.getMessage());
        }                                                    
        return resultSet;
    }

    public void insertarRegistro(String sql_stmt) {
        try {
            statement = connection.createStatement();
                                    
            statement.executeUpdate(sql_stmt);
        } 
        catch (SQLException ex) {
            System.out.println("Ocurrio un error" + ex.getMessage());
        }
    }
    
    
    public void borrarRegistroTemp(int idRegistro) {
        try {
            statement = connection.createStatement();
             String queryDelete="delete from regTemp where id = "+idRegistro;                     
            statement.executeUpdate(queryDelete);
        } 
        catch (SQLException ex) {
            System.out.println("Ocurrio un error" + ex.getMessage());
        }
    }
}