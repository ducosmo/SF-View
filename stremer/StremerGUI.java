package stremer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StremerGUI extends JFrame{
    JLabel linha1, linha2;
    ImageIcon nomesImg = new ImageIcon("./icons/nomes.png");
	ImageIcon cadastrarImg = new ImageIcon("./icons/cadastrar.png");
	ImageIcon logarImg = new ImageIcon("./icons/logar.png");
	ImageIcon logoImg = new ImageIcon("./icons/logo.png");
	JButton botaoLogar, botaoCadastrar;
	private GravadorFilmes gravadorDeFilmes;
	private GravadorSerie gravadorDeSeries;
	private GravadorUsuarios gravadorDeUsuarios;
	private Usuarios stremer;
	
	public StremerGUI(){	
		stremer = new SistemaUsuariosMap();
		gravadorDeFilmes = new GravadorFilmes();
		gravadorDeSeries = new GravadorSerie();
		gravadorDeUsuarios = new GravadorUsuarios();
		try {
			Collection<Programa> seriesRecuperados = gravadorDeSeries.recuperarSeries();
			stremer.setSerie(seriesRecuperados);
			
			Collection<Login> usuariosRecuperados = gravadorDeUsuarios.recuperarUsuarios();
			stremer.setUsuario(usuariosRecuperados);
			
			Collection<Programa> filmesRecuperados = gravadorDeFilmes.recuperarFilmes();
			stremer.setFilme(filmesRecuperados);
		} catch (IOException e){
			JOptionPane.showMessageDialog(null, "Nao foi possivel recuperar os dados.");
			e.printStackTrace();
			
		}
		
		
		setTitle("SF View");
		setSize(800, 600);
		setLocation(150, 150);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		linha1 = new JLabel(logoImg, JLabel.CENTER);
		linha2 = new JLabel(nomesImg, JLabel.CENTER);
		botaoLogar = new JButton(logarImg);
		botaoLogar.addActionListener(new LogarControler(stremer, this));
		botaoLogar.setContentAreaFilled(false);
		botaoLogar.setOpaque(false);
		botaoCadastrar = new JButton( cadastrarImg);
		botaoCadastrar.addActionListener(new CadastrarControler(stremer, this));
		botaoCadastrar.setContentAreaFilled(false);
		botaoCadastrar.setOpaque(false);
		setLayout(new GridLayout(2,2));
		add(linha1);
		add(botaoLogar);
		add(linha2);
		add(botaoCadastrar);
	}
		public static void main(String [] args){
			JFrame janela = new StremerGUI();
			janela.setVisible(true);
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	
    
    
}
