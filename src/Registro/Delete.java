
package Registro;

/**
 *
 * @author Cristian Alvarez
 */
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    
 Delete () throws SQLException {
        Scanner leer = new Scanner(System.in);
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ELIMINAR REGISTRO >>");
        
        System.out.println("Ingresar id del registro a modificar");
        String idContactoEliminar = leer.next();
        
        //reingreso de datos para actualizar
        String tabla = "estudiante";
        String campos = "*";
        String condicion = "id_estudiante = " + idContactoEliminar;
        utilerias.desplegarregistro(tabla, campos, condicion);
        
        System.out.println("Presionar << Y >> para confirmar: ");
        String confirmarBorrar = leer.next();
        
        if ("Y".equals(confirmarBorrar)) {
            /* Se le deja un vacio para el método actualizarEliminarRegistro
              envíe solamente los parametros de tabla y condicion y poder eliminar */
            
            String ValoresCamposNuevos = "";
            
            utilerias.actualizarEliminarRegistro(tabla, ValoresCamposNuevos, condicion);
            System.out.println("Registro Borrado Satisfactoriamente!");
        }
        Menu_Principal.desplegarMenu();
 }
    
}
