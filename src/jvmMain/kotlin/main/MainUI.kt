package main

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import sell.SellProductGroupModel
import sell.addToList
import sell.createUI

@Composable
fun createMainUI(){
    MaterialTheme {

        var tabs by remember { mutableStateOf( listOf( "Tab 1", "Tab 2", "Tab 3")) }

        var selectedTabIndex by remember { mutableStateOf(0) }

        println("MaterialTheme")

        Column {
            TabRow(selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = selectedTabIndex == index,
                        onClick = {
                            selectedTabIndex = index
                            println("tab click $index")
                        }
                    )
                }
            }
            Box(modifier = Modifier.fillMaxSize()) {
                when (selectedTabIndex) {
                    0 ->
                    {
                        Column {
                            Text("Content for Tab 1", modifier = Modifier.padding(16.dp))
                            Button(onClick = {
                                tabs = tabs.toMutableList().also { it.add(tabs.size, "Tab ${tabs.size + 1}") }.toList()
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
                                tabs = tabs.toMutableList().also { it.remove(tabs[tabs.size -1]) }.toList()
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
    }
}