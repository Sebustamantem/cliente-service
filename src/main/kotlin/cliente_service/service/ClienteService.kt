package com.example.clienteservice.service

import com.example.clienteservice.model.Cliente
import com.example.clienteservice.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
class ClienteService(private val repository: ClienteRepository) {

    fun listar(): List<Cliente> = repository.findAll()

    fun obtenerPorId(id: Long): Cliente? = repository.findById(id).orElse(null)

    fun crear(cliente: Cliente): Cliente = repository.save(cliente)

    fun actualizar(id: Long, cliente: Cliente): Cliente? {
        val existente = repository.findById(id).orElse(null)
        return if (existente != null) {
            val actualizado = existente.copy(
                nombre = cliente.nombre,
                correo = cliente.correo,
                telefono = cliente.telefono
            )
            repository.save(actualizado)
        } else null
    }

    fun eliminar(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
