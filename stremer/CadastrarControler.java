package stremer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CadastrarControler implements ActionListener {
	
	private Usuarios stremer;
	private JFrame janelaPrincipal;

	public CadastrarControler(Usuarios stremer, JFrame janelaPrincipal) {
		this.stremer = stremer;
		this.janelaPrincipal = janelaPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean bla = false;
		while(bla==false){
				String tipo = JOptionPane.showInputDialog(null,"Você quer cadstrar um superUsuario?(S/N ou Sim/Nao)");
			if(tipo.equalsIgnoreCase("S")||tipo.equalsIgnoreCase("Sim")){
				String usuario = JOptionPane.showInputDialog(null, "Usuarrio: ");
				String senha = JOptionPane.showInputDialog(null, "Senha: ");
				String codigo = JOptionPane.showInputDialog(null, "Codigo: ");
				try {
					bla = true;
					stremer.cadastraSuperUsuario(usuario, senha, codigo);
				} catch (UsuarioJaExistenteException e1) {
					JOptionPane.showMessageDialog(janelaPrincipal, "J� existe um usuario com este nome.");
					bla = false;
					e1.printStackTrace();
				} catch (CodigoDesconhecidoException e1) {
					JOptionPane.showMessageDialog(janelaPrincipal, "cod�go desconhecido.");
					bla = false;
					e1.printStackTrace();
				}
			}else if(tipo.equalsIgnoreCase("N")||tipo.equalsIgnoreCase("Nao")){
				String usuario = JOptionPane.showInputDialog(null, "Usuário: ");
				String senha = JOptionPane.showInputDialog(null, "Senha: ");
				try {
					bla = true;
					stremer.cadastraUsuario(usuario, senha);
				} catch (UsuarioJaExistenteException e1) {
					JOptionPane.showMessageDialog(janelaPrincipal, "J� existe um usuario com este nome.");
					bla = false;
					e1.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "Escrita incorreta ou opição invalida.");
			}
		}

	}

}
