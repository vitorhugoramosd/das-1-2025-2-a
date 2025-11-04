package br.univille.microkernel_kernel.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.microkernel_interface.service.DefaultService;


@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private Map<String, DefaultService> services;

    public ResponseEntity<String> index(){
        return ResponseEntity.ok().build();
    }

}
