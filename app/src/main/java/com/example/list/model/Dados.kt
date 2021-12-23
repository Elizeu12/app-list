package com.example.list.ui

import com.example.list.model.Item
import com.example.list.model.Owner

data class dados(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val owner: List<Owner>,
    val total_count: Int
)