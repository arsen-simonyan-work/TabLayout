import androidx.compose.runtime.mutableStateOf
import main.config.model.AppConfig

class MainViewModel {
    private val _tasks = mutableStateOf<AppConfig?>(null)
    var tasks: AppConfig? = null
        get() = _tasks.value

}