package me.peace.kotlin

//for循环和范围表达式
fun main(){
    //其中1..10就是范围表达式，"abc" .. "xyz"
    for (i in 1 .. 10)  println(i)

    for (j : Int in 1..10){
        println(j)
    }

    //步长为2
    for (i in 1 ..10 step 2) println(i)

    //倒序
    for (i in 10 downTo  1 step 2) println(i)

    //1至9，不包含10
    for (i in 1 until 10) println(i)

    "a" in listOf("a","b","c") //是否在其中，true

    "a" !in listOf("b","c") //是否不在其中，true

    "kot" in "abc" .."xyz"

    val array = arrayOf(10,20,30)
    for (c in array) println(c) //遍历数组

    //遍历数组，同时获取索引与值
    for ((index,value) in array.withIndex()){
        println("index = $index,value = $value")
    }
}

