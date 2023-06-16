package kr.co.gccompany.tech.stay.repository

import kr.co.test.tech.example.domain.AdimgNew
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdimgNewRepository: JpaRepository<AdimgNew, Long>{
  //  fun findAllOrderByAdino(): MutableList<AdimgNew>
}
