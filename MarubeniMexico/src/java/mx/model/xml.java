package mx.model;

import java.io.Serializable;

public class xml implements Serializable {

    private String xml;
    private String uuid;
    private int estatus;
    private String observacion;
    private int bandera;
    private String numerosat;
    private String numerousuario;

    public xml() {
    }

    public xml(String xml) {
        this.xml = xml;
    }

    public xml(String xml, String uuid, int estatus, String observacion, int bandera, String numerosat, String numerousuario) {
        this.xml = xml;
        this.uuid = uuid;
        this.estatus = estatus;
        this.observacion = observacion;
        this.bandera = bandera;
        this.numerosat = numerosat;
        this.numerousuario = numerousuario;
    }

    public void setxml(String xml) {
        this.xml = xml;
    }

    public void setuuid(String uuid) {
        this.uuid = uuid;
    }

    public void setestatus(int estatus) {
        this.estatus = estatus;
    }

    public void setobservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setbandera(int bandera) {
        this.bandera = bandera;
    }

    public void setnumerosat(String numerosat) {
        this.numerosat = numerosat;
    }

    public void setnumerousuario(String numerousu) {
        this.numerousuario = numerousu;
    }

    public String getxml() {
        return this.xml;
    }

    public String getuuid() {
        return this.uuid;
    }

    public int getEstatus() {
        return this.estatus;
    }

    public String getobservacion() {
        return this.observacion;
    }

    public int getbandera() {
        return this.bandera;
    }

    public String getnumerosat() {
        return this.numerosat;
    }

    public String getnumerousuario() {
        return this.numerousuario;
    }

}
