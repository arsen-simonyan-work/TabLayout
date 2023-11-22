package storage.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import main.BaseViewModel
import main.model.Screen

@Composable
fun CreateStorageUi(vm: BaseViewModel, tab: Screen) {
    (vm as StorageViewModel).uuid = tab.uuid

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(Modifier.fillMaxSize()) {
            Text(modifier = Modifier.fillMaxSize(),  text = (vm as StorageViewModel).tasks[1])
        }
    }
}