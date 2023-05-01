package main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBarScope
import kotlinx.coroutines.*
import sell.SellProductGroupModel
import sell.addToList
import sell.createUI

@OptIn(ExperimentalFoundationApi::class, DelicateCoroutinesApi::class)
@Composable
fun createMainUI(){
    MaterialTheme {

        val tabs by remember { mutableStateOf( listOf( "ՎԱՃԱՌՔ 1", "ՎԱՃԱՌՔ 2", "ՄՈՒՏՔԵՐ", "ՊԱՀԵՍՏ")) }

        var selectedTabIndex by remember { mutableStateOf(0) }

        var pagerState = rememberPagerState(initialPage = tabs.size)

        Column {
            TabRow(selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = pagerState.currentPage == index,
                        onClick = {
                            selectedTabIndex = index
                        }
                    )
                }
            }

            HorizontalPager(
                pageCount = tabs.size,
                state = pagerState,
                userScrollEnabled = true,
                modifier = Modifier.weight(1f)
                    .background(Color.Black)
            ){
                content(selectedTabIndex)
            }
        }
    }
}

@Composable
fun content(selectedTabIndex: Int){
    Box(modifier = Modifier.fillMaxSize()) {
        when (selectedTabIndex) {
            0 ->
            {
                Column {
                    Text("Content for Tab 1", modifier = Modifier.padding(16.dp))
                    Button(onClick = {
                        //tabs = tabs.toMutableList().also { it.add(tabs.size, "Tab ${tabs.size + 1}") }.toList()
                    }) {
                        Text("Content for Tab 1", modifier = Modifier.padding(16.dp))
                    }
                }
            }
            1 -> {
                //addToList(SellProductGroupModel("Mirg", 77))
                //addToList(SellProductGroupModel("Banjarexen", 88))
                Column {
                    Text("Content for Tab 2", modifier = Modifier.padding(16.dp))
                    Button(onClick = {
                        //tabs = tabs.toMutableList().also { it.remove(tabs[tabs.size -1]) }.toList()
                    }) {
                        Text("Content for Tab 2", modifier = Modifier.padding(16.dp))
                    }
                }
            }
            2 -> {
                println("Tab3")
                createUI()
                LaunchedEffect(selectedTabIndex) {
                    addToList(SellProductGroupModel("Sigaret", 20))
                    addToList(SellProductGroupModel("Katnamterq", 12))
                    addToList(SellProductGroupModel("Hacabulkexen Hacabulkexen", 5))
                    addToList(SellProductGroupModel("Alkohol", 156))
                    addToList(SellProductGroupModel("Katnamterq", 999))
                    addToList(SellProductGroupModel("Pahaco", 44))
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun MenuBarScope.FileMenu() = Menu("Settings", mnemonic = 'S') {
//    Item(
//        "Reset",
//        mnemonic = 'R',
//        shortcut = KeyShortcut(Key.R, ctrl = true),
//        onClick = { println("Reset") }
//    )
//    CheckboxItem(
//        "Advanced settings",
//        mnemonic = 'A',
//        checked = isAdvancedSettings,
//        onCheckedChange = { isAdvancedSettings = !isAdvancedSettings }
//    )
//    if (isAdvancedSettings) {
//        Menu("Theme") {
//            RadioButtonItem(
//                "Light",
//                mnemonic = 'L',
//                icon = ColorCircle(Color.LightGray),
//                selected = theme == Theme.Light,
//                onClick = { theme = Theme.Light }
//            )
//            RadioButtonItem(
//                "Dark",
//                mnemonic = 'D',
//                icon = ColorCircle(Color.DarkGray),
//                selected = theme == Theme.Dark,
//                onClick = { theme = Theme.Dark }
//            )
//        }
//    }
}