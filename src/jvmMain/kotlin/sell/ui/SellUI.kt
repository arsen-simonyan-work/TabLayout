package sell.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import main.model.Screen
import sell.model.ProductGroupListItem
import java.awt.Cursor

@Composable
fun CreateSellUi(vm: SellViewModel, tab: Screen) {
    vm.uuid = tab.uuid

    val maxWidth by remember { mutableStateOf(750.dp) }
    val minWidth by remember { mutableStateOf(250.dp) }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.background(Color(0, 95, 0))) {
            Card(modifier = Modifier.padding(3.dp)) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .widthIn(
                            min = 250.dp,
                            max = when {
                                vm.width in minWidth..maxWidth -> vm.width
                                vm.width > maxWidth -> maxWidth
                                vm.width < minWidth -> minWidth
                                else -> 0.dp
                            }
                        )
                        .background(MaterialTheme.colors.secondaryVariant)
                ) {
                    itemsIndexed(vm.tasks) { _, item ->
                        ProductGroupListItem(
                            item,
                            checked = item.isExpanded,
                            onChecked = { task ->
                                task.isExpanded = !task.isExpanded
//                                vm.changeTaskChecked(task, checked)
                            }) {

                            vm.tasks.forEach {
                                println(it)
                            }
                        }
                    }
                }
            }

            Spacer(
                Modifier.fillMaxHeight().width(2.dp).draggable(
                    state = rememberDraggableState { delta ->
                        vm.width += delta.dp
                    }, orientation = Orientation.Horizontal
                ).pointerHoverIcon(
                    icon = PointerIcon(Cursor(Cursor.W_RESIZE_CURSOR))
                )
            )

            Box(Modifier.fillMaxHeight().fillMaxWidth(1.0f)) {
//                AsyncImage(
//                    model = "https://avatars.githubusercontent.com/u/52348172?s=400&u=b966d448e17f4fc8b2ef3fcbc18b395abe21e1c8&v=4",
//                    contentDescription = "ddd"
//                )
                Column {
                    Card(modifier = Modifier.padding(3.dp)) {
                        Box(
                            Modifier.fillMaxWidth().fillMaxHeight(0.7f)
                                .background(androidx.compose.material3.MaterialTheme.colorScheme.secondaryContainer)
                        ) {
                            Text(text = "basket")
                        }
                    }
                    Card(modifier = Modifier.padding(3.dp)) {
                        Box(
                            Modifier.fillMaxHeight().fillMaxWidth(1.0f)
                                .background(MaterialTheme.colors.onPrimary)
                        ) {
                            Text(text = "tools")
                        }
                    }
                }
            }
        }
    }
}