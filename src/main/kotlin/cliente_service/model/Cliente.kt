package com.example.clienteservice.model

import jakarta.persistence.*

@Entity
@Table(name = "clientes")
data class Cliente(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val nombre: String,
    val correo: String,
    val telefono: String
)
