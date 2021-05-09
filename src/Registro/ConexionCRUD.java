
package Registro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class ConexionCRUD {
    private final String servidor = "jdbc:mysql://localhost:3306/Lab2_Semana8";
    private final String user = "root";
    private final String pass = "";
    private final String driverConector = "com.mysql.jdbc.Driver";
     private static Connection conexion;
     
     public static void main(String[] args) {
        
    }
   public  ConexionCRUD () {
        try{
            Class.forName(driverConector);
            conexion =DriverManager.getConnection(servidor,user,pass);
           // System.out.println("conexion exitosa");
        }catch(ClassNotFoundException | SQLException e){
    System.out.println("conexion Falla! Error! :"+e.getMessage());
    }
    }
    public Connection getConnection(){
        return conexion;
    }
    public  void guardarRegistros(String tabla, String camposTabla,String valoresCampos){
        ConexionCRUD conectar =new ConexionCRUD();
       Connection cone=conectar.getConnection();
        try{
            String sqlQueryStmt = "INSERT INTO " + tabla + " (" + camposTabla + ") VALUES(" + valoresCampos + ");";
        Statement stmt;
        stmt = cone.createStatement();
        stmt.executeUpdate(sqlQueryStmt);
        stmt.close();
        cone.close();
            System.out.println("Registro guardado corectamete! ");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  void actualizarEliminarRegistro(String tabla,String valoresCamposNuevos, String condicion) {
         ConexionCRUD conectar =new ConexionCRUD();
       Connection cone=conectar.getConnection();
        try{
           
        Statement stmt;
        String sqlQueryStmt;
            if (valoresCamposNuevos.isEmpty()) {
                sqlQueryStmt="DELETE FROM " + tabla + " WHERE " + condicion + ";";
                System.out.println("registros Eliminados");
            }else{
              sqlQueryStmt = "UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + ";";
            }
        stmt = cone.createStatement();
        stmt.executeUpdate(sqlQueryStmt);
        stmt.close();
        cone.close();
        }catch(SQLException e){
            System.out.println("HA Ocurido el siguente error " + e.getMessage());
        }
    }
    public  void desplegarregistro(String tablaBuscar,  String camposBuscar, String condicionBuscar) throws SQLException {
        ConexionCRUD conectar =new ConexionCRUD();
       Connection cone=conectar.getConnection();
        try{
           
        Statement stmt;
        String sqlQueryStmt;
            if(condicionBuscar .equals("")){
                sqlQueryStmt = " SELECT " + camposBuscar + " FROM " + tablaBuscar + ";";
            }else{
                sqlQueryStmt = " SELECT " + camposBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar;
            }
            stmt = cone.createStatement();
            stmt.executeQuery(sqlQueryStmt);  
            try(ResultSet miResultSet = stmt.executeQuery(sqlQueryStmt)){
                if (miResultSet.next()) {
                    ResultSetMetaData metaData = miResultSet.getMetaData();
                    int numColumnas =metaData.getColumnCount();
                    System.out.println("<< REGISTROS ALMACENADOS >>");  
                    System.out.println();
                    for (int i = 1; numColumnas > i; i++) {
                        System.out.printf("%-20s\t", metaData.getColumnName(i));
                    }
                    System.out.println();
                    do {
                        for (int i = 1; numColumnas > i; i++) {
                            System.out.printf("%-20s\t", miResultSet.getObject(i));
                        }
                         System.out.println();
                         
                    } while (miResultSet.next());
                    System.out.println();
                }else{
                    System.out.println("No se han encontrado registros");
                    miResultSet.close();
                }
            }finally{
                     stmt.close();
                     cone.close();
            }
          } catch (SQLException e){
              System.out.println("Ha ocurrido el Siguiente Error"+e.getMessage());
              System.out.println("se han encontrado problemas... ");
          }     
    }   
} 


