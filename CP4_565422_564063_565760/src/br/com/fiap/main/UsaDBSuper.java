package br.com.fiap.main;

//Nomes: Vitor Dias dos Santos RM: 565422 , Enrico Delesporte RM: 565760,  Iago Liziero RM: 564063

import br.com.fiap.bean.DragonBallSuper;

import javax.swing.*;
import java.io.IOException;

public class UsaDBSuper {

    public static void main(String[] args) {
        String aux, nome, path, tecnicas;
        int ki, transformacoes, opcao;
        double velocidade;

        DragonBallSuper dragonBallSuper;

        do {
            try {
                aux = JOptionPane.showInputDialog("Escolha:\n1.Cadastrar\n2.Consultar");
                opcao = Integer.parseInt(aux);
                path = JOptionPane.showInputDialog("Digite caminho da pasta");
                dragonBallSuper = new DragonBallSuper();
                switch (opcao) {
                    case 1:
                        nome = JOptionPane.showInputDialog("Digite o nome");
                        aux = JOptionPane.showInputDialog("Digite o ki");
                        ki = Integer.parseInt(aux);
                        tecnicas = JOptionPane.showInputDialog("Digite as técnicas do Dragon Ball");
                        aux = JOptionPane.showInputDialog("Digite as transformações do Dragon Ball");
                        transformacoes = Integer.parseInt(aux);
                        aux = JOptionPane.showInputDialog("Digite a velocidade do Dragon Ball");
                        velocidade = Double.parseDouble(aux);

                        dragonBallSuper.setNome(nome);
                        dragonBallSuper.setKi(ki);
                        dragonBallSuper.setTecnicas(tecnicas);
                        dragonBallSuper.setTransformacoes(transformacoes);
                        dragonBallSuper.setVelocidade(velocidade);

                        JOptionPane.showMessageDialog(null,dragonBallSuper.gravar(path));
                        break;
                    case 2:
                        nome = JOptionPane.showInputDialog("Digite o nome");
                        dragonBallSuper.setNome(nome);
                        dragonBallSuper = dragonBallSuper.ler(path);
                        if (dragonBallSuper == null) {
                            JOptionPane.showMessageDialog(null,
                                    "Caminho e/ou nome informado inexistente");
                        } else {
                            JOptionPane.showMessageDialog(null,"Exibindo dados:"
                                    + "\nCaminho: " + path
                                    + "\nArquivo: " + path + "/" + dragonBallSuper.getNome() + ".txt"
                                    + "\nKi: " + dragonBallSuper.getKi()
                                    + "\nTecnica: " + dragonBallSuper.getTecnicas()
                                    + "\nVelocidade:" + dragonBallSuper.getVelocidade()
                                    + "\nE-mail: " + dragonBallSuper.getTransformacoes());

                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Escolha incorreta");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro de Conversão!\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro ao Acessar Arquivo!\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de programa");
    }
}
