package mx.dao;

import java.util.List;
import mx.model.Categoria;
import mx.model.Usuario;

public abstract interface CategoriaDao {

    public abstract List<Categoria> listaCategoria();

    public abstract void newCategoria(Categoria paramCategoria);

    public abstract void updateCategoria(Categoria paramCategoria);

    public abstract void deleteCategoria(Categoria paramCategoria);

    public abstract List<Categoria> listaSubDepto();

    public abstract List<Usuario> listaUsuarios();
}
