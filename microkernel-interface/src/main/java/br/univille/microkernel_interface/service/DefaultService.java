package br.univille.microkernel_interface.service;

import java.util.HashMap;
import org.springframework.http.HttpStatus;

public interface DefaultService {
    HttpStatus doWork(HashMap<String, String> params);//hashmap estrutura de dados - como se eu calculasse um valor unico que apresenta a informação original mas como se escondesse a informação original

}
