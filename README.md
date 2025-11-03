# das-1-2025-2-a

https://www.bloquinho.app/waltercoan

# Aula 04/08

## Complexidade
Todo software tende a crescer.
Para desenvolver um software de qualidade, temos de conseguir controlar essa complexidade. Mitigar ela.

entity - dados da aplicação
repository - conexão com o BD
service - Lógica de negócios
controller - html, api rest

## Não reinvente a roda!

Se já existe um framework de mercado validado e que te ajude, utilize ele. Não inicie as coisas do zero.
 
## **Abstração** 
Pegar uma coisa do mundo real o que é importante para resolver o problema e representar isso dentro do software.
é a representação simplificada de uma entidade. É retirar o que é real e representar no software.

## **Encapsulamento** 
(Ocultamento de informação) - Getters e Setters - Proteção ao atributo

## Interface
É um CONTRATO 

### Desenvolvimento em paralelo
Orientação a objetos permite que seja possível programar em paralelo.

### Débito técnico
Algo no meu software que todo mundo evita mexer pois foi "mal feito" ou feito na pressa etc.

## **Coesão** 
Uma classe deve implementar uma única funcionalidade ou unico serviço no sistema.
### Classe anêmica 
Classe que so tem o nome, os atributos e os getters e setters. 

## **Acomplamento**

O quanto um objeto ou uma classe depende de outra classe.
Quanto mais essa dependencia existe, maior é acoplamento e quanto maior o acoplamento maior a dificuldade de mexer em uma coisa sem prejudicar a outra.
Variável que é uma classe, não primitiva.

#### Exemplo
```
class A {

  private B b;
  
  public A (){
  
    b = new B();
    b.fazqq();
    
    }
```

Repare que o construtor da classe A tem dentro dele o código de B.

## **Diagrama UML**
### Flecha vazia contínua - Herança 
### Flecha vazia pontilhada - Interface
### Flecha preenchida contínua - Associação


# Aula 05/08

## SOLID
Acrônimo para 5 conceitos, criado por Robert Martin (Considerado um dos pais da Eng de Software). (Livros de código limpo, Agile). De forma resumida, é usar a orientação a objetos do jeito correto.

### **S Single Responsability Principle**
Princípio da responsabilidade única

Está ligado à **coesão**, diz que toda classe deve ter uma funcionalidade única

### **I Segregação de interfaces**
A comunicação entre 2 classes não deveria nunca ser feita diretamente através da conexão direta;
nunca uma classe a deveria chamar diretamente uma classe B;
Utilização de interfaces com objetivos diferentes para executar as funções;

MVC - Arquitetura Model View Controller
Model - Dados (que vão aparecer na tela)
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

## Design Patterns
Soluções padrões para problemas comuns na Orientação à Objetos

## Princípio da Inversão de Dependências
A classe que vai consumir alguma coisa (classe controller (API REST, endpoints)) deve depender apenas de um abastração e não da implementação concreta.
Classe concreta seria a classe de implementação de fato.
Ou seja, ela usa uma interface e não uma implementação completa. 
O controlador faz uso da interface, ele tem uma váriavel do tipo da INTERFACE.
Ai vai ter uma classe de interface e uma classe implements da interface.
Faço isso pra reduzir o acomplamento.

No Spring, ele usa o Autowired e vai procurar onde no código que é implementada a interface.

## Quando devo usar a Herança??
Tenho 3 classes. Classe Animal, Gato e Cachorro. Gato e Cachorro herdam de animal. Exemplo ideal pois NUNCA um cachorro vai virar gato e nunca um gato vai virar cachorro. AS subclasses são uma divisão do pai. Nunca uma vai assumir o papel do outro.

Outro exemplo: Classes Pessoa, Cliente e Funcionário. Nesse caso não daria pra usar herança pois usando herança você ta dizendo que o funcionário nunca seria um cliente. Se você fosse implementar isso em um banco de dados por exemplo, você teria que criar uma tabelona para o funcionário e uma tabelona para cliente, fazendo com que os dados estivessem duplicados.

Anteriormente, acreditava-se que herança era a chave para reutilizar código e criar bons projetos, com hierarquias profundas de classes. 
Com o tempo, percebeu-se que isso trazia forte acoplamento: mudanças na classe pai podiam quebrar subclasses, já que elas dependem de detalhes internos da implementação, violando o encapsulamento.

