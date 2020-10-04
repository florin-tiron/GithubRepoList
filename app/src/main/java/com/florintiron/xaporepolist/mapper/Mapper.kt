package com.florintiron.xaporepolist.mapper

/**
 * Created by Florin Tiron on 04/10/2020.
 */

interface Mapper<I, O> {
    fun map(input: I): O
}

interface ListMapper<I, O> : Mapper<List<I>?, List<O>>

