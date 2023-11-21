package main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import main.model.Screen
import main.model.ScreenType
import purchase.ui.CreatePurchaseUi
import purchase.ui.PurchaseViewModel
import sell.ui.CreateSellUi
import sell.ui.SellViewModel
import storage.ui.CreateStorageUi
import storage.ui.StorageViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun createMainUi() {
    MaterialTheme {

        val tabs by remember {
            mutableStateOf(
                listOf(
                    Screen(ScreenType.SELL, "ՎԱՃԱՌՔ 1"),
                    Screen(ScreenType.SELL, "ՎԱՃԱՌՔ 2"),
                    Screen(ScreenType.PURCHASE, "ՄՈՒՏՔԵՐ"),
                    Screen(ScreenType.STORAGE, "ՊԱՀԵՍՏ")
                )
            )
        }

        var selectedTabIndex by remember { mutableStateOf(0) }

        val pagerState = rememberPagerState(initialPage = tabs.size)

        Column {
            TabRow(selectedTabIndex) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        text = { Text(tab.title) },
                        selected = pagerState.currentPage == index,
                        onClick = {
                            selectedTabIndex = index
                        }
                    )
                }
            }

            Content(tabs[selectedTabIndex])
        }
    }
}


@Composable
fun Content(tab: Screen) {

    val vmList = remember { mutableListOf<BaseViewModel>() }

    vmList.add(createViewModel(tab))

//    val viewModelPurchase = remember { PurchaseViewModel() }
//    val viewModelStorage = remember { StorageViewModel() }
//    val viewModelSell = remember { SellViewModel() }

    Box(modifier = Modifier.fillMaxSize()) {
        when (tab.type) {
            ScreenType.SELL -> {
                CreateSellUi(vmList.last())
            }

            ScreenType.PURCHASE -> {
                CreatePurchaseUi(vmList.last())
            }

            ScreenType.STORAGE -> {
                CreateStorageUi(vmList.last())
            }
        }
    }
}

@Composable
fun createViewModel(tab: Screen) = when (tab.type) {
        ScreenType.SELL -> {
            remember { SellViewModel() }
        }

        ScreenType.PURCHASE -> {
            remember { PurchaseViewModel() }
        }

        ScreenType.STORAGE -> {
            remember { StorageViewModel() }
        }
    }