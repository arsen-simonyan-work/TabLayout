package sell

import androidx.compose.runtime.Immutable

@Immutable
data class SellProductGroupModel(val groupName: String, val productCount: Int, var isExpanded: Boolean = false)