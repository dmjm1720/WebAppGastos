package mx.dao;

import java.util.List;
import mx.model.Concepto;
import mx.model.Usuario;

public abstract interface PerfilDao
{
  public abstract List<Usuario> listaUsuarios();
  
  public abstract List<Concepto> listaModificar();
  
  public abstract List<Usuario> admonPoliza();
}


