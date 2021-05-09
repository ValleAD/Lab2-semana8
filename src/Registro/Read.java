package Registro;

// autor Ángel
import java.sql.SQLException;

public class Read {
    public Read() throws SQLException{
        System.out.println("<<  CONSULTA DE REGISTROS   >>");
        mostrarResultados();
    }
    private void mostrarResultados() throws SQLException{
        try{
            ConexionCRUD utilerias = new ConexionCRUD();
            String tabla = "estudiante";
            String camposTabla = "*";
            
            String condicionBusqueda = "";
            
            utilerias.desplegarregistro(tabla, camposTabla, condicionBusqueda);
        } catch (SQLException ex){
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        } finally{
            Menu_Principal.desplegarMenu();
        }
        
    }
}
