package sell.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import main.BaseViewModel
import sell.model.ProductGroupListItem

@Composable
fun CreateSellUi(vm: BaseViewModel) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.background(Color(0, 95, 0))) {
            Card(modifier = Modifier.padding(3.dp)) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.3f)
                        .background(Color(255, 0, 0))
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