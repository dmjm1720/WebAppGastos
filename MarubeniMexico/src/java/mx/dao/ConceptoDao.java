package mx.dao;

import java.util.List;
import mx.model.Concepto;
import mx.model.Usuario;

public interface ConceptoDao {

    public List<Concepto> listaConcepto();

    public List<Concepto> listaConceptoUSD();

    public List<Concepto> listaSAT();

    public List<Usuario> listaporNombre();

    public void nuevoConcepto(Concepto paramConcepto);

    public void updateConcepto(Concepto paramConcepto);

    public void deleteConcepto(Concepto paramConcepto);

    public void updateConcepto(String uuid, String foliousuario, String nombreusuario, String foliousuariox);

    public void deleteConceptoViaje(int folio);

    public List<Concepto> listaConceptoBorrar(String nombre, String folio);

    public List<Concepto> listaConceptoViaje(String nombre, String folio);
    
    public List<Concepto> listaConceptoReporte(String f1, String f2);

}
