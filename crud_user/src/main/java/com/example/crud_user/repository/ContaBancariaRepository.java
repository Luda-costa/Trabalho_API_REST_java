package com.example.crud_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud_user.model.ContaBancaria;

public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

}