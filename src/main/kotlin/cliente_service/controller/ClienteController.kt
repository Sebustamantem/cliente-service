package com.example.clienteservice.controller

import com.example.clienteservice.model.Cliente
import com.example.clienteservice.service.ClienteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = ["*"]) // permite llamadas desde Android
class ClienteController(private val service: ClienteService) {

    // 🟢 Listar todos los clientes
    @GetMapping
    fun listar(): List<Cliente> = service.listar()

    // 🟣 Obtener un cliente por ID
    @GetMapping("/{id}")
    fun obtenerPorId(@PathVariable id: Long): Cliente? = service.obtenerPorId(id)

    // 🟢 Crear nuevo cliente
    @PostMapping
    fun crear(@RequestBody cliente: Cliente): Cliente = service.crear(cliente)

    // 🟡 Actualizar un cliente existente
    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Long, @RequestBody cliente: Cliente): Cliente? =
        service.actualizar(id, cliente)

    // 🔴 Eliminar cliente por ID
    @DeleteMapping("/{id}")
    fun eliminar(@PathVariable id: Long): String =
        if (service.eliminar(id)) "Cliente eliminado con éxito" else "Cliente no encontrado"
}
