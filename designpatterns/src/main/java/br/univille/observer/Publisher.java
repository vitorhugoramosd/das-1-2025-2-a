package br.univille.observer;
import java.util.ArrayList;

public class Publisher {
    //Lista estática(tem tamanho máximo):
    //private Subscriber[] subscribers = new Subscriber[10];

    //lista dinâmica(não tem tamanho máximo):
    private ArrayList<Subscriber> subscribers = new ArrayList<>();
    private String mainState;

        public String getMainState() {
            return mainState;
        }

        public void setMainState(String mainState) {
            this.mainState = mainState;
        }
        //inscreve um assinante na lista de assinantes
        public void subscribe(Subscriber assinante){
            subscribers.add(assinante);
        }
        //notifica todo mundo da mensagem nova
        public void notifySubscribers(){
            for (Subscriber umAssinante: subscribers) {
                umAssinante.update(mainState);
        
            }
        }


}