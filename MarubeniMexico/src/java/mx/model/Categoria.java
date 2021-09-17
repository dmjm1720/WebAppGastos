package mx.model;

import java.io.Serializable;

public class Categoria
        implements Serializable {

    private int idCategoria;
    private String subDepartamento;
    private String usuario;

    public Categoria() {
    }

    public Categoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(int idCategoria, String subDepartamento, String usuario) {
        this.idCategoria = idCategoria;
        this.subDepartamento = subDepartamento;
        this.usuario = usuario;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getSubDepartamento() {
        return this.subDepartamento;
    }

    public void setSubDepartamento(String subDepartamento) {
        this.subDepartamento = subDepartamento;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
