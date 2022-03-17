package me.peace.kotlin.coroutine

import kotlinx.coroutines.delay
import kotlin.concurrent.thread
import kotlin.coroutines.*
import kotlin.math.absoluteValue

//可挂起的main函数
suspend fun main(){
    suspendCoroutine()
    startCoroutine()
    callLaunchCoroutine()
    callRestrictLaunchCoroutine()
    delay(2000)

    val suspendFunc = suspendFunc("10", 12)
    println(suspendFunc.absoluteValue)
}

fun suspendCoroutine(){
    //使用createCoroutine创建协程
    val continuation = suspend {
        println("in suspendCoroutine")
        5
    }.createCoroutine(object : Continuation<Int>{
        override fun resumeWith(result: Result<Int>) {
            println("createCoroutine resumeWith result = $result")
        }

        override val context: CoroutineContext
            get() = EmptyCoroutineContext
    })
    //调用resume方法启动协程
    continuation.resume(Unit)
}

fun startCoroutine(){
    //使用startCoroutine创建协程并启动
    suspend {
        println("in startCoroutine")
        6
    }.startCoroutine(object : Continuation<Int>{
        override val context: CoroutineContext
            get() = EmptyCoroutineContext

        override fun resumeWith(result: Result<Int>) {
            println("startCoroutine resumeWith result = $result")
        }

    })
}

class ProducerScope<T>{
    suspend fun produce(value:T){
        println("produce() called with: value = $value")
    }
}

//协程体的Receiver
fun <R,T> launchCoroutine(receiver: R,block:suspend R.() -> T){
    block.startCoroutine(receiver,object :Continuation<T>{
        override val context: CoroutineContext = EmptyCoroutineContext

        override fun resumeWith(result: Result<T>) {
            println("launchCoroutine resumeWith result = $result")
        }

    })
}

fun callLaunchCoroutine(){
    launchCoroutine(ProducerScope<Int>()){
        println("in launchCoroutine")
        produce(1024)
        delay(1000)
        produce(2048)
    }
}

//限制作用域内的挂起函数的注解
@RestrictsSuspension
class RestrictProducerScope<T>{
    suspend fun produce(value:T){
        println("produce() called with: value = $value")
    }
}


fun callRestrictLaunchCoroutine(){
    launchCoroutine(RestrictProducerScope<Int>()){
        println("in launchCoroutine")
        produce(4096)
        //delay(1000) //因为被限制了，不能调用外部的挂起函数
        produce(8192)
    }
}

suspend fun suspendFunc(a:String,b:Int) = suspendCoroutine<Int> {
    run {
        thread {
            it.resumeWith(Result.success(48))
        }
    }
}