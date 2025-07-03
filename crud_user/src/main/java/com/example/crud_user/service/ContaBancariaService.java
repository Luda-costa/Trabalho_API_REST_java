package com.example.crud_user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud_user.model.ContaBancaria;
import com.example.crud_user.repository.ContaBancariaRepository;

@Service
public class ContaBancariaService {

    private final ContaBancariaRepository ContaBancariaRepository;

    public ContaBancariaService(ContaBancariaRepository ContaBancariaRepository) {
        this.ContaBancariaRepository = ContaBancariaRepository;
    }

    public List<ContaBancaria> buscarTodasContas() {
        return ContaBancariaRepository.findAll();
    }

    public ContaBancaria buscarContaPorId(Long id) {
        return ContaBancariaRepository.findById(id).orElseThrow();
    }

    public ContaBancaria criarConta(ContaBancaria conta) {
        return ContaBancariaRepository.save(conta);
    }

    public ContaBancaria depositar(Long id, double valor) {
        ContaBancaria conta = buscarContaPorId(id);

        if (valor <= 0) {
            throw new RuntimeException("Valor do depósito deve ser positivo!");
        }

        conta.setSaldo(conta.getSaldo() + valor);
    
        ContaBancariaRepository.save(conta);

        return conta;
    
    }
    public ContaBancaria sacar(Long id, double valor) {
        ContaBancaria conta = buscarContaPorId(id);

        if (valor <= 0) {
            throw new RuntimeException("Valor do saque deve ser positivo!");
        }

        if (valor <= conta.getSaldo()){
            conta.setSaldo(conta.getSaldo() - valor);
    
            ContaBancariaRepository.save(conta);
    
        }

        
        return conta;
    
    }

    public ContaBancaria ativarDesativarConta(Long id) {
        ContaBancaria conta = buscarContaPorId(id);

        if (conta.isAtiva() == true) {
            conta.setAtiva(false);
        }
        else{
            conta.setAtiva(true);
        }

        ContaBancariaRepository.save(conta);

        
        return conta;
    
    }

}