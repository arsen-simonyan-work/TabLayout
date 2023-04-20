package sell

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
                    modifier = Modifier.fillMaxHeight().fillMaxWidth(0.3f)
                        .background(Color(255, 0, 0))
                ) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        productGroup.forEachIndexed { index, sellProductGroupModel ->
                            //val state = rememberSaveable(index) { mutableStateOf(ItemState()) }
                            item(index) {
                                ProductGroupListItem(sellProductGroupModel,
                                    state = ItemState(),
                                    onClick = {  },
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clickable {
                                            //state.value.changeState()
                                        }
                                )
                            }
                        }
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ProductGroupListItem(
    group: SellProductGroupModel,
    state: ItemState,
    onClick: (() -> Unit) = {},
    modifier: Modifier? = null
){
    Card(
        modifier = Modifier.fillMaxWidth().padding(2.dp),
        onClick = onClick
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
            .background(Color(92,92,92),
            )) {
            Text(
                modifier = Modifier.padding(3.dp).background(Color(255,0,0)),
                text = group.groupName
            )
            Text(
                modifier = Modifier.padding(3.dp),
                text = "${group.productCount}  >"
            )
            if (state.expanded) {
                Button(
                    onClick = onClick,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Click me")
                }
            }
        }
    }
}

class ItemState {

    val expanded: Boolean
        get() = _expanded.value

    private val _expanded = mutableStateOf(false)

    fun changeState() {
        _expanded.value = !_expanded.value
    }
}