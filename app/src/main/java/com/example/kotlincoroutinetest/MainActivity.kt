package com.example.kotlincoroutinetest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun log(msg:String) = println("[${Thread.currentThread().name}] $msg")
    fun main() {
        netWorkRequest()
        testCoroutineJoin()
    }

    private fun netWorkRequest(){
        GlobalScope.launch {
            log("Making network request...")

            for (i in 1..3){
                delay(1000)
                println("First: $i")
            }
            log("First network request made!")
        }
        GlobalScope.launch {
            log("Making network request...")
            delay(500)

            for (i in 1..3){
                delay(1000)
                println("Second: $i")
            }
            log("Second network request made!")
        }
        Thread.sleep(4000)
        log("Done!")
    }

private fun testCoroutineJoin() = runBlocking{
    val job = GlobalScope.launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("waiting")
    job.join()
    println("done!!")
}