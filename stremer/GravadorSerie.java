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

public class GravadorSerie {
private String nomeArquivo;
	
	public GravadorSerie() {
		this.nomeArquivo = "dadosSeries.txt";
	}
	
	public GravadorSerie(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public void gravarSerie(Collection<Programa> series) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
			List<Programa> seriesAGravar = new ArrayList<Programa>();
			seriesAGravar.addAll(series);
			out.writeObject(seriesAGravar);
		} catch (FileNotFoundException e){
			throw new IOException("N�o foi encontrado o arquico " +nomeArquivo);
		} catch (IOException e) {
			throw e;
		} finally {
			if (out!=null) {
				out.close();
			}
		}
	}
	
	public Collection<Programa> recuperarSeries() throws IOException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(nomeArquivo));
			Collection<Programa> usuariosAchados = (Collection<Programa>) in.readObject();
			return usuariosAchados;
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
