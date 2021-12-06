package stremer;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SistemaUsuariosMapTeste {

	@Test
	void testcadastraFilme() {
		List<Genero> generos = new LinkedList<>();
		generos.add(Genero.ACAO);
		generos.add(Genero.DRAMA);
		Usuarios sistema = new SistemaUsuariosMap();
		try {
			sistema.cadastraFilme("Venom", 0, generos, "", "");
			assertTrue(sistema.progucaraNome("Venom"));
		}catch (ProgramaJaExistenteException e){
			fail("Não deveria ter lançado exceçao.");
		}
	}
	@Test
	void testcadastraSerie() {
		List<Genero> generos = new LinkedList<>();
		generos.add(Genero.ACAO);
		Usuarios sistema = new SistemaUsuariosMap();
		try {
			sistema.cadastraSerie("Upload", 2020, generos, 9, "", "");
			assertTrue(sistema.progucaraNome("Upload"));
		}catch (ProgramaJaExistenteException e){
			fail("Nao deveria ter lançado excecao.");
		}
	}
	@Test
	void testcadastraSuperUsuario() {
		SistemaUsuariosMap sistema = new SistemaUsuariosMap();
		try{
			sistema.cadastraSuperUsuario("fulano", "5555", "210601121092");
			
		} catch (UsuarioJaExistenteException | CodigoDesconhecidoException e){
			fail("Nao deveria ter lançado excecao.");
		}

		assertThrows(CodigoDesconhecidoException.class,()-> sistema.cadastraSuperUsuario("beltrano", "7777", "210601121093"));

	} 
	@Test
	void testcadastraUsuario() {
		SistemaUsuariosMap sistema = new SistemaUsuariosMap();
		try{
			sistema.cadastraUsuario("juliario", "2523");
		} catch (UsuarioJaExistenteException e){
			fail("Nao deveria lancar execessao");
		}
		try{
			sistema.cadastraUsuario("pedristano", "2523");
		} catch (UsuarioJaExistenteException e){
			fail("Nao deveria lancar execessao");
		}
		assertThrows(UsuarioJaExistenteException.class,()-> sistema.cadastraUsuario("juliario", "5458"));
		
	}
	@Test
	void testlogin() {
	SistemaUsuariosMap sistema = new SistemaUsuariosMap();
		try{
			sistema.cadastraUsuario("juliario", "2523");
			sistema.cadastraSuperUsuario("fulano", "5555", "210601121092");
		} catch (UsuarioJaExistenteException | CodigoDesconhecidoException e){
			fail("Nao deveria ter lançado excecao.");
		}
		try{
			sistema.login("juliario", "2523");
		} catch(UsuarioInexistenteException e){
			fail("Nao deveria lancar excecao.");
		}

		
	}
	@Test
	void testremove() {
		List<Genero> generos = new LinkedList<>();
		generos.add(Genero.ACAO);
		generos.add(Genero.DRAMA);
		Usuarios sistema = new SistemaUsuariosMap();
		try {
			sistema.cadastraFilme("Venom", 0, generos, "", "");
			assertTrue(sistema.progucaraNome("Venom"));
		}catch (ProgramaJaExistenteException e){
			fail("Não deveria ter lançado exceçao.");
		}
		try {
			sistema.remove("Venom");
		} catch (ProgramacaoInexistenteException e) {
			fail("Nao deveria mandar excecao");
		}
		assertThrows(ProgramacaoInexistenteException.class,()->sistema.pesquisar("Venom"));
	}
	@Test
	void testlistarFilmes() {
		List<Genero> generos1 = new LinkedList<>();
		List<Genero> generos2 = new LinkedList<>();
		generos1.add(Genero.ACAO);
		generos1.add(Genero.DRAMA);
		generos2.add(Genero.TERROR);
		generos2.add(Genero.ACAO);
		Usuarios sistema = new SistemaUsuariosMap();
		try {
			sistema.cadastraFilme("Venom", 0, generos1, "", "");
			assertTrue(sistema.progucaraNome("Venom"));
			sistema.cadastraFilme("Scape Room", 2021, generos2, "", "");
		}catch (ProgramaJaExistenteException e){
			fail("Não deveria ter lançado exceçao.");
		}
		sistema.listarFilmes();

	}
	@Test
	void testlistarSeries() {
		List<Genero> generos1 = new LinkedList<>();
		List<Genero> generos2 = new LinkedList<>();
		generos1.add(Genero.COMEDIA);
		generos1.add(Genero.ACAO);
		generos2.add(Genero.FICCAO_CIENTIFICA);
		generos2.add(Genero.AVENTURA);
		Usuarios sistema = new SistemaUsuariosMap();
		try {
			sistema.cadastraSerie("Upload", 2020, generos1, 9, "", "");
			assertTrue(sistema.progucaraNome("Upload"));
			sistema.cadastraSerie("Dark", 2017, generos2, 36, "", "");
		}catch (ProgramaJaExistenteException e){
			fail("Nao deveria ter lançado excecao.");
		}
		sistema.listarSeries();
	}
	

}
