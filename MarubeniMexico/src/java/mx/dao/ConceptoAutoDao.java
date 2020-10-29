package mx.dao;

import java.util.List;
import mx.model.Concepto;
import mx.model.Usuario;

public abstract interface ConceptoAutoDao
{
  public abstract List<Concepto> listaConcepto();
  
  public abstract List<Concepto> listaConceptoUSD();
  
  public abstract List<Concepto> listaSAT();
  
  public abstract List<Usuario> listaporNombre();
  
  public abstract void nuevoConcepto(Concepto paramConcepto);
  
  public abstract void updateConcepto(Concepto paramConcepto);
  
  public abstract void deleteConcepto(Concepto paramConcepto);
}