Hoje, a recomendação é: quando possível, prefira composição (uma classe usar outra como atributo) em vez de herança, pois isso tende a gerar sistemas mais flexíveis e fáceis de manter.

## **Principio do Menor conhecimento** (DEMETER)
#### O Princípio de Demeter — também chamado de Princípio do Menor Conhecimento (Principle of Least Knowledge) — defende que a implementação de um método deve invocar apenas os seguintes outros métodos:
##### de sua própria classe (caso 1)
##### de objetos passados como parâmetros (caso 2)
##### de objetos criados pelo próprio método (caso 3)
##### de atributos da classe do método (caso 4)

Ou seja, o demeter quer limitar o acesso dos teus objetos à um escopo meio que local, e se ele precisar receber coisas de fora, ele tem que receber por parâmetro, para que não utilize variáveis globais.


## **Princípio da Substituição de Liskov**

É basicamente você respeitar a assinatura do pai que você herdou, permitindo que eu troque um filho por outro e o código continuar funcionando normalmente. Por exemplo no caso das Janelinhas no java. No Swing eu tenho a classe AbstractBorder. Ai eu tenho também as classes LineBorder e TitledBorder. Essas duas classes são filhas de AbstractBorder.

## Princípio do Aberto e fechado
A classe deve estar fechada para modificações e aberta para extensões.
Você deve proteger seus objetos pra que ninguém possa quebrar ele, porém preciso ser capaz de extender, de dar novas funcionalidades sem quebrar aquilo que meu código já faz.


### Atributo static é um tipo de variável global que é carregada antes de tudo, antes do objeto existir;
É representada por uma linha sublinhada no diagrama da UML
Códigos estáticos são carregados na memória antes do objeto existir
Todo atributo estático é uma "espécie" de variável global.

## DESIGN PATTERNS ESTUDADOS 

## **Singleton**
Uma classe que vai ter uma única instância no sistema.
Como eu faço isso? - Tornando o construtor um atributo privado
Então, para cria a classe singleton..
Como atributo, cria uma variavel instance que tem como tipo o próprio Singleton
Cria o construtor privado
cria um getInstance estático
que vai ver if singleton == null, cria novo singleton
senao, retorna o singleton.

# Aula 25/08

### **Observer**
Existe um objeto principal, chamado Publisher(grupo da família), que mantém um estado (A mensagem de bom dia da tia).
Vários outros objetos, chamados Subscribers(outros integrantes do grupo da família), se inscrevem no Publisher para serem notificados quando esse estado muda.
Sempre que o Publisher sofre uma alteração, ele notifica automaticamente todos os Subscribers cadastrados, sem precisar conhecer detalhes de sua implementação.(Interface)

### **Adapter**
Como o próprio nome fala, ele faz uma adaptação de uma "tecnologia" para outra. Um exemplo, é a conversão de XML para JSON na troca de informações por API. No mundo real, o nome disso é API GATEWAY.
A Globo.com utiliza o KONG, que é um API gateway.

# Aula 26/08
 
## Características arquiteturais
São os requisitos não funcionais
(Disponibilidade, Confiabilidade, Testabilidade, Escalabilidade, Segurança, Agilidade, Tolerância a falhas, Elasticidade, Recuperabilidade, Desempenho, Implementabilidade, Capacidade de aprendizagem)

## Fun fact:
Os sistemas financeiros mais antigos, mais "clássicos" gastam bilhoes com a IBM usando o Mainframe deles.
São máquinas vendidas pela ibm desde a decada de 1960. Esses mainframes rodam em cobol e Fortran e funcionam até hoje. Essas empresas usam isso até hoje pois esses mainframes são muito confiáveis.

## Decisão arquitetural 
Quando escolho a arquitetura que vou usar e que vai atender minhas necessidades.
Por exemplo. Se escolho uma arquitetura por camadas, tenho que garantir que o sistema trabalhe por camadas corretamente.

## Principios do Design 
é um principio: Tenho que fazer a comunicação através de um sistema de mensagerias assíncrona.

Sistema de mensageria: É um serviço que coloco no meio da minha arquitetura onde uma parte do meu sistema escreve nele e uma parte do meu sistema lê dele. É um mecanismo que permite a troca de mensagens.

### Fun fact:
Para cada pessoa no mundo que fala com a alexa, ela invoca uma lambda (uma maquina virtual), processa a resposta que você quer e depois essa VM é "morta".

