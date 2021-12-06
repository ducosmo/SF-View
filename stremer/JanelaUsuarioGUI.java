package stremer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class JanelaUsuarioGUI extends JFrame{
    ImageIcon pesquisarImg = new ImageIcon("./icons/pesquisa.png");
	ImageIcon listarFilmeImg = new ImageIcon("./icons/lisfilme.png");
	ImageIcon listarSerieImg = new ImageIcon("./icons/lisserie.png");
	JButton botaoPesquisar, botaoFilme, botaoSerie;
	Usuarios stremer;
	
	
	public JanelaUsuarioGUI(Usuarios stremer){
		this.stremer = stremer;		
		setTitle("SF View");
		setSize(800, 600);
		setLocation(150, 150);
		setResizable(false);
		getContentPane().setBackground(Color.BLACK);
		botaoFilme = new JButton(listarFilmeImg);
		botaoFilme.addActionListener( new ActionListener(){
	        public void actionPerformed(ActionEvent e)
	        {
	        	JOptionPane.showMessageDialog(null, stremer.listarFilmes());
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
					JOptionPane.showMessageDialog(null ,"Programção inexistente.");
					e1.printStackTrace();
				}
	        }
	    });
		botaoPesquisar.setContentAreaFilled(false);
		botaoPesquisar.setOpaque(false);
		botaoSerie = new JButton(listarSerieImg);
		botaoSerie.addActionListener( new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e)
	        {
	        	JOptionPane.showMessageDialog(null, stremer.listarSeries());
	        }
	    });
		botaoSerie.setContentAreaFilled(false);
		botaoSerie.setOpaque(false);
		setLayout(new GridLayout(3,3));
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(botaoPesquisar);
		add(botaoFilme);
		add(botaoSerie);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
	}
//		public static void main(String [] args){
//			JFrame janela = new JanelaUsuarioGUI(janela);
//			janela.setVisible(true);
//			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		}
	
    
    
}
