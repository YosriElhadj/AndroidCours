package tn.esprit.lastjetpack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tn.esprit.lastjetpack.R
import tn.esprit.lastjetpack.data.models.News

@Composable
fun NewsScreen(newsList: List<News>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(newsList) { news ->
            NewsCard(news = news)
        }
    }
}

@Composable
fun NewsCard(news: News) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
//        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Use image resources properly
            Image(
                painter = painterResource(id = news.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Use stringResource for text
            Text(text = news.title)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = news.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsScreen() {
    val dummyNewsList = listOf(
        News(
            id = 1,
            imageRes = R.drawable.ic_news1,
            title = stringResource(id = R.string.news1),
            description = stringResource(id = R.string.newsDesc1)
        ),
        News(
            id = 2,
            imageRes = R.drawable.ic_news2,
            title = stringResource(id = R.string.news2),
            description = stringResource(id = R.string.newsDesc2)
        ),
        News(
            id = 3,
            imageRes = R.drawable.ic_news3,
            title = stringResource(id = R.string.news3),
            description = stringResource(id = R.string.newsDesc3)
        )
    )
    NewsScreen(newsList = dummyNewsList)
}