## Arquiteto 
Ele que vai tomar as decisoes de arquitetura.
Ele tem que tomar as decisões com base em análises.
Ele tem que estar por dentro das novas tendências.
Deve ter experiência com cenários diferentes
Manter padrão
Manter lado humano

### Orientar 
Deve orientar a equipe de acordo com sua experiência e conhecimento
A grande sacada é o arquiteto entender que, nem sempre ele sabe tudo.

### Analisar continuamente o sistema ###
Analisar constantemente o sistema para avaliar se a forma que você ta programando e as ferramentas que você está utilizando estão de fato agregando ao sistema, ou se é necessário mudar o "rumo" das coisas.

### Fun fact:
A grande maioria dos microsserviços da netflix esta no java 8.

### Assegurar que os padrões estão sendo seguidos 
Através da análise estática de códigos. - Que são ferramentas que varrem meu código procurando alguma quebra de padrão pré estabelecida.
Exemplo: Eu criar uma conexão de banco de dados na camada do controlador. Estou quebrando as camadas predefinidas. 
Dessa forma, apenas através da análise estática, consigo garantir que isso não irá ser quebrado.

### Arquiteto não se cria sem experiência 
Precisa passar por ERP, por Desweb, por Mobile etc..
Arquiteto tem que ter boa noção de administração, pois ele precisa ser capaz de falar com o PO sobre a regra de negócio. 

### Habilidades Interpessoais 
Ele precisa ser bom com as pessoas

### Precisa ser político 
Precisa saber que existem hierarquias, precisa saber convencer, influenciar e negociar.

---

## DevOps  
É uma maneira de eu entregar valor pro meu cliente mais rápido.
## Por que DevOps? 
Pois existem 2 equipes, a galera do desenvolvimento e a galera que mantem o sistema no ar.
Nesse sentido, a ideia foi colocar essas duas equipes para trabalhar colaborativamente.

Algumas empresas usam o DevOps como cultura. Ou seja, todo mundo é responsável pelo sistema.

Significa que, se o sistema cai, todo da equipe são "responsáveis" e vão trabalhar para "levantar o sistema novamente".

## Planejamento 
Gestão de projetos ágeis (kanbam, scrum etc.) geralmente com períodos curtos de trabalho e bem definidos.

## Criar
A galera faz o programa e cria as funcionalidades.

## Integração contínua
Ter um reposisório central de código confiável. Uma Main, por exemplo.

## Continuos Deployment e
## Continuous Delivery
Se um programador publicar uma versão nova do sistema, ela em pouco tempo estará disponível para todos os clientes 

## Operar
saber voltar versão se der algum problema, sem parar o sistema

---

# Aula 02/09

## Arquitetura vs Design

### Arquiteto
cria os artefatos que são passados para os desenvolvedores
Características da Arq.
Estilo
Estrutura do Componente

### Desenvolvedor
Design da Classe
Interface do usuário
Código Fonte

Para fazer a arquitetura funcionar, as barreiras físicas e virtuais que existem entre arquitetos e devs deve ser quebrada, formando uma relação bidirecional.

O arquiteto e o dev devem ter contínua colaboração.

### Escopo dos detalhes técnicos

#### DEV
Deve ter profundidade técnica

#### Arquiteto
Deve ter amplitude técnica, deve pensar como arquiteto.

Qualquer indivíduo pode particionar seu conhecimento em 3 partes. O que você sabe, o que você sabe que não sabe e o que você não sabe que não sabe.

"Como arquiteto, é mais vantajoso saber que existem 5 soluções para certo problema do que ter especialização em apenas uma".

# Aula 08/09 - Arquitetura baseada em tópicos:

Analogia do grupo da familia - Tia manda o bom dia no grupo e todos recebem
É como se fosse o observer, porém nesse caso, é de um sistema distribuido, ou seja, não estão no mesmo "programa".

publisher ---> subscribers
isso acima é um para muitos, pois ele publica uma coisa e todos vao receber
o cara que joga o evento, esse evento geralmente é um documento JSON. Todo mundo recebe esse mesmo JSON.

Protocolo AMQP - Assincrone message queue protocol
MQTT
WEB SOCKET - não é bem uma final, é um tunel

Tópico mais chique --> Stream: Permite que eu volte no tempo e reveja o que foi mandado.

