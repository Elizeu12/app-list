package com.example.list_app.ui

import com.example.list_app.model.Item
import com.example.list_app.model.Owner

data class dados(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val owner: List<Owner>,
    val total_count: Int
)