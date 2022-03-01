package me.peace.kotlin

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main(){
    searchItems()
    searchItemsAsync()
    searchItemsTimesUse()
}

suspend fun searchItemOne():String{
    delay(1000)
    return "item-one"
}

suspend fun searchItemTwo():String{
    delay(1000)
    return "item-two"
}

//相互两个不依赖的事件顺序执行
fun searchItems() = runBlocking {
    val start = System.currentTimeMillis()
    val searchItemOne = searchItemOne()
    val searchItemTwo = searchItemTwo()
    println("The items is $searchItemOne and $searchItemTwo,use ${System.currentTimeMillis() - start} ms")
}

//相互两个不依赖的事件并行执行
fun searchItemsAsync() = runBlocking {
    val start = System.currentTimeMillis()
    val searchItemOne = async {searchItemOne()}
    val searchItemTwo = async {searchItemTwo()}
    println("The items is ${searchItemOne.await()} and ${searchItemTwo.await()},use ${System.currentTimeMillis() - start} ms")
}

//使用measureTimeMillis计算时间
fun searchItemsTimesUse() = runBlocking {
    val time = measureTimeMillis {
        val searchItemOne = async {searchItemOne()}
        val searchItemTwo = async {searchItemTwo()}
        println("The items is ${searchItemOne.await()} and ${searchItemTwo.await()}")
    }
    println("use time = $time ms")
}