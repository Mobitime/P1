package com.example.p1

import java.io.Serializable

data class Person (
    val firstName: String,
    val lastName: String,
    val address: String,
    val phone: String
): Serializable