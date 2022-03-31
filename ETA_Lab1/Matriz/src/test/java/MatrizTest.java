import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MatrizTest {
    private  static final String matrizSimples = "2 2 1 2 3 4 ";
    private  static final String matrizSimplesRes = "2 2 2 4 6 8";
    private  static final String matrizSimplesNeg = "2 2 -1 -2 -3 -4";
    private  static final String matriz1 = "2 2 5 6 7 8"; // 5
    @Test
    void getLin() {
        Matriz m = new Matriz(new Scanner(matrizSimples));

        int elemento = m.getLin();

        assertEquals(2,elemento,"numero de linas incorretos");
    }

    @Test
    void getColun() {
        Matriz m = new Matriz(new Scanner(matrizSimples));

        int elemento = m.getColun();

        assertEquals(2, elemento, "numero de colunas incorreto");
    }

    @Test
    void getElemento() {
        Matriz m = new Matriz(new Scanner(matrizSimples));

        double elemento = m.getElemento(1,1);

        assertEquals(1, elemento);
    }

    @Test
    void setElemento() {
        Matriz m = new Matriz(new Scanner(matrizSimples));

        m.setElemento(1,1,7);

        assertEquals(7,m.getElemento(1,1));
    }

    @Test
    void negar() {

        Matriz m = new Matriz(new Scanner(matrizSimples));
        Matriz n = new Matriz(new Scanner(matrizSimplesNeg));
        m.negar();

        assertEquals(n.getElemento(1,1), m.getElemento(1,1));
        assertEquals(n.getElemento(1,2), m.getElemento(1,2));
        assertEquals(n.getElemento(2,1), m.getElemento(2,1));
        assertEquals(n.getElemento(2,2), m.getElemento(2,2));


    }

    @Test
    void multiplicar() {
        Matriz m = new Matriz(new Scanner(matrizSimples));
        Matriz n = new Matriz(new Scanner(matrizSimples));
        Matriz o = new Matriz(new Scanner(matrizSimplesRes));

        m.multiplicar(2,n);

        assertEquals(o.getElemento(1,2),n.getElemento(1,2));
        assertEquals(o.getElemento(1,1),n.getElemento(1,1));
        assertEquals(o.getElemento(2,1),n.getElemento(2,1));
        assertEquals(o.getElemento(2,2),n.getElemento(2,2));

    }

    @Test
    void comparaIgual() {
        Matriz m = new Matriz(new Scanner(matrizSimples));
        Matriz n = new Matriz(new Scanner(matrizSimples));

        m.comparaIgual(n);

        assertTrue(m.comparaIgual(n));
    }

    @Test
    void somar() {
        Matriz m = new Matriz(new Scanner(matrizSimples));
        Matriz n = new Matriz(new Scanner(matrizSimples));
        Matriz o = new Matriz(new Scanner(matriz1));
        Matriz p = new Matriz(new Scanner(matrizSimplesRes));

        m.somar(n,o);

        assertEquals(o.getElemento(1,2),p.getElemento(1,2));
        assertEquals(o.getElemento(1,1),p.getElemento(1,1));
        assertEquals(o.getElemento(2,1),p.getElemento(2,1));
        assertEquals(o.getElemento(2,2),p.getElemento(2,2));
    }
}