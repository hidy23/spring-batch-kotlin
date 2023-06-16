/*
package kr.co.test.tech.example.reader

import javax.annotation.PostConstruct
import javax.sql.DataSource
import kr.co.test.tech.example.domain.AdimgNew
import kr.co.gccompany.tech.stay.repository.AdimgNewRepository
import org.springframework.batch.item.ItemReader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.data.domain.Sort


open class AdimgNewItemReader : ItemReader<AdimgNew> {
    @Autowired
    private lateinit var adimgNewRepository: AdimgNewRepository
    private lateinit var list: MutableList<AdimgNew>
    private var nextIndex: Int = 0
    private final val FETCH_SIZE = 10

    @PostConstruct
    fun postConstruct(){
        //log.info("postConstruct test")
        list = adimgNewRepository.findAll(Sort.by(Sort.Direction.ASC, "adino"))
    }

    override fun read(): AdimgNew? {
        if(nextIndex < list.size){
            return list[nextIndex++]
        }
        return null;
    }

}
*/
