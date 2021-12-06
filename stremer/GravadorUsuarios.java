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

public class GravadorUsuarios {
private String nomeArquivo;
	
	public GravadorUsuarios() {
		this.nomeArquivo = "dadosUsuarios.txt";
	}
	
	public GravadorUsuarios(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public void gravarUsuarios(Collection<Login> usuarios) throws IOException {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(nomeArquivo));
			List<Login> usuariosAGravar = new ArrayList<Login>();
			usuariosAGravar.addAll(usuarios);
			out.writeObject(usuariosAGravar);
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
	
	public Collection<Login> recuperarUsuarios() throws IOException{
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(nomeArquivo));
			Collection<Login> usuariosAchados = (Collection<Login>) in.readObject();
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
