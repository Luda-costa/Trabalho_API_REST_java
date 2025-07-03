package com.example.crud_user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_user.model.ContaBancaria;
import com.example.crud_user.service.ContaBancariaService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/contas")
public class ContaBancariaController {

    private final ContaBancariaService ContaBancariaService;

    public ContaBancariaController(ContaBancariaService ContaBancariaService) {
        this.ContaBancariaService = ContaBancariaService;
    }

    @GetMapping
    public List<ContaBancaria> buscarTodasContas() {
        return ContaBancariaService.buscarTodasContas();
    }

    @GetMapping("/{id}")
    public ContaBancaria buscarContaPorId(@PathVariable Long id) {
        return ContaBancariaService.buscarContaPorId(id);
    }

    @PostMapping
    public ContaBancaria criarConta(@RequestBody ContaBancaria conta) {
        return ContaBancariaService.criarConta(conta);
    }

    @PutMapping("/{id}/status")
    public ContaBancaria ativarDesativarConta(@PathVariable Long id ) {
        return ContaBancariaService.ativarDesativarConta(id);
    }
    @PutMapping("/{id}/depositar")
    public ContaBancaria depositar(@PathVariable Long id, @RequestBody Map<String, Double> payload) {
        return ContaBancariaService.depositar(id, payload.get("valor"));
    }
    @PutMapping("/{id}/sacar")
    public ContaBancaria sacar(@PathVariable Long id, @RequestBody Map<String, Double> payload) {
        return ContaBancariaService.sacar(id, payload.get("valor"));
    }


}