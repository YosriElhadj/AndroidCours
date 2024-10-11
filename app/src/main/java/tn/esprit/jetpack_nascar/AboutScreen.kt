package tn.esprit.jetpack_nascar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import tn.esprit.jetpack_nascar.ui.theme.NascarTheme
import tn.esprit.jetpack_nascar.R



@Composable
fun AboutScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image equivalent for the ImageView
        Image(
            painter = painterResource(id = R.drawable.ic_logo),  // Replace with your actual drawable
            contentDescription = "Nascar Logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop
        )

        // Text equivalent for the TextView
        Text(
            text = stringResource(id = R.string.about),  // Using the string resource
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}

@Preview
@Composable
fun PreviewAboutScreen() {
    NascarTheme {
        AboutScreen()
    }
}
