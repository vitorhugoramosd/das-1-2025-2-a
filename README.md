# das-1-2025-2-a

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
Variável que é uma classe, não primitiva, ACOPLAMENTO
#### Exemplo
class A {

  private B b;
  
  public A (){
  
    b = new B();
    b.fazqq();
    
    }
