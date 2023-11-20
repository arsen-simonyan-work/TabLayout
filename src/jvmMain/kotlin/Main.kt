import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import main.createMainUI

@Preview
@Composable
fun App() {
    println("App")
    createMainUI()
}

fun main() = application {



    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
