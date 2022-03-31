import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorCidadeTest {

    @Test
    void compare() {
        int retorno;
        Cidade referencia = new Cidade("Recife");
        Cidade city2 = new Cidade("Limoeiro");
        Cidade city3 = new Cidade("Carpina");

        ComparadorCidade comparadorCidade = new ComparadorCidade();

        referencia.distancia = 10;
        city2.distancia = 5;
        city3.distancia = 20;

        retorno = comparadorCidade.compare(referencia,city3, city2);
        assertEquals(-1, retorno, "Valor retornado foi: " + retorno);

        retorno = comparadorCidade.compare(referencia,city2, city3);
        assertEquals(+1, retorno, "Valor retornado foi: " + retorno);

        retorno = comparadorCidade.compare(referencia,city2, city2);
        assertEquals(0, retorno, "Valor retornado foi: " + retorno);

    }
}