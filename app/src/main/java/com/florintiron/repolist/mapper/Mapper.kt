package com.florintiron.repolist.mapper

/**
 * Created by Florin Tiron on 04/10/2020.
 */

interface Mapper<I, O> {
    fun map(input: I): O
    fun mapList(input: List<I>?): List<O>
}
