package main.domain

import io.ebean.Model
import javax.persistence.*

@Entity
@Table(name = "dic")
@MappedSuperclass
class Dic :Model(){

    @Id
    @Column(name="id")
    var idt: Int? = null

    @Column(name="from")
    var from: String? = null

    @Column(name="to")
    var to: String? = null

}