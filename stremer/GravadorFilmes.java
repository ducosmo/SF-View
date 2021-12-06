package stremer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GravadorFilmes {
	
	private String nomeArquivo;
	
	public GravadorFilmes() {
		this.nomeArquivo = "dadosFilmes.txt";
	}
	
	public GravadorFilmes(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public void gravarFilmes(Collection<Programa> filmes) throws IOException{
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
			List<Programa> filmesAGravar = new ArrayList<Programa>();
			filmesAGravar.addAll(filmes);
			out.writeObject(filmesAGravar);
		} catch (FileNotFoundException e){
			throw new IOException("Nao foi encontrado o arquico " +nomeArquivo);
		} catch (IOException e) {
			throw e;
		} finally {
			if (out!=null) {
				out.close();
			}
		}
	}
	
	public Collection<Programa> recuperarFilmes() throws IOException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(nomeArquivo));
			Collection<Programa> programasAchados = (Collection<Programa>) in.readObject();
			return programasAchados;
		} catch (FileNotFoundException e) {
			throw new IOException("N�o foi encontrado o arquivo" +nomeArquivo);
		} catch (IOException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw new IOException("Classe de objetos gravados no arquivo " +nomeArquivo + " n�o existe.");
		} finally {
			if (in!=null) {
				in.close();
			}
		}
	}

}
