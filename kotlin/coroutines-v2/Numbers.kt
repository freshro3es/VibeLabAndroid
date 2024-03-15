import kotlinx.coroutines.*

suspend fun getNumber1(): Int {
    delay(1000)
    return (1..100).random()
}

suspend fun getNumber2(): Int {
    delay(1500)
    return (1..100).random()
}

fun main() {
    runBlocking {

        // Фоновая корутина
        val backgroundJob = launch {
            repeat(15) {
                println("I'm sleeping $it ...")
                delay(1000)
            }
        }

        val start = System.currentTimeMillis()

        val number1 = getNumber1()
        val number2 = getNumber2()

        val sum = number1 + number2
        val end = System.currentTimeMillis()
        backgroundJob.cancel()
        println("main: I'm tired of waiting! I'm running finally")
        println("Sequential sum: $sum")
        println("Sequential time: ${end - start} ms")


    }

    runBlocking {

        // Фоновая корутина
        val backgroundJob = launch {
            repeat(15) {
                println("I'm sleeping $it ...")
                delay(1000)
            }
        }

        val start = System.currentTimeMillis()

        val deferred1 = async { getNumber1() }
        val deferred2 = async { getNumber2() }

        val sum = deferred1.await() + deferred2.await()
        val end = System.currentTimeMillis()

        backgroundJob.cancel()
        println("main: I'm tired of waiting! I'm running finally")
        println("Async sum: $sum")
        println("Async time: ${end - start} ms")

        println("main: Now I can quit.")
    }
}