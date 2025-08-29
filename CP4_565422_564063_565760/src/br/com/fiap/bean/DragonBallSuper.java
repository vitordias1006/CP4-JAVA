package br.com.fiap.bean;

//Nomes: Vitor Dias dos Santos RM: 565422 , Enrico Delesporte RM: 565760,  Iago Liziero RM: 564063

import java.io.*;

/**Classe implementada de IDBSuper para ler e gravar personagens de Dragon Ball Super
 * @author Vitor Dias dos Santos, Enrico Delesporte e Iago Liziero
 */
public class DragonBallSuper implements IDBSuper {

    private String nome;

    private int ki;

    private String tecnicas;

    private double velocidade;

    private int transformacoes;

    public DragonBallSuper() {
    }

    public DragonBallSuper(String nome, int ki, String tecnicas, double velocidade, int transformacoes) {
        this.nome = nome;
        this.ki = ki;
        this.tecnicas = tecnicas;
        this.velocidade = velocidade;
        this.transformacoes = transformacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getKi() {
        return ki;
    }

    public void setKi(int ki) {
        this.ki = ki;
    }

    public String getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(String tecnicas) {
        this.tecnicas = tecnicas;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public int getTransformacoes() {
        return transformacoes;
    }

    public void setTransformacoes(int transformacoes) {
        this.transformacoes = transformacoes;
    }

    /** Método ler que permite o usuário a ler um arquivo já gravado no sistema
     *  BufferedReader é a classe que possui o método para ler esse arquivo
     * @param path que le o caminho de onde o arquivo está
     * @return a própria classe DragonBallSuper
     * @throws IOException que é a exceção de erro ao gravar ou ler path
     */
    public DragonBallSuper ler(String path) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(path + "/" + nome + ".txt"));
        nome = br.readLine();
        ki = Integer.parseInt(br.readLine());
        tecnicas = br.readLine();
        velocidade = Double.parseDouble(br.readLine());
        transformacoes = Integer.parseInt(br.readLine());
        br.close();

        return this;
    }

    /**Método gravar permite que o usuario cadastre um novo DragonBall no sistema.
     *Com o uso da classe File é possível criar um novo arquivo e só é preciso adicionar
     * em um caminho de preferência do usuário.
     *Com o uso da classe PrintWriter consegue fazer o Output dos dados gravados no arquivo
     * @param path que grava onde vai criar o arquivo.
     * @return mensagem de arquivo criado com sucesso ou falha na criação do arquivo.
     */
    public String gravar(String path) {
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdir();
            }
            PrintWriter pw = new PrintWriter(path + "/" + nome + ".txt");
            pw.println(nome);
            pw.println(ki);
            pw.println(tecnicas);
            pw.println(velocidade);
            pw.println(transformacoes);
            pw.flush();
            pw.close();
            return "Arquivo gravado com sucesso";
        } catch (IOException e) {
            return "Falha ao gravar arquivo: " + e.getMessage();

        }
    }
}
