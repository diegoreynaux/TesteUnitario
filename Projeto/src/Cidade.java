import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Cidade {
  //tabela com todas as cidades por nome
  public static HashMap<String, Cidade> cidades = new HashMap<String, Cidade>();

  //nome da cidade
  public String nomeCidade; //alterado o nome da variavel visando clean code

  //nome da cidade
  // public String nomedacidade = "Varginha"; ----> Variavel comentada pois ela esta duplicado com a variavel nomecidade

  //link da cidade adjacente (cidade próxima)
  public final HashSet<Link> links = new HashSet<Link>();

  //menor distancia
  public int distancia; //variavel alterada de nome para melhor leitura do código

  /* contrutor para Cidade com um nome
   * adicionado a tabela (HashMap) de cidades
   */
  public Cidade(String nm) { //metódo alterado para correção de bug
    nomeCidade = nm;
    cidades.put(nomeCidade, this);
  }

  /* Método para encontrar uma cidade pelo nome
   * retorna a cidade se ela existir na tabela (HashMap)
   * caso contrário retorna uma nova cidade com o nome informado
   */
  public static Cidade encontrar(String nome) { //renomeado o parametro nm para nome
    Cidade cidade = cidades.get(nome);
    if (cidade == null) {
      cidade = new Cidade(nome);
      return cidade; //return null (mudou para retornar o objeto cidade em vez de null)
    }
    return cidade;
  }

  /* adiciona um link entre duas cidades na lista de links
   * Exemplo: Para criar um link entre Recife e Olinda eu preciso adicionar pelo pelos as cidades de Recife e Olinda
   */
  public void addLink(Link lnk) {
    links.add(lnk);
  }

  /* compare cidades pelos seus nomes
   * returna negativo se c1 for alfabeticamente menor,
   *  0 se os nomes forem os mesmos,
   *  e positivo se c2 for alfabeticamente menor
   * Exemplo: c1=Recife / c2=Olinda - return positivo, porque Olinda é menor que Recife, porque O vem antes de R.
   */
  public int comparaNome(Cidade city2) {//alterado o nome do parametro de p para city2
    return this.nomeCidade.compareTo(city2.nomeCidade);
  }

  /* retorna a String do nome de uma cidade. Por exemplo cidade1.ToString retorna "Recife", se o objeto da classe cidade for Recife
   */
  public String toString() {
    return nomeCidade;// foi alterada a variavel que estava sendo retornada, já que a varival nomedacidade foi cancelada
  }

  /* compara duas cidades pela sua distancia até um ponto específico
   * returna negativo se c1 for mais próxima do ponto, 0 se a distancia for a mesma, e positivo se c2 for mais próxima do ponto
   * Por exemplo:
   * - Ponto específico: Praia de Boa Viagem
   * - c1= Recife
   * - c2 = Maceió
   * - return negativo (-1), pois Recife é mais próxima do ponto de referencia: Boa Viagem.
   */
  //public int comparaDistancia(Cidade c1, Cidade c2) {
   // return c1.distancia - c2.distancia;
  }

