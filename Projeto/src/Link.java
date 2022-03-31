/* Classe que trata da construção de links entre as cidades
 */
public class Link implements Comparable<Link> {
  public Cidade cidade1;
  public Cidade cidade2;
  public int distancia; // variavel com nome alterado para melhorar leitura do código
  public boolean usado = false;

  /* Dado que duas cidades sao recebidas
   * o método construtor cria um Link entre a primeira cidade e a segunda cidade com um tamanho específico
   * As cidades são comparadas ALFABETICAMENTE e criadas no link em ordem alfabética
   * o link é criado entre as duas cidades
   * Exemplo de comparação Alfabética entre cidades: Camaragibe < Recife, porque C vem antes de R
   */
  public Link(Cidade c1, Cidade c2, int distancia) {
    if (c1.comparaNome(c2) < 0) {
      cidade1 = c1;
      cidade2 = c2;
    } else {
      cidade1 = c2;
      cidade2 = c1;
    }
    this.distancia = distancia;
    c1.addLink(this);
    c2.addLink(this);
    usado = true;
  }

  /* retorna o tamanho de um link entre duas cidades */
  public int getDistancia() {// nome do metodo get foi alterado devido a alteração no nome do atributo tamanho para distancia
    return this.distancia; // alterado o retorno de cidade1.distancia para this.distancia
  }

  /* retorna true se o link entre duas cidades existir */
  public boolean isUsado() {
    return usado;
  }

  /* seta usado como true ou false a depender de o link ser criado ou não */
  public void setUsado(boolean u) {
    usado = false;
  }

  /* returna uma string com a descrição de um Link entre cidades.
   * exemplo Link formado por Cidade1, tamanho 3 e Cidade2, retorna "Cidade1 3 Cidade2".
   */
  public String toString() {// foi adicionado ao return o atributo this.distancia referente ao link
    return cidade1.toString() + " " + this.distancia + " " + cidade2.toString();
    // metodo escrito da forma errada ----> return cidade1.toString() + " " + cidade2.toString();
  }

  /* Compara dois links para saber o que eles tem em comum
   * returna 0 se os links tiverem as mesmas cidade1 e cidade2
   * returna negativo se this.cidade1 < l.cidade1 (Alfabetcamente)
   * retorna negativo se cidade1 é igual nos dois links
   * retorna negativo se this.cidade2 < l.cidade2 (Alfabetcamente)
   * retorna positivo caso contrário
   * Exemplo: Link1: Recife 3 Olinda / Link2: Recife 2 Camaragibe
   * Link1.compareTo(Link2) -> Resultado: retorna negativo, porque cidade1 é Recife e é igual nos dois Links
   */
  public int compareTo(Link link) {// renomeado o nome do parametro de l para link
    if (cidade1 == link.cidade1 && cidade2 == link.cidade2) {
      return 0;
    } else if ((cidade1.comparaNome(link.cidade1) < 0)) {//* retorna negativo se this.cidade1 < l.cidade1 (Alfabetcamente)
      return -1;
    } else if (cidade1 == link.cidade1) {  //* retorna negativo se cidade1 Ã© igual nos dois links
      return -1;
    } else if (cidade2.comparaNome(link.cidade2) < 0) {  //* retorna negativo se this.cidade2 < l.cidade2 (Alfabetcamente)
      return -1;
    } else
      return +1; //  retorna positivo caso contrário
  }
}
