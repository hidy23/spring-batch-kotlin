package kr.co.test.tech.example.queryprovider

import javax.persistence.Query
import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider
import org.springframework.util.Assert

class AdimgNewQueryProvider : AbstractJpaQueryProvider() {
    private var cityName: String? = null

    override fun createQuery(): Query {
        val manager = entityManager
        val query = manager.createQuery(
            "select adin from AdimgNew adin"
        )
        //query.setParameter("city", cityName)
        return query
    }

    @Throws(Exception::class)
    override fun afterPropertiesSet() {
      //  Assert.notNull(cityName, "City name is required")
    }

/*    fun setCityName(cityName: String?) {
        this.cityName = cityName
    }*/
}
