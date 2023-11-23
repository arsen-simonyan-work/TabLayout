package main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
fun createMainUi(modifier: Modifier = Modifier.background(MaterialTheme.colors.secondary)) {
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


@Composable
fun Content(tab: Screen) {
    val vmList = remember { mutableListOf<BaseViewModel>() }

    val newModel = check(tab, vmList) ?: vmList.apply {
        add(createViewModel(tab))
    }.last()

    Box(modifier = Modifier.fillMaxSize()) {
        when (tab.type) {
            ScreenType.SELL -> {
                CreateSellUi(newModel, tab)
            }

            ScreenType.PURCHASE -> {
                CreatePurchaseUi(newModel, tab)
            }

            ScreenType.STORAGE -> {
                CreateStorageUi(newModel, tab)
            }
        }
    }
}

fun check(tab: Screen, list: MutableList<BaseViewModel>) =
    list.firstOrNull {
        tab.uuid == it.uuid
    }


@Composable
fun createViewModel(tab: Screen) = when (tab.type) {
    ScreenType.SELL -> {
        SellViewModel()
    }

    ScreenType.PURCHASE -> {
        PurchaseViewModel()
    }

    ScreenType.STORAGE -> {
        StorageViewModel()
    }
}