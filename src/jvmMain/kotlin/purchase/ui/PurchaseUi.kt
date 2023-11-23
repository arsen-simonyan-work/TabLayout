package purchase.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import main.BaseViewModel
import main.model.Screen

@Composable
fun CreatePurchaseUi(vm: BaseViewModel, tab: Screen) {
    (vm as PurchaseViewModel).uuid = tab.uuid

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.fillMaxSize().background(androidx.compose.material3.MaterialTheme.colorScheme.inverseOnSurface).align(Alignment.Center),
                text = (vm as PurchaseViewModel).tasks[0]
            )
        }
    }
}