package tn.esprit.jetpack_nascar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define your color palette here
private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EE),  // Replace with your colorPrimary
    onPrimary = Color.White,  // colorOnPrimary
    secondary = Color(0xFF03DAC6),  // colorSecondary
    onSecondary = Color.Black,  // colorOnSecondary
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),  // Replace with your colorPrimaryDark
    onPrimary = Color.White,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.Black,
)

@Composable
fun NascarTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColors
    } else {
        LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,  // You can customize typography if needed
        content = content
    )
}
