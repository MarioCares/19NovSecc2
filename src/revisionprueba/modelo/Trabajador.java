/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisionprueba.modelo;

/**
 *
 * @author luk0s
 */
public class Trabajador {
    
    private Integer Id, Edad, AreaId, PrevisionId;
    private String Nombre, Paterno, Materno;
    
    private String Area, Prevision;

    public Trabajador(Integer Id, Integer Edad, Integer AreaId, Integer PrevisionId, 
            String Nombre, String Paterno, String Materno,
            String Area, String Prevision) {
        this.Id = Id;
        this.Edad = Edad;
        this.AreaId = AreaId;
        this.PrevisionId = PrevisionId;
        this.Nombre = Nombre;
        this.Paterno = Paterno;
        this.Materno = Materno;
        this.Area = Area;
        this.Prevision = Prevision;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }

    public Integer getAreaId() {
        return AreaId;
    }

    public void setAreaId(Integer AreaId) {
        this.AreaId = AreaId;
    }

    public Integer getPrevisionId() {
        return PrevisionId;
    }

    public void setPrevisionId(Integer PrevisionId) {
        this.PrevisionId = PrevisionId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPaterno() {
        return Paterno;
    }

    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    public String getMaterno() {
        return Materno;
    }

    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getPrevision() {
        return Prevision;
    }

    public void setPrevision(String Prevision) {
        this.Prevision = Prevision;
    }
    
    
}
