/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisionprueba.servicio;

import revisionprueba.repositorio.MySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import revisionprueba.modelo.Base;

/**
 *
 * @author luk0s
 */
public class BaseService {
    
    public static ArrayList<Base> obtenerAreas() {
        ArrayList<Base> areas = new ArrayList<>();
        MySQL mysql = new MySQL();
        try {
            mysql.connect();
            ResultSet resultSetAreas = mysql.executePreparedQuery("SELECT * FROM areas");
            while(resultSetAreas.next()) {
                areas.add(
                    new Base(
                        resultSetAreas.getInt("id"),
                        resultSetAreas.getString("descripcion")
                    )
                );
            }
            mysql.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error al obtener areas");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error al obtener areas");
            System.out.println(ex.getMessage());
        }
        return areas;
    }
    
    public static ArrayList<Base> obtenerPrevisiones() {
        ArrayList<Base> previsiones = new ArrayList<>();
        MySQL mysql = new MySQL();
        try {
            mysql.connect();
            ResultSet resultSetPrevisiones = mysql.executePreparedQuery("SELECT * FROM previsiones");
            while(resultSetPrevisiones.next()) {
                previsiones.add(
                    new Base(
                        resultSetPrevisiones.getInt("id"),
                        resultSetPrevisiones.getString("descripcion")
                    )
                );
            }
            mysql.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error al obtener previsiones");
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error al obtener previsiones");
            System.out.println(ex.getMessage());
        }
        return previsiones;
    }
}
