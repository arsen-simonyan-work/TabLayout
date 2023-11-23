package sell.ui

import androidx.compose.runtime.toMutableStateList
import main.BaseViewModel
import sell.model.SellProductGroupModel

class SellViewModel : BaseViewModel() {
    private val _tasks = getProductGroupsList().toMutableStateList()
    val tasks: List<SellProductGroupModel>
        get() = _tasks

    private fun getProductGroupsList() = mutableListOf(
        SellProductGroupModel("Sigaret", 20),
        SellProductGroupModel("Katnamterq", 12),
        SellProductGroupModel("Hacabulkexen Hacabulkexen", 5),
        SellProductGroupModel("Alkohol", 156),
        SellProductGroupModel("Katnamterq55", 999),
        SellProductGroupModel("Pahaco", 44)
    )
}