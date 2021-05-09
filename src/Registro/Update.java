
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
        est.setId_estudiante(leer.nextInt());
        
        //reingreso de datos para actualizar
        String tablaBuscar = "estudiante";
        String camposBuscar = "id_estudiante, nom_estudiante, ape_estudiante, carnet_estudiante, Edad";
        String condicionBuscar = "id_estudiante = " + est.getId_estudiante();
        utilerias.desplegarregistro(tablaBuscar, camposBuscar, condicionBuscar);
        
        System.out.println("Nombre: ");
        est.setNom_estudiante(leer.next());
        
        System.out.println("Apellido: ");
        est.setApe_estudiante(leer.next());
        
        System.out.println("Carnet: ");
        est.setCarnet_estudiante(leer.next());
        
         System.out.println("Edad: ");
        est.setEdad(leer.nextInt());
        
        String tabla = "estudiante";
        String camposValoresNuevos = "nom_estudiante  = '" + est.getNom_estudiante() + "', Ape_estudiante = '"
                + est.getApe_estudiante() + "', carnet_estudiante = '" + est.getCarnet_estudiante() + "', edad = '"
                + est.getEdad() + "'";
        
        utilerias.actualizarEliminarRegistro(tabla, camposValoresNuevos, condicionBuscar);
        System.out.println("Modificado correctamente!");
        
        Menu_Principal.desplegarMenu();
        
        
     }
    
}
