package stremer;

import java.io.Serializable;
import java.util.List;

public class Programa implements Serializable {
    protected String nome;
	protected int ano;
	protected List<Genero> generos;
	protected int quantEp;
	protected String sinopse;
	protected String autor;
	private Tipos tipo;

    public Programa(String nome, int ano, List<Genero> generos,int quantEp, String sinopse, String autor, Tipos tipo){
        this.nome = nome;
        this.ano = ano;
        this.generos = generos;
        this.quantEp = quantEp;
        this.sinopse = sinopse;
        this.autor = autor;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Tipos getTipo(){
        return tipo;
    }
    
    public int getQuantEp() {
		return quantEp;
	}

	public void setQuantEp(int quantEp) {
		this.quantEp = quantEp;
	}

	@Override
	public String toString() {
		return "____Programcao____\n Nome: "+nome+"\n Ano: "+ano+"\n Generos: "+generos+"\n Episodios: "+quantEp+"\n Sinopse: "+sinopse+"\n Autor: "+autor+"\n Tipo: "+tipo+"\n __________________";
	}

	
    
    
}
