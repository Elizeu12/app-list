package com.example.list_app

data class dados(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)