No tópico normal, se eu não estiver "vivo" eu não recebo

Arquitetura em tópico traz um maior desacoplamento, pois posso adicionar um novo subscriber sem mexer em nada do Publisher. Ou seja, quando adiciono um novo sub, gero pouco impacto no processo como um todo.

Na fila, o cara que produz a mensagem, ele precisa criar uma mensagem que tenha todas as informações para que o capturar, rastrear e analisar faça seu trabalho, então a mensagem vai ficar maior. Dessa forma, as nuvens cobram por "tamanho" da mensagem.

Newsletter - Trabalha dessa forma

Dados sensíveis não podem ser enviados de forma "individual" e reservada.


Pesquisar mais sobre os tópicos abaixo.
APACHE KAFKA - Um message broker no modelo de stream - é basicamente tudo isso.
AWS Kineses - amazon
Azure event hub - microsoft
RabbitMQ
AWS SNS - cada topico pode ter 12 milhoes e meio de assinantes
azure servicebus
PubSub - Google
Redis

## Arquitetura por Fila (Queue)

Enqueue e Dequeue

Nesse caso temos o sender e o os receivers
Quando falamos de fila, temos garantia de que as mensagens são entregadas em ordem.
Além disso ela serve com o um buffer, ou seja, ela salva as mensagens e guarda elas na ordem em que elas chegaram.

Sender manda as mensagens pra fila, que vai guardar as mensagens enviadas em ordem. Ai a fila vai enviar pro receiver. (pooling).

Modelo FIFO

Se um dos receivers morrer, tudo certo, pq as mensagens estão todas sendo guardadas na fila e quando ele ressuscitar, ele vai recuperar tudo enviado quando ele estava morto.

Aqui quando eu for adicionar um novo receiver, vou precisar adicionar uma fila nova e quem da o lance vai precisar enviar para a fila nova, então tem um impacto, um custo maior quando eu adiciono um novo receiver aqui do que um novo sub na arquitetura de tópicos.

Por fila tem uma "resiliência" maior que o tópico.

Nesse caso que tenho mais acomplamento, posso produzir mensagens específicas para cada um dos receivers. Posso fazer mensagens direcionadas, dessa forma faço mensagens menores.

Imagina q voce tem um sistema em que vc tem o sistema gratuito e um pago.
QUando vc tem um cliente usa o gratuito, voce entrega as coisas mais simples e baratas.
quando voce tem um cliente q usa o pago, voce pode ter uma fila diretente, que entrega as melhoers coisas e mais caras. Dessa forma, você pode ter tratamentos diferentes.

Grandes empresas utilizam varias filas que uma se comunicam com outra

Rabbitmq

## Arquitetura FAN-OUT

Utilizo um topico e fila

sender --->topico e o topico que leva a msg pras filas e os consumidores vao nas filas buscar as informações.

## Azure
RBAC - acessar a nuvem so sendo leitor, sem mexer nos recursos da nuvem do professor

## 12 factor application
Manifesto que se você quer fazer qualquer entrevista de emprego, você tem que ler esse documento.
Criada pela Heroku, primeira empresa de nuvem a oferecer hospedagem java de graça.
Pagavam AWS pra oferecer hospedagem de graça.
Faliram..
Mas criaram o documento que explica os 12 fatores para uma applicação moderna.

2 fator - As dependencias tem que ser declaradas de alguma forma
3 fator - As configs deveriam estar armazenadas no ambiente.

# Aula 16/09

Nunca criar uma string de acesso e deixar no codigo simples assim. Pois é muito facil voce dar um commit sem querer e acabar vazando no seu git uma string de acesso à nuvem.
E não da tempo de mudar o commit. O mais correto é correr pra nuvem pra invalidar a string.

### Lambda Expression 
Criar uma função dentro do programa, algo assim

# SEGUNDO BIMESTRE
## 29/09

## Circuit Breaker
Proteger a comunicação entre sistemas.
Analogia do disjuntor
Fechado = Ta tudo certo
Aberto = deu ruim
Meio-Aberto = tenta conectar novamente e vê se vai dar certo a reconexão. Se der certo ele conta, consegui conectar.
Se der errado, ele volta pro fechado e continua esperando mais um pouco para depois tentar novamente.

SKU - Código de barras de um produto no padrao americano
Dead lettering - mensagens mortas

## 06/10

