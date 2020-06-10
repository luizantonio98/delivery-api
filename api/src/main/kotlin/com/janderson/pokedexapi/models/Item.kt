package com.janderson.pokedexapi.models

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*
import org.hibernate.annotations.Parameter

@Entity
@Table(name = "items")
data class Item(
        @Column(name = "id")
        @GeneratedValue(generator = "itemSequenceGenerator")
        @GenericGenerator(name = "itemSequenceGenerator",
                strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
                parameters = [
                    Parameter(name = "sequence_name", value = "seq_items_id"),
                    Parameter(name = "initial_value", value = "1"),
                    Parameter(name = "increment_size", value = "1")]
        )
        @Id
        val id: Long,

        @Column(name = "name")
        var name: String,

        @ManyToOne
        @JoinColumn(name = "item_group_id")
        var group: ItemGroup
)
