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
Utilização de interfaces com objetivos diferentes para executar as funções

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

#### Princípio da Inversão de Dependências
A classe que vai consumir alguma coisa (classe controller) deve depender apenas de um abastração e não da implementação completa.
Ou seja, ela usa uma interface e não uma implementação completa.

#### Quando devo usar a Herança??
Tenho 3 classes. Classe Animal, Gato e Cachorro. Gato e Cachorro herdam de animal. Exemplo ideal pois NUNCA um cachorro vai virar gato e nunca um gato vai virar cachorro. AS subclasses são uma divisão do pai. Nunca uma vai assumir o papel do outro.

Outro exemplo: Classes Pessoa, Cliente e Funcionário. Nesse caso não daria pra usar herança pois usando herança você ta dizendo que o funcionário nunca seria um cliente.

Anteriormente, acreditava-se que herança era a chave para reutilizar código e criar bons projetos, com hierarquias profundas de classes. 
Com o tempo, percebeu-se que isso trazia forte acoplamento: mudanças na classe pai podiam quebrar subclasses, já que elas dependem de detalhes internos da implementação, violando o encapsulamento.

Hoje, a recomendação é: quando possível, prefira composição (uma classe usar outra como atributo) em vez de herança, pois isso tende a gerar sistemas mais flexíveis e fáceis de manter.

### Principio do Menor conhecimento (DEMETER)
##### O Princípio de Demeter — também chamado de Princípio do Menor Conhecimento (Principle of Least Knowledge) — defende que a implementação de um método deve invocar apenas os seguintes outros métodos:
###### de sua própria classe (caso 1)
###### de objetos passados como parâmetros (caso 2)
###### de objetos criados pelo próprio método (caso 3)
###### de atributos da classe do método (caso 4)

### Princípio do Aberto e fechado
A classe deve estar fechada para modificações e aberta para extensões.
Você deve proteger seus objetos pra que ninguém possa quebrar ele, porém preciso ser capaz de extender, de dar novas funcionalidades sem quebrar aquilo que meu código já faz.

