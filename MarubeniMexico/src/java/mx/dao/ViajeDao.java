package mx.dao;

import java.util.List;
import mx.model.Categoria;
import mx.model.Usuario;
import mx.model.Viaje;

public abstract interface ViajeDao
{
  public abstract List<Viaje> listaViajes();
  
  public abstract List<Viaje> listaPorFolio();
  
  public abstract List<Usuario> listaporNombre();
  
  public abstract List<Categoria> listaDepto();
  
  public abstract void newViaje(Viaje paramViaje);
  
  public abstract void updateViaje(Viaje paramViaje);
  
  public abstract void deleteViaje(Viaje paramViaje);
  
  public abstract List<Viaje> listaViajesConcluidos();
}


