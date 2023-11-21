package purchase.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import main.BaseViewModel

@Composable
fun CreatePurchaseUi(vm: BaseViewModel) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(Modifier.fillMaxSize()) {
            Text(modifier = Modifier.fillMaxSize().background(Color.Yellow).align(Alignment.Center), text = (vm as PurchaseViewModel).tasks[0])
        }
    }
}