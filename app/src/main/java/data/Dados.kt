package data_request

import data.Item
import data.Owner

data class dados(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val owner: List<Owner>,
    val total_count: Int
)