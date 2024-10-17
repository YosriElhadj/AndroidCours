    package tn.esprit.jetpack_nascar

    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.shape.CircleShape

    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.text.font.FontWeight
    import tn.esprit.jetpack_nascar.ui.theme.NascarTheme
    import androidx.compose.foundation.border
    import androidx.compose.ui.draw.clip


    @Composable
    fun ProfileScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Picture
            Image(
                painter = painterResource(id = R.drawable.ic_account_circle),  // Replace with your drawable
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(150.dp)
                    .padding(top = 16.dp)
                    .border(2.dp, Color.Black, shape = CircleShape) // Adding a black border with circular shape
                    .clip(CircleShape),  // Clipping the image into a circular shape
                contentScale = ContentScale.Crop
            )

            // Full Name
            Text(
                text = stringResource(id = R.string.name),  // Name string resource
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            // Email
            Text(
                text = stringResource(id = R.string.email),  // Email string resource
                color = Color.Black,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewProfileScreen() {
        NascarTheme {
            ProfileScreen()
        }
    }
