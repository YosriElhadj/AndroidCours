package tn.esprit.lastjetpack.data.models

data class News(
    val id: Int,
    val imageRes: Int,  // The resource ID for news images
    val title: String,
    val description: String
)
