package padroescomportamentais.observer;
import java.util.Observable;
import java.util.Observer;

public class Funcionario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void contratar(String nomeFuncionarioContratado) {
        this.ultimaNotificacao = this.nome + ", novo funcionário contratado: " + nomeFuncionarioContratado;
        // System.out.println(this.ultimaNotificacao);
    }

    public void update(Observable observable, Object arg) {
        if (arg instanceof String) {
            contratar((String) arg);
        }
    }
}