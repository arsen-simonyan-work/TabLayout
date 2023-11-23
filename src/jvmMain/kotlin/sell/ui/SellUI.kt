package sell.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.unit.dp
import main.BaseViewModel
import sell.model.ProductGroupListItem

@Composable
fun CreateSellUi(vm: BaseViewModel) {
    var width by remember { mutableStateOf(250.dp) }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.background(Color(0, 95, 0))) {
            Card(modifier = Modifier.padding(3.dp)) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .widthIn(max = width)
                        .background(Color(255, 0, 0)).pointerInput(Unit) {
                            detectDragGestures { change, _ ->
                                width = (width + change.positionChange().x.toDp()).coerceIn(
                                    250.dp,
                                    700.dp
                                )
                            }
                        }
                ) {
                    itemsIndexed((vm as SellViewModel).tasks) { _, item ->
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
            Box(Modifier.fillMaxHeight().fillMaxWidth(1.0f)) {
//                AsyncImage(
//                    model = "https://avatars.githubusercontent.com/u/52348172?s=400&u=b966d448e17f4fc8b2ef3fcbc18b395abe21e1c8&v=4",
//                    contentDescription = "ddd"
//                )
                Column {
                    Card(modifier = Modifier.padding(3.dp)) {
                        Box(
                            Modifier.fillMaxWidth().fillMaxHeight(0.7f)
                                .background(Color(0, 255, 255))
                        ) {
                            Text(text = "basket")
                        }
                    }
                    Card(modifier = Modifier.padding(3.dp)) {
                        Box(
                            Modifier.fillMaxHeight().fillMaxWidth(1.0f)
                                .background(Color(255, 255, 0))
                        ) {
                            Text(text = "tools")
                        }
                    }
                }
            }
        }
    }
}