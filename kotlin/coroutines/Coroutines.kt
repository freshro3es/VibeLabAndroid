import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

fun main() {
    val websites = listOf(
        "https://www.google.com",
        "https://www.facebook.com",
        "https://www.github.com",
        "https://www.twitter.com",
        "https://www.instagram.com"
    )

    runBlocking {
        val jobs = websites.map { url ->
            async {
                val available = checkWebsite(url)
                if (available) {
                    println("Сайт $url доступен")
                } else {
                    println("Сайт $url недоступен")
                }
            }
        }
        jobs.forEach { it.await() }
    }
}

suspend fun checkWebsite(url: String): Boolean = withContext(Dispatchers.IO) {
    try {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.requestMethod = "HEAD"
        connection.connectTimeout = 5000
        connection.readTimeout = 5000
        return@withContext connection.responseCode == HttpURLConnection.HTTP_OK
    } catch (e: Exception) {
        return@withContext false
    }
}