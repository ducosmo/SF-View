package stremer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JanelaSuperUsuarioGUI extends JFrame {
	 ImageIcon pesquisarImg = new ImageIcon("./icons/pesquisa.png");
		ImageIcon cadFilmeImg = new ImageIcon("./icons/cadfilme.png");
		ImageIcon cadSerieImg = new ImageIcon("./icons/cadserie.png");
		ImageIcon removeImg = new ImageIcon("./icons/remove.png");
		ImageIcon salvarImg = new ImageIcon("./icons/salvar.png");
		JButton botaoPesquisar, botaoFilme, botaoSerie, botaoRemove, botaoSalvar;
		
		public GravadorFilmes gravadorDeFilmes;
		public GravadorSerie gravadorDeSeries;
		Usuarios stremer;
		
		public JanelaSuperUsuarioGUI(Usuarios stremer){
			this.stremer = stremer;	
			gravadorDeFilmes = new GravadorFilmes();
			gravadorDeSeries = new GravadorSerie();
		
			setTitle("SF View");
			setSize(800, 600);
			setLocation(150, 150);
			setResizable(false);
			getContentPane().setBackground(Color.BLACK);
			botaoFilme = new JButton(cadFilmeImg);
			botaoFilme.addActionListener( new ActionListener(){
		        public void actionPerformed(ActionEvent e)
		        {
		        	String nome = JOptionPane.showInputDialog(null,"Nome do filme: ");
		        	int ano = Integer.parseInt(JOptionPane.showInputDialog(null,"Ano do filme: "));
		        	List<Genero> generos = new ArrayList<>(stremer.selecionaGenero());
		        	String sinopse = JOptionPane.showInputDialog(null,"Escreva a sinopse: ");
		        	String autor = JOptionPane.showInputDialog(null,"Nome do autor: ");
		        	try {
						stremer.cadastraFilme(nome, ano, generos, sinopse, autor);
						JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso.");
					} catch (ProgramaJaExistenteException e1) {
						JOptionPane.showMessageDialog(null,"Programa ja cadastrado.");
						e1.printStackTrace();
					}
		    
		        }
		    });
			botaoFilme.setContentAreaFilled(false);
			botaoFilme.setOpaque(false);
			botaoPesquisar = new JButton(pesquisarImg);
			botaoPesquisar.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	try {
						JOptionPane.showMessageDialog(null ,stremer.pesquisar(JOptionPane.showInputDialog(null, "Nome a pesquisar: ")));
					} catch (ProgramacaoInexistenteException e1) {
						JOptionPane.showMessageDialog(null ,"Programacao inexistente.");
						e1.printStackTrace();
					}
		        }
		    });
			botaoPesquisar.setContentAreaFilled(false);
			botaoPesquisar.setOpaque(false);
			botaoSerie = new JButton( cadSerieImg);
			botaoSerie.addActionListener( new ActionListener()
		    {
		        public void actionPerformed(ActionEvent e)
		        {
		        	String nome = JOptionPane.showInputDialog(null,"Nome da serie: ");
		        	int ano = Integer.parseInt(JOptionPane.showInputDialog(null,"Ano da serie: "));
		        	List<Genero> generos = new ArrayList<>(stremer.selecionaGenero());
		        	String sinopse = JOptionPane.showInputDialog(null,"Escreva a sinopse: ");
		        	String autor = JOptionPane.showInputDialog(null,"Nome do autor: ");
		        	int quantEp = Integer.parseInt(JOptionPane.showInputDialog(null,"quantidade de Episodios: "));
		        	try {
						stremer.cadastraSerie(nome, ano, generos,quantEp, sinopse, autor);
					} catch (ProgramaJaExistenteException e1) {
						JOptionPane.showInputDialog(null,"Programa ja cadastrado.");
						e1.printStackTrace();
					}
		        }
		    });
			botaoSerie.setContentAreaFilled(false);
			botaoSerie.setOpaque(false);
			botaoRemove = new JButton(removeImg);
			botaoRemove.addActionListener( new ActionListener(){
		        public void actionPerformed(ActionEvent e)
		        {
		        	
		        	try {
						stremer.remove(JOptionPane.showInputDialog(null,"Nome do filme/serie: "));
						JOptionPane.showMessageDialog(null,"Apagado com suceco");
					} catch (HeadlessException | ProgramacaoInexistenteException e1) {
						JOptionPane.showMessageDialog(null,"Programa inesistente ou ja foi apagado.");
						e1.printStackTrace();
					}
		        }
		    });
			botaoRemove.setContentAreaFilled(false);
			botaoRemove.setOpaque(false);
			botaoSalvar = new JButton( salvarImg);
			botaoSalvar.addActionListener( new ActionListener(){
		        public void actionPerformed(ActionEvent e){
		        	try{
					gravadorDeFilmes.gravarFilmes(stremer.getFilme());
					JOptionPane.showMessageDialog(null, "Filmes salvos com sucesso");
					} catch (IOException e1){
					JOptionPane.showMessageDialog(null, "Problema ao salvar dados");
					e1.printStackTrace();
					}
		        	
		        	try{
		    			gravadorDeSeries.gravarSerie(stremer.getSerie());
		    			JOptionPane.showMessageDialog(null, "Series salvas com sucesso");
		    			} catch (IOException e1){
		    			JOptionPane.showMessageDialog(null, "Problema ao salvar dados");
		    			e1.printStackTrace();
		    			}
		        }
		    });
			botaoSalvar.setContentAreaFilled(false);
			botaoSalvar.setOpaque(false);
			setLayout(new GridLayout(3,3));
			add(new JLabel());
			add(new JLabel());
			add(new JLabel());
			add(botaoPesquisar);
			add(botaoFilme);
			add(botaoSerie);
			add(new JLabel());
			add(botaoRemove);
			add(botaoSalvar);
		}
}
