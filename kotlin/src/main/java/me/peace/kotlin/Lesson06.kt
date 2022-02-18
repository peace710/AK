package me.peace.kotlin

//代码块函数体在返回非Unit类型的值，必须带return
fun sumReturn1(x:Int,y:Int):Int {
    return x + y
}

//单表达式函数体，可以省略return
fun sumReturn2(x:Int,y:Int) = x + y

val methodDo1 = { x:Int,y:Int -> x + y} //methodDo1.invoke(1,2)或methodDo1(1,2)

fun methodDo2(x:Int) = {y:Int -> x + y} //methodDo2(1).invoke(2)或methodDo2(1)(2)

fun main(){
    //Kotlin的闭包不仅可以访问外部变量，还能修改其值
    var sum = 0
    listOf(1,2,3).filter { it > 0 }.forEach { sum+=it }
    println(sum)
}