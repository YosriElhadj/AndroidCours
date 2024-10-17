package tn.esprit.jetpack_nascar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tn.esprit.jetpack_nascar.ui.theme.NascarTheme


@Composable
fun NewsScreen() {
    val newsTitles = listOf(
        stringResource(R.string.news1),
        stringResource(R.string.news2),
        stringResource(R.string.news3)
    )

    val newsDescriptions = listOf(
        stringResource(R.string.newsDesc1),
        stringResource(R.string.newsDesc2),
        stringResource(R.string.newsDesc3)
    )

    val newsImages = listOf(
        R.drawable.ic_news1,
        R.drawable.ic_news2,
        R.drawable.ic_news3
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)  // Adds space between items
    ) {
        items(newsTitles.size) { index ->
            NewsCard(
                imageRes = newsImages[index],
                title = newsTitles[index],
                description = newsDescriptions[index]
            )
        }
    }
}

@Composable
fun NewsCard(imageRes: Int, title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNewsScreen() {
    NascarTheme {
        NewsScreen()
    }
}
