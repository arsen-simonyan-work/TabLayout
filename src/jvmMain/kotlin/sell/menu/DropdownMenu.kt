package sell.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.unit.dp

@Composable
fun <T> LargeDropdownMenu(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: String,
    notSetLabel: String? = null,
    items: List<T>,
    selectedIndex: Int = -1,
    onItemSelected: (index: Int, item: T) -> Unit,
    selectedItemToString: (T) -> String = { it.toString() },
    drawItem: @Composable (T, Boolean, Boolean, () -> Unit) -> Unit = { item, selected, itemEnabled, onClick ->
        LargeDropdownMenuItem(
            text = item.toString(),
            selected = selected,
            enabled = itemEnabled,
            onClick = onClick,
        )
    },
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier.height(IntrinsicSize.Min)) {
        OutlinedTextField(
            label = { Text(label) },
            value = items.getOrNull(selectedIndex)?.let { selectedItemToString(it) } ?: "",
            enabled = enabled,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                val icon = if(expanded) Icons.Filled.ArrowDropDown else Icons.Filled.ArrowDropDown
                Icon(icon, "")
            },
            onValueChange = { },
            readOnly = true,
        )

        // Transparent clickable surface on top of OutlinedTextField
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp)
                //.clip(MaterialTheme.shapes.extraSmall)
                .clickable(enabled = enabled) { expanded = true },
            color = Color.Transparent,
        ) {}
    }

    if (expanded) {
//        Dialog(
//            dispose = {
//                expanded = false
//            },
//
//        ) {
//            MaterialTheme {
//                Surface(
//                    shape = RoundedCornerShape(12.dp),
//                ) {
//                    val listState = rememberLazyListState()
//                    if (selectedIndex > -1) {
//                        LaunchedEffect("ScrollToSelected") {
//                            listState.scrollToItem(index = selectedIndex)
//                        }
//                    }
//
//                    LazyColumn(modifier = Modifier.fillMaxWidth(), state = listState) {
//                        if (notSetLabel != null) {
//                            item {
//                                LargeDropdownMenuItem(
//                                    text = notSetLabel,
//                                    selected = false,
//                                    enabled = false,
//                                    onClick = { },
//                                )
//                            }
//                        }
//                        itemsIndexed(items) { index, item ->
//                            val selectedItem = index == selectedIndex
//                            drawItem(
//                                item,
//                                selectedItem,
//                                true
//                            ) {
//                                onItemSelected(index, item)
//                                expanded = false
//                            }
//
//                            if (index < items.lastIndex) {
//                                Divider(modifier = Modifier.padding(horizontal = 16.dp))
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}


@Composable
fun LargeDropdownMenuItem(
    text: String,
    selected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val contentColor = when {
        !enabled -> MaterialTheme.colors.onSurface.copy(alpha = DefaultAlpha)
        selected -> MaterialTheme.colors.primary.copy(alpha = DefaultAlpha)
        else -> MaterialTheme.colors.onSurface.copy(alpha = DefaultAlpha)
    }

    CompositionLocalProvider(LocalContentColor provides contentColor) {
        Box(modifier = Modifier
            .clickable(enabled) { onClick() }
            .fillMaxWidth()
            .padding(16.dp)) {
            Text(
                text = text
                //,style = MaterialTheme.typography.titleSmall,
            )
        }
    }
}