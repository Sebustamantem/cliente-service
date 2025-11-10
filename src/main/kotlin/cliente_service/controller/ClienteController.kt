package com.example.clienteservice.controller

import com.example.clienteservice.model.Cliente
import com.example.clienteservice.service.ClienteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = ["*"]) // permite llamadas desde Android
class ClienteController(private val service: ClienteService) {

    @GetMapping
    fun listar(): List<Cliente> = service.listar()

    @PostMapping
    fun crear(@RequestBody cliente: Cliente): Cliente = service.crear(cliente)
}
