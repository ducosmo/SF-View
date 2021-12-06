package stremer;

import java.io.Serializable;

public class Login implements Serializable{
    private String usuario;
    private String senha;
    private Tipos tipo;
    
    public Login(String usuario, String senha, Tipos tipo){
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }
    
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getSenha(){
        return senha;
    }

    public void setTipo(Tipos tipo){
        this.tipo = tipo;
    }

    public Tipos getTipo(){
        return tipo;
    }
    
}
