package sell.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductGroupListItem(
    group: SellProductGroupModel,
    checked: Boolean,
    onChecked: (SellProductGroupModel) -> Unit,
    call: () -> Unit
) {
    //val vm = remember { SellViewModel() }
    Card(
        modifier = Modifier.background(MaterialTheme.colors.secondaryVariant)
            .fillMaxWidth()
            .padding(2.dp),
        onClick = {
            onChecked.invoke(group)
            call()
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(
                    androidx.compose.material3.MaterialTheme.colorScheme.outline,
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