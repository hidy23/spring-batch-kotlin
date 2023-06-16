package kr.co.test.tech.example

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableBatchProcessing
@SpringBootApplication
class ImageMigrationBatchApplication

fun main(args: Array<String>) {
    runApplication<ImageMigrationBatchApplication>(*args)
}
