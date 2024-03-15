import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(1000)
        println("World")
    }

    println("Hello,")
    Thread.sleep(2000)
    println("main: Hello, блокирует поток, поэтому функция печати World отрабатывает только после Hello,")
    println("main: Now I can quit.")
}
