package tn.esprit.jetpack_nascar.ui.theme  // Change this to your correct package name

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import tn.esprit.jetpack_nascar.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarLayout(
    onNavigationIconClick: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_dehaze),  // Replace with your navigation icon
                    contentDescription = "Navigation Icon",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black)  // Background color
    )
}
