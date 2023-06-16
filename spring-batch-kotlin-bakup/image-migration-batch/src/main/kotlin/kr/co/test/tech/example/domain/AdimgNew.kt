package kr.co.test.tech.example.domain

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="adimg_new")
data class AdimgNew(
    @Id
    @Column(name = "adino")
    val adino: Long?= 0L,
    @Column(name = "ano")
    val ano: Long?= 0L,
    @Column(name = "armno")
    val armno: Long?= 0L,
    @Column(name = "armgno")
    val armgno: Long?= 0L,
    @Column(name = "ht_imgid")
    val htImgid: Long?= 0L,
    @Column(name = "ht_aid")
    val htAid: Long? = 0L,
    @Column(name = "tmino")
    val tmino: Long?= 0L,
    @Column(name = "type")
    val type: Int?= 0,
    @Column(name = "aeigno")
    val aeigno: Long?= 0L,
    @Column(name = "filename")
    val filename: String?= null,
    @Column(name = "sort_num")
    val sortNum: Int = 0,
    @Column(name = "comment")
    val comment: String? = null,
    @Column(name = "is_use")
    val isUse: String?= null,
    @Column(name = "adiedit")
    var adiedit: LocalDateTime?= null,
    @Column(name = "adireg")
    val adireg: LocalDateTime? = null
)