A arquitetura de software vai além da codificação e do design: ela define como o sistema deve funcionar estruturalmente e operacionalmente para atender não apenas aos requisitos do domínio (funcionais), mas também às características da arquitetura — aspectos essenciais que garantem o sucesso do sistema.

Essas características:

São considerações de design fora do domínio (ex.: desempenho, segurança, manutenibilidade).

Influenciam a estrutura do sistema, exigindo componentes ou módulos específicos.

São críticas para o sucesso da aplicação, devendo ser escolhidas com cuidado para evitar complexidade excessiva.

As características se dividem em:

Operacionais: desempenho, disponibilidade, confiabilidade, escalabilidade, continuidade, robustez.

Estruturais: modularidade, portabilidade, reutilização, manutenção, configuração, atualização.

Transversais: segurança, autenticação, acessibilidade, privacidade, usabilidade, conformidade legal.

A ISO também define atributos de qualidade como eficiência de desempenho, compatibilidade, confiabilidade, segurança, manutenibilidade e portabilidade.

Um ponto central é o trade-off — ao fortalecer uma característica (como segurança), pode-se enfraquecer outra (como desempenho). Por isso, o arquiteto busca a “arquitetura menos pior”, equilibrando prioridades conforme o contexto e evitando tentar atender a todas as características ao mesmo tempo.

Por fim, a arquitetura deve ser iterativa e adaptável, permitindo ajustes contínuos conforme o sistema evolui.

## 07/10

CQRS

Design Pattern que separa operações de leitura e gravação de um repositório de dados em modelos de dados separados.
Mais desempenho, a escalabilidade e a segurança

### Benefícios
Escalabilidade independente
Esquemas de dados otimizados
Segurança
Separação de preocupações
Consultas mais simples

## 13/10

### Retry pattern

Cancel - Cancela a operação primeiro.

Retry immediately - Tenta realizar a operação imediatamente após o erro.

Retry after delay - conhecido como (Exponential backoff) - é o fato de você utilizar uma função exponencial para tentar novamente. Ele vai aumentando o tempo da próxima tentativa de forma exponencial, porém tem um limite.

Um software pode usar mais de um estilo/padrão.

### Big ball of Mud
Sistema com grande confusão de código, mal estruturado e unido com fita adesiva e arame. São sistemas que apresentaram um crescimento desregulado, com muitos reparos rápidos (Manutenções) e repetidos. 

### Arquitetura Unitária.
Software feito pra rodar em um único computador. Exemplo: Softwares embarcados (de geladeira, microondas, frigobar etc.) Ele é feito pra rodar apenas naquele dispositivo, não tem atualizações.

### Arquitetura Desktop + Banco de dados ou Cliente/Servidor Database Centric.
Uma máquina forte rodando o banco de dados e várias máquinas conectadas à essa máquina forte com o BD.
Em outros termos, uma arquitetura Cliente/servidor ou Database Centric.
Neste caso, onde estava a lógica dos programas? Está nas máquinas mas também tem lógica no banco de dados. - Store Procedure. 
Exemplo: faço um select * from pedidos. Quando eu faço essa consulta muito pesada, a operação é feita diretamente no banco de dados.
SAP roda assim até hoje, da TOTVS também.
SE eu precisar atualizar, preciso atualizar no banco de dados e depois máquina por máquina.

### Navegador + Servidor Web
Ainda tempos Banco de dados, porém agora, existe o Web server entre o BD e as máquinas. O Web Server conecta no Banco e as outras máquinas através do navegador, conectam no web server. Eles conectam para receber o HTML. Nesse caso, pra atualizar o sistema, é só atualizar o Web Server
Em outras nomenclaturas, Cliente/servidor com Web server
Web 1.0 pra Web 2.0. Na Web 2.0, além do html, tem o Javascript (aplicação que roda no meu navegador). Ai o Servidor vira uma API REST. Dessa forma, além do HTML, trafegam dados em JSON.
Agora, já temos um sistema distribuído.

## 14/10

### Três camadas

#### CORBA (Common Object Request Broker Architecture)
O primeiro framework que permitiu duas linguagens conversarem. Linguagens diferentes trocar informação.
Você tinha um padrão ORB específico. Ai você tinha uma camada de adaptação que adaptava a mensagem de cada linguagem para uma linguagem padrão.

