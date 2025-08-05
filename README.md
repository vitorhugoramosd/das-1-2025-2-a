# das-1-2025-2-a

https://www.bloquinho.app/waltercoan

# Aula 04/08

## **Abstração** 
é a representação simplificada de uma entidade. É retirar o que é real e representar no software.

## **Encapsulamento** 
(Ocultamento de informação) - Getters e Setters - Proteção ao atributo

## **Coesão** 
Uma classe deve implementar uma única funcionalidade ou unico serviço no sistema.
### Classe anêmica 
Classe que so tem o nome, os atributos e os getters e setters. 

## **Diagrama UML**
### Flecha vazia contínua - Herança
### Flecha vazia pontilhada - Interface
### Flecha preenchida contínua - Associação
Variável que é uma classe, não primitiva, ACOPLAMENTO - O quanto uma classe depende de outra classe
#### Exemplo
```
class A {

  private B b;
  
  public A (){
  
    b = new B();
    b.fazqq();
    
    }
```

# Aula 05/08

## SOLID
Acrônimo para 5 conceitos, criado por Robert Martin (Considerado um dos pais da Eng de Software). (Livros de código limpo, Agile). De forma resumida, é usar a orientação a objetos do jeito correto.
### **S Single Responsability Principle**
Está ligado à **coesão**, diz que toda classe deve ter uma funcionalidade única
### **I Segregação de interfaces**
Utilização de interfaces para executar as funções

MVC - 
Model - Dados
View - HTML
C - Controlador

#### Swing - criar Janela em Java
```

package br.univille;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Janelinha extends JFrame{

    private JButton botaozinho;
    private Controlador controlador;

    public Janelinha() {
        setTitle("Eu nao acredito");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        botaozinho = new JButton("ME CLICA");
        controlador = new Controlador();
        botaozinho.addActionListener(controlador);
        
        add(botaozinho);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Janelinha();
    }
}


```

#### Design Patterns
Soluções padrões para problemas comuns na Orientação à Objetos
