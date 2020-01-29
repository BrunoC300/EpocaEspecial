import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


public class GerenciadoraClientesTest {

    private GerenciadoraClientes gerClientes;
    private int idCLiente01 = 1;
    private	int idCLiente02 = 2;

    @BeforeEach
    public void setUp() {

        /* ========== Montagem do cen�rio ========== */

        // criando alguns clientes
        Cliente cliente01 = new Cliente(idCLiente01, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
        Cliente cliente02 = new Cliente(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);

        // inserindo os clientes criados na lista de clientes do banco
        List<Cliente> clientesDoBanco = new ArrayList<>();
        clientesDoBanco.add(cliente01);
        clientesDoBanco.add(cliente02);

        gerClientes = new GerenciadoraClientes(clientesDoBanco);
    }

    @AfterEach
    public void tearDown() {
        gerClientes.limpa();
    }

    @Test
    public void testPesquisaCliente() {

        /* ========== Execu��o ========== */
        Cliente cliente = gerClientes.pesquisaCliente(idCLiente01);

        /* ========== Verifica��es ========== */
        assertEquals(cliente.getId(),idCLiente01);

    }
    @Test
    public void testPesquisaClienteInexistente() {

        /* ========== Execu��o ========== */
        Cliente cliente = gerClientes.pesquisaCliente(1001);

        /* ========== Verifica��es ========== */
        assertNull(cliente);

    }

    /**
     * Teste b�sico da remo��o de um cliente a partir do seu ID.
     *
     * @author Gustavo Farias
     * @date 21/01/2035
     */
    @Test
    public void testRemoveCliente() {

        /* ========== Execu��o ========== */
        boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);

        /* ========== Verifica��es ========== */
        assertTrue(clienteRemovido);
        assertEquals(gerClientes.getClientesDoBanco().size(),1);
        assertNull(gerClientes.pesquisaCliente(idCLiente02));

    }

    @Test
    public void testRemoveClienteInexistente() {


        /* ========== Execu��o ========== */
        boolean clienteRemovido = gerClientes.removeCliente(1001);

        /* ========== Verifica��es ========== */
        assertFalse(clienteRemovido);
        assertEquals(gerClientes.getClientesDoBanco().size(), 2);

    }


    @Test
    public void testClienteIdadeAceitavel() throws IdadeNaoPermitidaException {

        /* ========== Montagem do Cen�rio ========== */
        Cliente cliente = new Cliente(1, "Gustavo", 25, "guga@gmail.com", 1, true);

        /* ========== Execu��o ========== */
        boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

        /* ========== Verifica��es ========== */
        assertTrue(idadeValida);
    }

    @Test
    public void testClienteIdadeAceitavel_02() throws IdadeNaoPermitidaException {

        /* ========== Montagem do Cen�rio ========== */
        Cliente cliente = new Cliente(1, "Gustavo", 18, "guga@gmail.com", 1, true);

        /* ========== Execu��o ========== */
        boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

        /* ========== Verifica��es ========== */
        assertTrue(idadeValida);
    }

    @Test
    public void testClienteIdadeAceitavel_03() throws IdadeNaoPermitidaException {

        /* ========== Montagem do Cen�rio ========== */
        Cliente cliente = new Cliente(1, "Gustavo", 65, "guga@gmail.com", 1, true);

        /* ========== Execu��o ========== */
        boolean idadeValida = gerClientes.validaIdade(cliente.getIdade());

        /* ========== Verifica��es ========== */
        assertTrue(idadeValida);
    }

    @Test
    public void testClienteIdadeAceitavel_04() throws IdadeNaoPermitidaException {

        /* ========== Montagem do Cen�rio ========== */
        Cliente cliente = new Cliente(1, "Gustavo", 17, "guga@gmail.com", 1, true);

        /* ========== Execu��o ========== */
        try {
            gerClientes.validaIdade(cliente.getIdade());
            fail();
        } catch (Exception e) {
            /* ========== Verifica��es ========== */
            assertEquals(e.getMessage(),(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
        }
    }

    @Test
    public void testClienteIdadeAceitavel_05() throws IdadeNaoPermitidaException {

        /* ========== Montagem do Cen�rio ========== */
        Cliente cliente = new Cliente(1, "Gustavo", 66, "guga@gmail.com", 1, true);
        /* ========== Execu��o ========== */
        try {
            gerClientes.validaIdade(cliente.getIdade());
            fail();
        } catch (Exception e) {
            /* ========== Verifica��es ========== */
            assertEquals(e.getMessage(),(IdadeNaoPermitidaException.MSG_IDADE_INVALIDA));
        }
    }



}
