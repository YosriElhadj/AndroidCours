package tn.esprit.jetpack_nascar  // Change this to your correct package name

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import tn.esprit.jetpack_nascar.ui.theme.NascarTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarLayout(
    onNavigationIconClick: () -> Unit = {},
    onInfoIconClick: () -> Unit = {}

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
           actions = {
            IconButton(onClick = onInfoIconClick) {  // Right-side info icon
                Icon(
                    painter = painterResource(id = R.drawable.ic_info),  // Replace with your info icon
                    contentDescription = "Info Icon",
                    tint = Color.White
                )
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black)  // Background color

    )

    }

@Preview(showBackground = true)
@Composable
fun PreviewToolBarLayout() {
    NascarTheme {
        ToolbarLayout()
    }
}
