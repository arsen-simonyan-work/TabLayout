package main


sealed class BottomItem(val title: String, val iconId: Int, val route: String) {
    object Screen1: BottomItem("Screen 1", 0, "screen_1")
    object Screen2: BottomItem("Screen 2", 0, "screen_2")
    object Screen3: BottomItem("Screen 3", 0, "screen_3")
    object Screen4: BottomItem("Screen 4", 0, "screen_4")
}