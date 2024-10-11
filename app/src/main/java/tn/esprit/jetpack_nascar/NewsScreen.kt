package tn.esprit.jetpack_nascar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp)  // Outer padding for the whole screen
    ) {
        NewsCard(
            imageRes = R.drawable.ic_news1,
            title = stringResource(id = R.string.news1),
            description = stringResource(id = R.string.newsDesc1)
        )
        NewsCard(
            imageRes = R.drawable.ic_news2,
            title = stringResource(id = R.string.news2),
            description = stringResource(id = R.string.newsDesc2)
        )
        NewsCard(
            imageRes = R.drawable.ic_news3,
            title = stringResource(id = R.string.news3),
            description = stringResource(id = R.string.newsDesc3)
        )
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
                    style =MaterialTheme.typography.bodyMedium
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
