package padroescomportamentais.observer;

import org.junit.jupiter.api.Test;

import padroescomportamentais.observer.Funcionario;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FuncionarioTest {

    @Test
    void deveNotificarUmFuncionario() {
        Funcionario funcionario = new Funcionario("Funcionario 1");
        funcionario.contratar("Novo Funcionário");
        assertEquals("Funcionario 1, novo funcionário contratado: Novo Funcionário", funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarFuncionarios() {
        Funcionario funcionario1 = new Funcionario("Funcionario 1");
        Funcionario funcionario2 = new Funcionario("Funcionario 2");
        funcionario1.contratar("Novo Funcionário");
        funcionario2.contratar("Outro Funcionário");
        assertEquals("Funcionario 1, novo funcionário contratado: Novo Funcionário", funcionario1.getUltimaNotificacao());
        assertEquals("Funcionario 2, novo funcionário contratado: Outro Funcionário", funcionario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarFuncionario() {
        Funcionario funcionario = new Funcionario("Funcionario 1");
        // Não há contratação
        assertEquals(null, funcionario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasFuncionario1() {
        Funcionario funcionario1 = new Funcionario("Funcionario 1");
        Funcionario funcionario2 = new Funcionario("Funcionario 2");

        // Funcionario 1 é notificado sobre a contratação
        funcionario1.contratar("Novo Funcionário");

        // Funcionario 2 não é notificado
        assertEquals(null, funcionario2.getUltimaNotificacao());
    }
}
