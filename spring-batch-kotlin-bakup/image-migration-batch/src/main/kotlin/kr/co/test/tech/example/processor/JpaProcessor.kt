package kr.co.test.tech.example.processor

import kr.co.test.tech.example.domain.AdimgNew
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor

class JpaProcessor : ItemProcessor<AdimgNew, AdimgNew> {
    private val log = LoggerFactory.getLogger("JpaProcessor")

    override fun process(item: AdimgNew): AdimgNew {
        log.info(item.ano.toString())
        return item
    }

}
