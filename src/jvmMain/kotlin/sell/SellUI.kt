package sell

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private var callback: ((SellProductGroupModel)-> Unit)? = null

@Composable
fun createUI(){

    var productGroup by remember { mutableStateOf(listOf<SellProductGroupModel>()) }
    callback = { item->
        productGroup = productGroup.toMutableList().also {  it.add(item) }.toList()
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(modifier = Modifier.background(Color(0,95,0))) {
            Card(modifier = Modifier.padding(3.dp)) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.3f)
                        .background(Color(255, 0, 0))
                ) {
                    LazyColumn {
                        itemsIndexed(productGroup){index, item->
                            ProductGroupListItem(item)
                        }
//                        productGroup.forEachIndexed { index, sellProductGroupModel ->
//                            item(index) {
//                                ProductGroupListItem(sellProductGroupModel)
//                            }
//                        }
                    }
                }
            }
            Box(Modifier.fillMaxHeight().fillMaxWidth(1.0f)) {
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

fun addToList(item: SellProductGroupModel){
    callback?.invoke(item)
}

@Composable
private fun ProductGroupListItem(
    group: SellProductGroupModel
){
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .clickable { expanded = !expanded },
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
            .background(Color(156,156,156),
            )) {
            Text(
                modifier = Modifier.padding(3.dp),
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
                if(expanded)
                Icon(Icons.Default.KeyboardArrowDown, "")
                else Icon(Icons.Default.KeyboardArrowRight, "")
            }
        }
    }
}