#### Fun fact Netflix - GRPC
Eles desde o início utilizavam a AWS. Ai no começo eles perceberem que a maior parte do que eles pagavam da AWS foi a troca de mensagem entre microsserviços. Dessa forma, eles criaram um protocolo chamado GRPC pra fazer a comunicação de microsserviços transformando a mensagem em um padrão binário para "economizar" pois é bem mais leve que um texto. A netflix meio que utilizou a mesma ideia do CORBA.

#### Troca de dados
Em JSON (via API Rest) ou em SOAP (que é XML, exemplo de NFE)

#### Monolito
Todo o código está em um único lugar. 
Para rodar você compila ele inteiro, como um software único. 
E quando ele roda, ele é um único processo. 
Pra você "mexer" no código, você tem que baixae ele inteiro.
É o jeito mais fácil de começar um sistema.

#### Fun Fact Facebook
Quando os serviços do meta cairam, o que aconteceu foi que um programador foi fazer uma atualização e acabou enviando um erro na atualização. Quando foi "baixada" essa atualização, as rotas DNS apresentaram erro e foram "excluidas" pelo próprio sistema. Se ele nao encontra caminho possível ele exclui. Ai todas as rotas foram excluidas e a unica forma pra resolver era reiniciando os roteadores. O problema era que, o "cadeado" para acessar os datacenters estava conectado na rede. Resumidamente, tiveram que "arrombar" os datacenters, por isso demorou 7 horas pra voltar. 

#### Log distribuído
SIstema pra centralizar os logs da aplicação. Exemplos: Jaeger - plataforma pra centralizar logs e tracings distribuidos Porém nele, você tem que fazer mais configurações. Existe também o Splunk, que ja vem mais "configurado", mas é mais caro. Existe por fim, o mais caro, que é o melhor de todos, que é o Datadog. É o que a Conta Azul usa. o da AWS é o Cloud Watch, Azure é o Azure Monitor e por ai vai....

#### Transações distribuídas
Quando a transação começa em um lugar em um banco de dados, e termina em outro lugar com outro banco de dados. Exemplo Uber.

#### Dapr.io
Runtime pra ajudar a criar aplicações em microsserviços totalmente distribuido e automatizado. 
Você escreve sua aplicação em qualquer linguagem que você quiser, ela só precisa fazer uma chamada em HTTP ou GRPC. Ai você diz pra ele oq voce precisa, ele vai lá e fala por você. 
Ele roda em qualquer nuvem (Azuere, AWS, Google cloud etc.) e 100% gratuito

## 20/10 e 21/10

### Arquitetura em camadas (n tier)
Padrão da maioria das aplicações
simplicidade e baixo custo
Lei de Conway - determina que as organizações que projetam sistemas estão limitadas a produzir designs que são cópias das estruturas de comunicação dessas organizações

#### Topologia
Camadas horizontais lógicas, com cada camada tendo uma função específica dentro da aplicação.
A maioria utiliza 4 camadas. As mais complexas podem ter 5 ou mais camadas.
- Camada de Apresentação
- Camada Comercial
- Camada de Persistência
- Camada de Banco de Dados


## 27/10
Arquitetura Pipelina

Tenho varios programas e vou encadeando um programa conectado no outro.

Quando você usava um input(scanner), tudo que voce digita entra no sistema.
STDIN - entrada
STDOUT - saida.
Canos(Pipes), onde eu conecto a saida de um programa com a entrada de outro.
Temos programas que tem uma interface de entrada e uma interface de saída bem claras.
Filtros - Programas
Canais - Conexões.
### Nos filtros
Produtor - Ponto de partida de um processo. As vezes chamado de origem
Transformador - Pega a entrada e transforma em outro formato
Verificador - Faz um search dentro do resultado
Consumidor - O que vou fazer com a informação no final do pipe

### Comandos importantes
ps ax- é o gerenciador de tarefas do windows. Ele mostra os programas em execuçao.
grep - exemplo de um filtro, eu falo grep (e o filtro q eu quero aplicar) 
tail - traz só o final
curl - traz o html do url q eu colocar
wget - pra baixar esse html

## 28/10
Apache Kafka - Modelo de broker, publisher e subscriber. - Serviço de Stream
Partitions - Quando mando um evento pra um topico na mesma partiçao, o kafka guarda eles na ordem em que chegaram. Ou seja, se der ruim nos consumidores, ele continua guardando as msg, ai você consegue "voltar no tempo".

