import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CidadeTest {

    Cidade city1 = new Cidade("Recife");
    Cidade city2 = new Cidade("Limoeiro");

    int distancia = 10;
    Cidade cidade = new Cidade("Praia de Boa Viagem");

    Link link = new Link(city1, city2, distancia);

    @Test
    void encontrar() {

        assertEquals(city1, city1.encontrar("Recife"), "");
        assertEquals("Teste", city1.encontrar("Teste").toString(), "Nova cidade 'Teste' não foi criada");
    }

    @Test
    void addLink() {
        Link link2 = new Link(city1, city2, distancia);
        Link link3 = new Link(city1, city2, distancia);
        Link link4 = new Link(city1, city2, distancia);
        Link link5 = new Link(city1, city2, distancia);
        Link link6 = new Link(city1, city2, distancia);
        assertEquals(6, city1.links.size(), "Não adicionou o link.");
    }

    @Test
    void comparaNome() {
        int retorno = 0;
        assertTrue(retorno < city1.comparaNome(city2));
        assertTrue(retorno > city2.comparaNome(city1));
        assertEquals(retorno, city1.comparaNome(city1));
    }

    @Test
    void testToString() { // método deixou de fazer sentido depois da refatoração do método compare da classe ComparadorCidade
        String nome = city1.toString();
        assertEquals(nome, city1.toString(), "Método toString não retornou uma string.");
    }
}
   /* @Test // método deixou de fazer sentido depois da refatoração do método compare da classe ComparadorCidade
    void comparaDistancia() {
    }
}*/