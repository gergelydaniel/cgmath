import org.gradle.api.Project
import java.io.FileInputStream
import java.util.*

fun Project.getLocalProperty(key: String): String? =
    rootDir.resolve("local.properties")
        .let { file ->
            if (file.exists()) {
                FileInputStream(file)
            } else {
                null
            }
        }?.use { fileInputStream ->
            val prop = Properties()
            prop.load(fileInputStream)
            prop.getProperty(key)
        } ?: System.getenv(key)
