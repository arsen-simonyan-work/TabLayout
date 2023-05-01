package main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier

class MyTab(title: String, content: @Composable () -> Unit) {
    private var selected by mutableStateOf(false)
    @OptIn(ExperimentalFoundationApi::class)

    @Composable
    fun Content() {
        val pagerState = rememberPagerState(0)
        Column {
            Tab(
                selected = selected,
                onClick = { selected = true },
                //text = { Text(title) }
            )
            if (selected) {
                HorizontalPager(pageCount = 3, state = pagerState, modifier = Modifier.weight(1f)) {
                    //content()
                }
            }
        }
    }
}