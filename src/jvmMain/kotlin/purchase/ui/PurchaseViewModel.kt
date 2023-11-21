package purchase.ui

import androidx.compose.runtime.toMutableStateList
import main.BaseViewModel

class PurchaseViewModel: BaseViewModel() {
    private val _tasks = getProductGroupsList().toMutableStateList()
    val tasks: List<String>
        get() = _tasks

    private fun getProductGroupsList() = mutableListOf(
        "1","2"
    )
}