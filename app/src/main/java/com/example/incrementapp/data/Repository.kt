package com.example.incrementapp.data

interface Repository {

    fun getIncrement(): Int
    fun isMax(): Boolean
    fun increment()
    fun reset()



}