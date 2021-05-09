package Registro;

// autor Ángel
import java.sql.SQLException;

public class Read {
    public Read() throws SQLException{
        System.out.println("<<  CONSULTA DE REGISTROS   >>");
        mostrarResultados();
    }
 private void mostrarResultados() throws SQLException {
       try{
           ConexionCRUD utileria= new ConexionCRUD();
       String tabla = "estudiante";
       String composTabla ="*";
       String condicionBusqueda="";
       utileria.desplegarregistro(tabla, composTabla, condicionBusqueda);
       
       } catch (SQLException e){
           System.out.println("Ha ocurrido siguiente error: " +  e.getMessage());
       
       }finally{
           Menu_Principal.desplegarMenu();
       }
    }
}
