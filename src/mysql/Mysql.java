
package mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;




public class Mysql {

    
    //metodo main
public static void main(String[] args) throws SQLException  { 
    //Se instancia el objeto de la clase conexion
    int id,temp,acumulador,promedio,opcion=1;
    String valorEntrada="",consultaInsert="";
    acumulador=0;
conexion conn = new conexion();
// se crea el arreglo el cual almacenará los registros
ArrayList arreglo = new ArrayList();
//Creamos una variable con la query
    String sql = "SELECT * FROM regtemp";
    //creamos un objeto de tipo result set el cual se encarga
    //de almacenar los datos que devuelve la query
    // para esto le enviamos la variable SQL la cual contiene la query
    ResultSet rs = conn.obtenerDatos(sql);

    while(opcion==1){
        valorEntrada=JOptionPane.showInputDialog("Ingrese la temperatura que desea Registrar");
        consultaInsert= "INSERT INTO regtemp (temperatura) VALUES("+valorEntrada+")";
        System.out.println("Ejecutando Query de prueba :"+valorEntrada);
        conn.insertarRegistro(consultaInsert);
        opcion=Integer.parseInt(JOptionPane.showInputDialog("Desea ingresar otro registro? 1) Si  2) No") );  
     System.out.println("Opcion"+opcion);
    }
    
    
    //ciclo while el cual se encarga de 
    //recorrer los datos que me envia la base de datos
    while(rs.next()){
     id  = rs.getInt("id");
    temp = rs.getInt("temperatura");
    arreglo.add(temp);                   
      }
    //declaramos una variable la cual contiene el largo del arreglo
    int longitudArray=arreglo.size();

    
    //recorremos el arreglo
        for(int e=0; e<longitudArray; e++){
              System.out.println("Mostrando el valor en la posicion :"+e);
             
              System.out.println(arreglo.get(e));
              acumulador+=Integer.parseInt(arreglo.get(e).toString());
                          
        }
        
        
        
        promedio=acumulador/longitudArray;
        System.out.println("El Promedio es :"+promedio);
        


    }
    
}
