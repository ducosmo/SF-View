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
				String tipo = JOptionPane.showInputDialog(null,"VocÃª quer cadstrar um superUsuario?(S/N ou Sim/Nao)");
			if(tipo.equalsIgnoreCase("S")||tipo.equalsIgnoreCase("Sim")){
				String usuario = JOptionPane.showInputDialog(null, "Usuarrio: ");
				String senha = JOptionPane.showInputDialog(null, "Senha: ");
				String codigo = JOptionPane.showInputDialog(null, "Codigo: ");
				try {
					bla = true;
					stremer.cadastraSuperUsuario(usuario, senha, codigo);
				} catch (UsuarioJaExistenteException e1) {
					JOptionPane.showMessageDialog(janelaPrincipal, "Já existe um usuario com este nome.");
					bla = false;
					e1.printStackTrace();
				} catch (CodigoDesconhecidoException e1) {
					JOptionPane.showMessageDialog(janelaPrincipal, "codígo desconhecido.");
					bla = false;
					e1.printStackTrace();
				}
			}else if(tipo.equalsIgnoreCase("N")||tipo.equalsIgnoreCase("Nao")){
				String usuario = JOptionPane.showInputDialog(null, "UsuÃ¡rio: ");
				String senha = JOptionPane.showInputDialog(null, "Senha: ");
				try {
					bla = true;
					stremer.cadastraUsuario(usuario, senha);
				} catch (UsuarioJaExistenteException e1) {
					JOptionPane.showMessageDialog(janelaPrincipal, "Já existe um usuario com este nome.");
					bla = false;
					e1.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "Escrita incorreta ou opiÃ§Ã£o invalida.");
			}
		}

	}

}
