
package Registro;

/**
 *
 * @author Cristian Alvarez
 */
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
     Update () throws SQLException {
        Scanner leer = new Scanner(System.in);
        Estudiante est = new Estudiante();
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ACTUALIZAR INGRESO >>");
        
        System.out.println("Ingresar id del registro a modificar");
        est.setId_Estudiante(leer.nextInt());
        
        //reingreso de datos para actualizar
        String tablaBuscar = "tb_Estudiante";
        String camposBuscar = "id_Estudiante, Nom_Estudiante, Ape_Estudiante, Carnet_Estudiante, Edad_Estudiante";
        String condicionBuscar = "id_Estudiante = " + est.getId_Estudiante();
        utilerias.desplegarRegistros(tablaBuscar, camposBuscar, condicionBuscar);
        
        System.out.println("Nombre: ");
        est.setNom_Estudiante(leer.next());
        
        System.out.println("Apellido: ");
        est.setApe_Estudiante(leer.next());
        
        System.out.println("Carnet: ");
        est.setCarnet_Estudiante(leer.next());
        
         System.out.println("Edad: ");
        est.setEdad_Estudiante(leer.next());
        
        String tabla = "tb_contacto";
        String camposValoresNuevos = "Nom_Estudiante - '" + est.getNom_Estudiante() + "', Apellido_Estudiante = '"
                + est.getApe_Estudiante() + "', Carnet_Estudiante = '" + est.getCarnet_Estudiante() + "', Edad_Estudiante = '"
                + est.getEdad_Estudiante() + "'";
        
        utilerias.actucalizarEliminarRegistro(tabla, camposValoresNuevos, condicionBuscar);
        System.out.println("Modificado correctamente!");
        
        Menu_Principal.desplegarMenu();
        
        
     }
    
}
