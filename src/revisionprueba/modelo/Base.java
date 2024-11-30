/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisionprueba.modelo;

/**
 *
 * @author luk0s
 */
public class Base {
    
    private Integer Id;
    private String Descripcion;

    public Base(Integer Id, String Descripcion) {
        this.Id = Id;
        this.Descripcion = Descripcion;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return Descripcion;
    }
    
    
}
