package br.com.fiap.bean;

//Nomes: Vitor Dias dos Santos RM: 565422 , Enrico Delesporte RM: 565760,  Iago Liziero RM: 564063

import java.io.IOException;

public interface IDBSuper {

    public DragonBallSuper ler(String path) throws IOException;

    public String gravar(String path);
}
