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
            return permanentStorage.read(KEY, DEFAULT)
        }

        override fun isMax(): Boolean {
            val value = permanentStorage.read(KEY, DEFAULT)
            return value == COUNTER_MAX_VALUE
        }

        override fun increment() {
            val lastValue = permanentStorage.read(KEY, DEFAULT)
            val newValue = lastValue + 1
            permanentStorage.save(newValue,KEY)
        }

        override fun reset() {
            permanentStorage.save(INITIAL_VALUE, KEY)
        }

        companion object {
            const val KEY = "key"
            const val COUNTER_MAX_VALUE = 10
            const val DEFAULT = 0
            const val INITIAL_VALUE = 0
        }
    }
}