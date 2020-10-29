package mx.dao;

import java.util.List;
import mx.model.Concepto;
import mx.model.Usuario;

public abstract interface ConceptoDetalleDao
{
  public abstract List<Concepto> listaConcepto();
  
  public abstract List<Concepto> listaSAT();
  
  public abstract List<Usuario> listaPorFolio();
  
  public abstract void nuevoConcepto(Concepto paramConcepto);
  
  public abstract void updateConcepto(Concepto paramConcepto);
  
  public abstract void deleteConcepto(Concepto paramConcepto);
}


