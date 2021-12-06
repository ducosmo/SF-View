package stremer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class LogarControler implements ActionListener {
	
	private Usuarios stremer;
	private JFrame janelaPrincipal;

	
	public LogarControler(Usuarios stremer, JFrame janelaPrincipal) {
		this.stremer = stremer;
		this.janelaPrincipal = janelaPrincipal;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String usuario = JOptionPane.showInputDialog(null,"Usuario: ");
		String senha = JOptionPane.showInputDialog(null,"Senha: ");
			try {
				if(stremer.login(usuario, senha)==true) {
					janelaPrincipal.setVisible(false);
					JFrame janela = new JanelaUsuarioGUI(stremer);
					janela.setVisible(true);
					janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}else {
					janelaPrincipal.setVisible(false);
					JFrame janela = new JanelaSuperUsuarioGUI(stremer);
					janela.setVisible(true);
					janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			} catch (UsuarioInexistenteException e1) {
				JOptionPane.showMessageDialog(null,"Usuario ou senha esta incorreto.");
				e1.printStackTrace();
			
		}
		
		
		
		  
		
	}


}
