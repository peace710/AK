package me.peace.kotlin


fun main(){
    runTest()
    letTest()
    alsoTest()
    takeIfTest()
}



fun runTest(){
    val name = "Jim"
    //run函数是任何类型T的扩展函数，在run函数中有一个单独的作用域
    run{
        val name = "Tom"
        println(name)
    }
    println(name)
}

class Teacher(val age :Int)

val teacher:Teacher? = getTeacherObject()

fun getTeacherObject():Teacher?{
    return Teacher(30)
}

fun letTest(){
    //let函数返回的是闭包的最后一行
    val ret = teacher?.let {
        println(it.age)
        it.age
    }
    println("ret = $ret")
}

var age = 0

fun alsoTest(){
    val ret = teacher?.also {
        age += it.age
        println(age)
        println(it.age)
        age
    }
    println("ret = $ret")
}

fun takeIfTest(){
    val ret = teacher?.takeIf { it.age > 20}.let {
        println("takeIf success")
    }
    println("ret = $ret")
}