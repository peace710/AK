package me.peace.kotlin

fun main(){
    //语法糖Lambda,下面3种是等价的
    val sum1 : (Int,Int) -> Int = { x:Int,y:Int -> x + y}

    val sum2  = {x:Int,y:Int -> x + y}

    val sum3 : (Int,Int) -> Int = { x,y -> x + y}

    val foo = { x:Int->
        val y = x - 2
        y  //相当于return y
    }

    println(foo(10))  //打印输出8

    listOf(1,2,3).forEach{ p(it) } //打印输出123

    listOf(1,2,3).forEach { it -> p(it) } //等价于上面的代码

    listOf(1,2,3).forEach { p(it).invoke() } //invoke方法
}

fun p(int :Int) = {
    print(int)
}

//Function类型
//Kotlin在JVM层设计了Function类型（Function0,Function1...Function22)来兼容Java的Lambda表达式
//每个Function类型都有一个invoke方法
interface Function1<in P1,out R> : kotlin.Function<R>{
    fun invoke(p1:P1):R
}


