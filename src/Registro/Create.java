package Registro;

 // author Ángel

import java.sql.SQLException;
import java.util.Scanner;
 
public class Create {
    
    Create() throws SQLException {
        Scanner leer = new Scanner(System.in);
        Estudiante est = new Estudiante(); //Objeto est de la clase Estudiante
        System.out.println("<<  CREAR REGISTRO  >>");
        
        
        System.out.println("Carnet: ");
        est.setCarnet_estudiante(leer.nextLine());
        
        
        System.out.println("Nombre: ");
        est.setNom_estudiante(leer.nextLine());
        
        System.out.println("Apellidos");
        est.setApe_estudiante(leer.nextLine());
        
        System.out.println("Edad: ");
        est.setEdad(leer.nextInt());
        
        String tabla = "estudiante";
        String camposTabla = " carnet_estudiante, nom_estudiante, ape_estudiante, edad";
        String valoresCampos = "'" + est.getCarnet_estudiante()+ "', '" + est.getNom_estudiante()+ "', '" + est.getApe_estudiante()+ "', '" + est.getEdad()+ "'";
        
        // Objeto de la clase ConexionCRUD
        ConexionCRUD utilerias = new ConexionCRUD();
        
        utilerias.guardarRegistros(tabla, camposTabla, valoresCampos);
        
        Menu_Principal.desplegarMenu();
    }
}
