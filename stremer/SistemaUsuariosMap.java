package stremer;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaUsuariosMap implements Usuarios{
    private Map<String, Login> usuarios;
	private Map<String, Programa> programacao;
	public GravadorUsuarios gravadorDeUsuarios;
	//listar, pesquisar
    //cadastra, remove, alterar
    public SistemaUsuariosMap(){
        this.programacao = new HashMap<>();
        this.usuarios = new HashMap<>();
        this.gravadorDeUsuarios = new GravadorUsuarios();
    }
    
	@Override
    public void cadastraFilme(String nome, int ano, List<Genero> generos, String sinopese, String autor) throws ProgramaJaExistenteException {
           if(programacao.containsKey(nome)){
               throw new ProgramaJaExistenteException("Ja existe uma programacao com este nome.");
           }else{
               Programa filme = new Programa(nome, ano, generos,1, sinopese, autor, Tipos.FILME);
               programacao.put(nome, filme);
           }
    }
	
	public void cadastraSerie(String nome, int ano, List<Genero> generos, int quantEp, String sinopese, String autor) throws ProgramaJaExistenteException {
        if(programacao.containsKey(nome)){
            throw new ProgramaJaExistenteException("Ja existe uma programacao com este nome.");
        }else{
            Programa serie = new Programa(nome, ano, generos, quantEp, sinopese, autor, Tipos.SERIE);
            programacao.put(nome, serie);
        }
 }
    
    public void remove(String nome)throws ProgramacaoInexistenteException{
            if(programacao.containsKey(nome)){
                programacao.remove(nome);
            }else{
                throw new ProgramacaoInexistenteException("Nao existe esta programacao.");
            }
        
    }
    
    public Collection<Programa> listarFilmes(){
    	Collection<Programa> lista = new ArrayList<>();
    	for(Programa p : programacao.values()) {
    		if(p.getTipo().equals(Tipos.FILME)) {
    			lista.add(p);
    		}
    	}
    	return lista;
    }
    public List<Programa> listarSeries(){
    	List<Programa> lista = new ArrayList<>();
    	for(Programa p : programacao.values()) {
    		if(p.getTipo().equals(Tipos.SERIE)) {
    			lista.add(p);
    		}
    	}
    	return lista;
    }
    
    public String pesquisar(String nome)throws ProgramacaoInexistenteException {
    	if(programacao.containsKey(nome)) {
    		return programacao.get(nome).toString();
    	}else {
    		throw new ProgramacaoInexistenteException("Programacao inexistente.");
    	}
    }

    public boolean login(String usuario, String senha)throws UsuarioInexistenteException{
        if(usuarios.containsKey(usuario)){
            if(usuarios.get(usuario).getSenha().equals(senha)){
                if(usuarios.get(usuario).getTipo().equals(Tipos.USUARIO)){
                    return true;
                }else{
                    return false;
                }
            }else{
                throw new  UsuarioInexistenteException("Usuario ou senha esta incorreto.");
            }
        }else{
            throw new  UsuarioInexistenteException("Usuario ou senha esta incorreto.");
        }
    }
    public void cadastraUsuario(String usuario, String senha)throws UsuarioJaExistenteException{
        if(usuarios.containsKey(usuario)){
            throw new UsuarioJaExistenteException("Usuario ja existente");
        }else{
            Login usu = new Login(usuario, senha, Tipos.USUARIO);
            usuarios.put(usuario, usu);
            try{
    			gravadorDeUsuarios.gravarUsuarios(this.getUsuario());
    			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
    			} catch (IOException e1){
    			JOptionPane.showMessageDialog(null, "Problema ao salvar dados");
    			e1.printStackTrace();
    			}
        }
        
    }
    @Override
    public void cadastraSuperUsuario(String usuario, String senha, String codigo)throws UsuarioJaExistenteException, CodigoDesconhecidoException{
        if(usuarios.containsKey(usuario)){
            throw new UsuarioJaExistenteException("Usuario ja existente");
        }else{
            if(codigo.equals("210601121092")){
                Login usu = new Login(usuario, senha, Tipos.SUPERUSUARIO);
                usuarios.put(usuario, usu);
                try{
        			gravadorDeUsuarios.gravarUsuarios(this.getUsuario());
        			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        			} catch (IOException e1){
        			JOptionPane.showMessageDialog(null, "Problema ao salvar dados");
        			e1.printStackTrace();
        			}
            }else{
                throw new CodigoDesconhecidoException("O codigo desconhecido.");
            }
        }
        
    }
    
    public boolean progucaraNome(String nome) {
    	return programacao.containsKey(nome);
    }
    
    public List<Genero> selecionaGenero(){
    	List<Genero> generos = new ArrayList<>();
    	boolean continuar = true;
		do {
			String valor = JOptionPane.showInputDialog("~Escolha os generos para o Filme/Serie digitando o numero correspondente~ \n"
				+ "1-ACAO\n"
				+ "2-AVENTURA\n"
				+ "3-DRAMA\n"
				+ "4-COMEDIA\n"
				+ "5-FICCAO_CIENTIFICA\n"
				+ "6-TERROR\n"
				+ "7-ROMANCE\n"
				+ "8-concluir");
			
			switch(valor) {
			case "1":
				generos.add(Genero.ACAO);
				break;
			case "2":
				generos.add(Genero.AVENTURA);
				break;
			case "3":
				generos.add(Genero.DRAMA);
				break;
			case "4":
				generos.add(Genero.COMEDIA);
				break;
			case "5":
				generos.add(Genero.FICCAO_CIENTIFICA);
				break;
			case "6":
				generos.add(Genero.TERROR);
				break;
			case "7":
				generos.add(Genero.ROMANCE);
				break;
			case "8":
				JOptionPane.showMessageDialog(null, "Generos salvos.");
				continuar = false;
				break;
			}
		}while(continuar == true);
    	return generos;
    } 

    public void setFilme(Collection<Programa> filmes){
    	for(Programa a: filmes){
            this.programacao.put(a.getNome(), a);
        }
    }
    
    public void setSerie(Collection<Programa> series){
        for(Programa a: series){
            this.programacao.put(a.getNome(), a);
        }
    }
    
    public void setUsuario(Collection<Login> usuarios){
    	for(Login a: usuarios) {
    		this.usuarios.put(a.getUsuario(), a);
    	}
    	
    }

    public Collection<Programa> getFilme(){
        return this.listarFilmes();
    }
    
    public Collection<Programa> getSerie(){
        return this.listarSeries();
    }
    
    public Collection<Login> getUsuario(){
    	return this.usuarios.values();
    }
}

