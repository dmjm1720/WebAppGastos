package mx.dao;

import mx.model.Usuario;

public abstract interface LoginDao {

    public abstract Usuario obternerDatosUsuario(Usuario usuario);

    public abstract Usuario login(Usuario usuario);

    public abstract Usuario obternerDatosUsuarioPrimeraValidacion(Usuario usuario);

    public abstract Usuario loginPrimeraValidacion(Usuario usuario);
}
