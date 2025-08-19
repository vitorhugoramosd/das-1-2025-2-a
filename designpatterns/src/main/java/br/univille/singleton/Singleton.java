package br.univille.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton(){//construtor privado, ou seja, ngm pode chamar ele


    }
    public static Singleton getInstance(){//como é static, ele é carregado na memória antes da classe Singleton existir
        if(instance == null){
            instance = new Singleton();
        }
        return instance;

    }

}
