package me.peace.kotlin

import kotlinx.coroutines.*
import kotlin.random.Random


fun main(){
    globalScope()
    repeatRunBlocking()
    afterBlockDoSomething()
    coroutineJoin()
}

//在后台启动一个协程，延迟1秒
fun globalScope(){
    GlobalScope.launch {
        delay(1000L)
        println("World")
    }
    println("Hello")
    Thread.sleep(2000L)
}

//启动100个协程
fun repeatRunBlocking() = runBlocking {
    repeat(100){
        launch {
            println("repeat hello")
        }
    }
}

fun afterBlockDoSomething() {
    var value = 1000
    runBlocking {
        launch(Dispatchers.IO) {
            println(Thread.currentThread().id)
            value = 48
            delay(10 * 1000)
        }
    }
    println("${Thread.currentThread().id} ,value = $value")
}

//Join
fun coroutineJoin() = runBlocking {
    val launch = launch {
        println("Join start")
        val nextInt = Random(System.currentTimeMillis()).nextInt(10)
        println("Join $nextInt seconds")
        delay(nextInt * 1000L)
    }
    println("Join")
    launch.join()
}