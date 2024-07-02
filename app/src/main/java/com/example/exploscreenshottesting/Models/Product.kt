package com.example.exploscreenshottesting.Models

fun getProducts(): List<Product> {
    return listOf(
        Product("A", 12.0),
        Product("B", 17.0),
        Product("C", 22.50),
        Product("D", 23.20),
        Product("E", 12.50),
        Product("F", 36.7),
        Product("G", 7.0),
        Product("H", 112.0)
    )
}

data class Product(val name: String, val price: Double)