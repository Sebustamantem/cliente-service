package com.example.clienteservice.service

import com.example.clienteservice.model.Cliente
import com.example.clienteservice.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
class ClienteService(private val repo: ClienteRepository) {
    fun listar(): List<Cliente> = repo.findAll()
    fun crear(cliente: Cliente): Cliente = repo.save(cliente)
}
