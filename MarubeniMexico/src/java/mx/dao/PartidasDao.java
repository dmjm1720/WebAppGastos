package mx.dao;

import java.util.List;
import mx.model.Partidas;

public abstract interface PartidasDao
{
  public abstract List<Partidas> listaPartidas();
  
  public abstract void nuevaPartida(Partidas paramPartidas);
  
  public abstract void actualizarPartida(Partidas paramPartidas);
  
  public abstract void updatePartida(Partidas paramPartidas);
}


