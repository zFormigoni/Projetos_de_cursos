package escrever_Txt;

public class Pessoa {
 
    String nome; 
    String email;

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Pessoa [email=" + email + ", nome=" + nome + "]";
    }
    




}
