/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisionprueba.servicio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import revisionprueba.modelo.Base;
import revisionprueba.modelo.Trabajador;
import revisionprueba.repositorio.MySQL;

/**
 *
 * @author luk0s
 */
public class TrabajadorService {
    
    public static ArrayList<Trabajador> obtenerTrabajadores() {
        ArrayList<Trabajador> trabajadores = new ArrayList<>();
        MySQL mysql = new MySQL();
        try {
            mysql.connect();
            ResultSet resultSetTrabajadores = mysql.executePreparedQuery("""
                                                                         select t.*, a.descripcion as area, p.descripcion as prevision
                                                                         from trabajador as t
                                                                         inner join areas as a on a.id = t.area_id
                                                                         inner join previsiones as p on p.id = t.prevision_id
                                                                         order by t.id""");
            while(resultSetTrabajadores.next()) {
                trabajadores.add(
                    new Trabajador(
                        resultSetTrabajadores.getInt("id"),
                        resultSetTrabajadores.getInt("edad"),
                        resultSetTrabajadores.getInt("area_id"),
                        resultSetTrabajadores.getInt("prevision_id"),
                        resultSetTrabajadores.getString("nombre"),
                        resultSetTrabajadores.getString("paterno"),
                        resultSetTrabajadores.getString("materno"),
                        resultSetTrabajadores.getString("area"),
                        resultSetTrabajadores.getString("prevision")
                    )
                );
            }
            mysql.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error al obtener trabajadores");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error al obtener trabajadores");
            System.out.println(ex.getMessage());
        }
        return trabajadores;
    }
    
    public static Boolean guardarTrabajador(
            String id, String nombre, String paterno, String materno,
            String edad, Integer area_id, Integer prevision_id) {
        if (id.isBlank() || nombre.isBlank() || paterno.isBlank() 
                || materno.isBlank() || edad.isBlank()) {
            System.out.println("TODOS LOS CAMPOS SON OBLIGATORIOS");
            return false;
        }
        
        try {
            int idInt = Integer.valueOf(id);
            int edadInt = Integer.valueOf(edad);
            
            MySQL mysql = new MySQL();
            mysql.connect();
            mysql.executePreparedUpdate(
                """
                    INSERT INTO trabajador (id, nombre, paterno, materno, edad, area_id, prevision_id)
                    VALUES (?, ?, ?, ?, ?, ?, ?)
                """, idInt, nombre, paterno, materno, edadInt, area_id, prevision_id);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("EL ID Y LA EDAD DEBEN SER NUMÉRICOS");
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    public static Boolean eliminarTrabajador(String id) {
        if (id.isBlank()) {
            System.out.println("TODOS LOS CAMPOS SON OBLIGATORIOS");
            return false;
        }
        
        try {
            int idInt = Integer.valueOf(id);
            
            MySQL mysql = new MySQL();
            mysql.connect();
            mysql.executePreparedUpdate(
                """
                    DELETE FROM trabajador WHERE id = ?;
                """, idInt);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("EL ID DEBEN SER NUMÉRICOS");
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
}
