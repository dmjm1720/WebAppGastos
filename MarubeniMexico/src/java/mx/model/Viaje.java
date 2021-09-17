package mx.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Viaje implements Serializable {

    private int idViaje;
    private String folioUsuario;
    private Date fechaDocumento;
    private String oficina;
    private String nombreViajero;
    private String origen;
    private String destino;
    private String proposito;
    private Date fechaOrigen;
    private Date fechaLlegada;
    private String status;
    private Integer dias;
    private BigDecimal totalAsignado;
    private String departamento;
    private String fechaAno;
    private BigDecimal tipoCambio;
    private String tipoMoneda;
    private String tipoViaje;
    private String layout;
    private String seccion;
    private String comentario;
    private String mutual;

    public Viaje() {
    }

    public Viaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public Viaje(int idViaje, String folioUsuario, Date fechaDocumento, String oficina, String nombreViajero, String origen, String destino, String proposito, Date fechaOrigen, Date fechaLlegada, String status, Integer dias, BigDecimal totalAsignado, String departamento, String fechaAno, BigDecimal tipoCambio, String tipoMoneda, String tipoViaje, String layout, String seccion, String comentario, String mutual) {
        this.idViaje = idViaje;
        this.folioUsuario = folioUsuario;
        this.fechaDocumento = fechaDocumento;
        this.oficina = oficina;
        this.nombreViajero = nombreViajero;
        this.origen = origen;
        this.destino = destino;
        this.proposito = proposito;
        this.fechaOrigen = fechaOrigen;
        this.fechaLlegada = fechaLlegada;
        this.status = status;
        this.dias = dias;
        this.totalAsignado = totalAsignado;
        this.departamento = departamento;
        this.fechaAno = fechaAno;
        this.tipoCambio = tipoCambio;
        this.tipoMoneda = tipoMoneda;
        this.tipoViaje = tipoViaje;
        this.layout = layout;
        this.seccion = seccion;
        this.comentario = comentario;
        this.mutual = mutual;
    }

    public int getIdViaje() {
        return this.idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public String getFolioUsuario() {
        return this.folioUsuario;
    }

    public void setFolioUsuario(String folioUsuario) {
        this.folioUsuario = folioUsuario;
    }

    public Date getFechaDocumento() {
        return this.fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getOficina() {
        return this.oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getNombreViajero() {
        return this.nombreViajero;
    }

    public void setNombreViajero(String nombreViajero) {
        this.nombreViajero = nombreViajero;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getProposito() {
        return this.proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public Date getFechaOrigen() {
        return this.fechaOrigen;
    }

    public void setFechaOrigen(Date fechaOrigen) {
        this.fechaOrigen = fechaOrigen;
    }

    public Date getFechaLlegada() {
        return this.fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDias() {
        return this.dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public BigDecimal getTotalAsignado() {
        return this.totalAsignado;
    }

    public void setTotalAsignado(BigDecimal totalAsignado) {
        this.totalAsignado = totalAsignado;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFechaAno() {
        return this.fechaAno;
    }

    public void setFechaAno(String fechaAno) {
        this.fechaAno = fechaAno;
    }

    public BigDecimal getTipoCambio() {
        return this.tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getTipoMoneda() {
        return this.tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getTipoViaje() {
        return this.tipoViaje;
    }

    public void setTipoViaje(String tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    public String getLayout() {
        return this.layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getSeccion() {
        return this.seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getMutual() {
        return this.mutual;
    }

    public void setMutual(String mutual) {
        this.mutual = mutual;
    }
 }

