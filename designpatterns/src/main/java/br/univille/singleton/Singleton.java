package br.univille.singleton;

public class Singleton {//enderchest
    private static Singleton instance;
    private String segredo;

    public String getSegredo() {
        return segredo;
    }
    public void setSegredo(String segredo) {
        this.segredo = segredo;
    }
    private Singleton(){//construtor privado, ou seja, ngm pode chamar ele
        System.out.println("Construtor Singleton");


    }
    public static Singleton getInstance(){
        //como é static, ele é carregado na memória antes da classe Singleton existir, então ele vai de cara ver se a instancia já existe, se
        //não existir, ele cria uma nova e depois retorna a instancia. Depois de criar, ninguem mais pode criar outra instancia.
        System.out.println("getInstance");
        if(instance == null){
            System.out.println("new Singleton");
            instance = new Singleton();
        }
        return instance;

    }

}
