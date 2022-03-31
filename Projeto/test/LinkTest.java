import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkTest {

    Cidade cidade1 = new Cidade("Recife");
    Cidade cidade2 = new Cidade("Feira-Nova");
    Cidade cidade3 = new Cidade("Zebra");
    Cidade cidade4 = new Cidade("Carpina");

    int distancia = 10;
    int distancia2 = 20;

    Link link = new Link(cidade1, cidade2, distancia);
    Link link2 = new Link(cidade1, cidade4, distancia2);
    Link link3 = new Link(cidade4, cidade2, distancia2);
    Link link4 = new Link(cidade4, cidade1, distancia2);
    Link link5 = new Link(cidade3,cidade4,distancia2);

    @Test
    void getDistancia() {
        assertEquals(distancia, link.getDistancia());
    }

    @Test
    void isUsado() {
        assertTrue(link.isUsado());
    }

    @Test
    void setUsado() {
        link.setUsado(false);
        assertFalse(link.isUsado(), "Link não foi setado para false");
    }

    @Test
    void testToString() {
        String texto = link.toString();
        System.out.println(texto);
        assertEquals("Feira-Nova 10 Recife", texto, "Texto veio errado");
    }

    @Test
    void compareTo() {
        int retorno = 0;

        assertEquals(retorno, link.compareTo(link), "o link era pra ter retornado 0"); // * retorna 0 se os links tiverem as mesmas cidade1 e cidade2
        assertEquals(retorno - 1, link3.compareTo(link), "o link era pra ter retornado 1"); // * retorna negativo se this.cidade1 < l.cidade1 (Alfabetcamente)
        assertEquals(retorno - 1, link3.compareTo(link4), "o retorno foi: "); // * retorna negativo se cidade1 for igual nos dois links
        assertEquals(retorno - 1, link5.compareTo(link3), "o retorno foi: "); // * retorna negativo se this.cidade2 < l.cidade2 (Alfabetcamente)
        assertEquals(retorno + 1, link.compareTo(link2), "o link era pra ter retornado -1"); // * retorna positivo caso contrario
    }
}