package com.example.incrementapp.data

interface Repository {

    fun getIncrement(): Int
    fun isMax(): Boolean
    fun increment()
    fun reset()

    class Base(
        private val permanentStorage: IntCache
    ) : Repository {
        override fun getIncrement(): Int {
            TODO("Not yet implemented")
        }

        override fun isMax(): Boolean {
            TODO("Not yet implemented")
        }

        override fun increment() {
            TODO("Not yet implemented")
        }

        override fun reset() {
            TODO("Not yet implemented")
        }

    }

}