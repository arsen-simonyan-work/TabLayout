package sell

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class SellProductGroupModel(
    val groupName: String,
    val productCount: Int,
    ) {
    var isExpanded by mutableStateOf(false)
}