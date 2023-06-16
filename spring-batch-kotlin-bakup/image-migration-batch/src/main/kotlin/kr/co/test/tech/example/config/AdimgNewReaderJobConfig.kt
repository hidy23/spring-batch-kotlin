package kr.co.test.tech.example.config

import javax.persistence.EntityManagerFactory
import kr.co.test.tech.example.domain.AdimgNew
import kr.co.test.tech.example.processor.JpaProcessor
import kr.co.test.tech.example.queryprovider.AdimgNewQueryProvider
import org.slf4j.LoggerFactory
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.database.JpaItemWriter
import org.springframework.batch.item.database.JpaPagingItemReader
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AdimgNewReaderJobConfig(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val entityManagerFactory: EntityManagerFactory
) {
    private final val ADIMG_NEW_READER_JOB = "ADIMG_NEW_READER_JOB"
    private final val ADIMG_NEW_READER_JOB_STEP = ADIMG_NEW_READER_JOB + "_STEP"
    private final val CHUNK_SIZE = 10

    private val log = LoggerFactory.getLogger("adimgNew Reader Job")

    @Bean
    fun adimgNewReaderJob(): Job {
        log.info("adimgNewReaderJob")
        return jobBuilderFactory.get(ADIMG_NEW_READER_JOB)
            .start(adimgNewReaderStep(null))
            .build()
    }

    @Bean
    @JobScope
    fun adimgNewReaderStep(@Value("#{jobParameters[requestDate]}") requestDate: String?): Step {
        log.info("adimgNewReaderStep")
        return stepBuilderFactory.get(ADIMG_NEW_READER_JOB_STEP)
            .chunk<AdimgNew, AdimgNew>(CHUNK_SIZE)
            .reader(jpaPagingItemReader())
            .processor(jpaProcessor())
            .writer(jpaWriter())
            .build()
    }


   /* fun jpaPagingItemReader(): AdimgNewItemReader {
        log.info("jpaPagingItemReader")
        return AdimgNewItemReader()
    }
*/
    @Bean
    fun jpaPagingItemReader(): JpaPagingItemReader<AdimgNew> {
        return JpaPagingItemReaderBuilder<AdimgNew>()
            .name("jpaPagingItemReader")
            .entityManagerFactory(entityManagerFactory)
            .queryProvider(AdimgNewQueryProvider())
            .pageSize(10)
            .build()
        //log.info("jpaPagingItemReader")
        /*eturn JpaPagingItemReaderBuilder<AdimgNew>()
            .name("jpaPagingItemReader")
            .entityManagerFactory(entityManagerFactory)
            .queryString("SELECT adino, ano, armno, armgno, htImgid, htAid, tmino, type, aeigno, filename, sortNum, comment, isUse, adiedit, adireg FROM AdimgNew order by adino desc")
            .pageSize(100)
            .build()r*/
    }

    @Bean
    @StepScope
    fun jpaProcessor(): ItemProcessor<AdimgNew, AdimgNew>{
        return JpaProcessor()
        /*return ItemProcessor {
            log.info("before Processing, $it")
            it
            AdimgNew(
                adino = it.adino,
                ano = it.ano,
                armno = it.armno,
                armgno = it.armgno,
                htImgid = it.htImgid,
                htAid = it.htAid,
                tmino = it.tmino,
                type = it.type,
                aeigno = it.aeigno,
                filename = it.filename,
                sortNum = it.sortNum,
                comment = it.comment,
                isUse = it.isUse,
                adiedit = it.adiedit,
                adireg = it.adireg

            ).also { adimgNew -> log.info("After Processing = $adimgNew") }
        }*/
    }

    @Bean
    fun jpaWriter(): JpaItemWriter<AdimgNew> {
        log.info("jpaWriter")
        /*return ItemWriter {
        //    adimgNewRepository.saveAll(it);
        }*/
        return JpaItemWriterBuilder<AdimgNew>()
            .entityManagerFactory(entityManagerFactory)
            .usePersist(false)
            .build()
    }
}
