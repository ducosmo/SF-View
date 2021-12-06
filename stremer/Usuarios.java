package stremer;

import java.util.Collection;
import java.util.List;

public interface Usuarios {
	public void cadastraFilme(String nome, int ano, List<Genero> generos, String sinopese, String autor) throws ProgramaJaExistenteException;
	public void remove(String nome)throws ProgramacaoInexistenteException;
	public Collection<Programa> listarFilmes();
	public List<Programa> listarSeries();
	public void cadastraSerie(String nome, int ano, List<Genero> generos, int quantEp, String sinopese, String autor) throws ProgramaJaExistenteException;
	public String pesquisar(String nome)throws ProgramacaoInexistenteException;
	public void cadastraSuperUsuario(String usuario, String senha, String codigo)throws UsuarioJaExistenteException, CodigoDesconhecidoException;
	public void cadastraUsuario(String usuario, String senha)throws UsuarioJaExistenteException;
	public boolean login(String usuario, String senha)throws UsuarioInexistenteException;
	public List<Genero> selecionaGenero();
	public void setFilme(Collection<Programa> filmes);
	public Collection<Programa> getFilme();
	public void setSerie(Collection<Programa> series);
	public Collection<Programa> getSerie();
	public Collection<Login> getUsuario();
	public void setUsuario(Collection<Login> usuarios);
	public boolean progucaraNome(String nome); 
//	JTextField
//	JPanel
}
