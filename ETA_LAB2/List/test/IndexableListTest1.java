import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexableListTest1 {

    String[] vetorEsquerdo = {"A", "B", "C"};
    String[] vetorDireito = {"D", "E", "F"};
    String[] vetorVazio1 = {};
    String[] vetorVazio2 = {};

    IndexableList<String> testListaVazia = new IndexableList(vetorVazio1, vetorVazio2);
    IndexableList<String> testLista = new IndexableList(vetorEsquerdo, vetorDireito);

    @Test
    void acrescentar() {
        testLista.acrescentar("oi");
        assertEquals(testLista.get(testLista.size()),"oi");
    }

    @Test
    void prefixar() {
        testLista.prefixar("0");
        assertEquals(testLista.get(testLista.indexOf(0)),"0","------> Erro");
    }

    @Test
    void add() {
        testLista.add(0,"A");
        testLista.add(1,"B");
        testLista.add(2,"C");
        testLista.add(3,"D");
        testLista.add(4,"E");
        testLista.add(5,"F");
    }

    @Test
    void aumentarEsquerdaArray() {
        int tamanhoVetorEsquerdo = vetorEsquerdo.length;
        int aumento = 10;
        testLista.aumentarEsquerdaArray(aumento);
        assertEquals(tamanhoVetorEsquerdo + aumento,vetorEsquerdo.length);
    }

    @Test
    void aumentar() {
        int tamanhoVetorDireito = vetorDireito.length;
        int aumento = 10;
        testLista.aumentar(aumento);
        assertEquals(tamanhoVetorDireito + aumento,vetorEsquerdo.length);
    }

    @Test
    void contem() {
        boolean contA = testLista.contem("A");
        assertTrue(contA,"Erro");
        boolean contB = testLista.contem("B");
        assertTrue(contB,"Erro");
        boolean contC = testLista.contem("C");
        assertTrue(contC,"Erro");
        boolean contD = testLista.contem("D");
        assertTrue(contD,"Erro");
        boolean contE = testLista.contem("E");
        assertTrue(contE,"Erro");
        boolean contF = testLista.contem("F");
        assertTrue(contF,"Erro");
        boolean contG = testLista.contem("G");
        assertFalse(contG,"Erro");
    }

    @Test
    void get() {
        assertEquals("A",testLista.get(0), "----> Erro");
        assertEquals("B",testLista.get(1), "----> Erro");
        assertEquals("C",testLista.get(2), "----> Erro");
        assertEquals("D",testLista.get(3), "----> Erro");
        assertEquals("E",testLista.get(4), "----> Erro");
        assertEquals("F",testLista.get(5), "----> Erro");

    }

    @Test
    void indexOf() {
        int retorno = testLista.indexOf("A");
        assertEquals(5, retorno, "----->Erro");
    }

    @Test
    void vazio() {
        boolean validacao = testLista.vazio();
        assertFalse(validacao, "-----> Erro ");
        validacao = testListaVazia.vazio();
        assertTrue(validacao, "------> Error)");
    }

    @Test
    void remover() {

        String retorno = testLista.remover(1);
        assertEquals(5, retorno.length(), "-----> Error");

    }

    @Test
    void set() {
    }

    @Test
    void size() {
    }
}