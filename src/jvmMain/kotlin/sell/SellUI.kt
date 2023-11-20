package sell

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import main.MyViewModel

//private var callback: ((SellProductGroupModel)-> Unit)? = null

@Composable
fun CreateUI(vm: MyViewModel) {

    //val vm = remember { MyViewModel() }
    //val favourites = remember { mutableStateListOf<SellProductGroupModel>()}

//    callback = { item->
//        vm.productGroup = vm.productGroup.toMutableList().also {  it.add(item) }.toList()
//    }

    vm.tasks.forEach {
        println(it)
    }
    println("******************************************")

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

//fun addToList(item: SellProductGroupModel){
//    callback?.invoke(item)
//}

class SellViewModel {
    var expanded by mutableStateOf(false)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ProductGroupListItem(
    group: SellProductGroupModel,
    checked: Boolean,
    onChecked: (SellProductGroupModel) -> Unit,
    call: () -> Unit
) {
    //val vm = remember { SellViewModel() }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        onClick = {
            onChecked.invoke(group,)
            call()
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(
                    Color(156, 156, 156),
                )
        ) {
            Text(
                modifier = Modifier.padding(3.dp).weight(1f),
                text = group.groupName,
                color = Color.White,
                fontSize = 24.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.padding(3.dp),
                    text = "${group.productCount}"
                )
                if (checked)
                    Icon(Icons.Default.KeyboardArrowDown, "")
                else Icon(Icons.Default.KeyboardArrowRight, "")
            }
        }
    }
}

@Composable
fun KerberosKey() {

}
