/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Angel Vargas
 */
public class Libro {
    private String codigo;
    private String nombrelibro;
    private String pasta;
    private String editorial;
    private String añopublicacion;

    /**Lo siguiente es el metodo constructor
     * Asigna los valores codigo, nombre,, correo, etc. a los atributos respectivamente
     */
    public Libro(String codigo, String nombrelibro, String pasta, String editorial, String añopublicacion) {
        this.codigo = codigo;
        this.nombrelibro = nombrelibro;
        this.pasta = pasta;
        this.editorial = editorial;
        this.añopublicacion = añopublicacion;
    }
    
    /*Esto lo agruegue porque nose porque, pero es un metodo constructor*/
    public Libro(){
        this.nombrelibro="Libro de mi ejemplo";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAñopublicacion() {
        return añopublicacion;
    }

    public void setAñopublicacion(String añopublicacion) {
        this.añopublicacion = añopublicacion;
    }
    
    
    
    
    
}
