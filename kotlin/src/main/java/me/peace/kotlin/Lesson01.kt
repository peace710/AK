package me.peace.kotlin


fun main(){
    //变量声明
    val str:String = "I am kotlin"

    //类型推导
    val string = "I am kotlin"
    val int = 1314
    val long = 1314L
    val float = 13.14f
    val double = 13.14
    val doubleLong = 10.1e6

    //打印以下的变量类型，如println(string.javaClass.name)
    println(string.javaClass.name) //java.lang.String
    println(int.javaClass.name) //int
    println(long.javaClass.name) //long
    println(float.javaClass.name) //float
    println(double.javaClass.name) //double
    println(doubleLong.javaClass.name) //double
}

//声明函数，Unit类型，类似于java中的void关键字，1个int类型参数
fun sum(x:Int):Unit{
    val y = x + 1
}

//声明函数，int类型返回值，两个int类型参数
fun sum(x:Int,y:Int):Int {return x + y}

//上述函数的另一种实现，用等号定义一个函数，表达式函数体，与之相对的称之为代码块函数体
fun sum1(x:Int,y:Int):Int = x + y
fun sum2(x:Int,y:Int) = x + y

//在一些类似递归的复杂情况下，即使用表达式定义函数，必须显示声明类型
fun foo(n:Int):Int = if (n == 0) 1 else n * foo(n - 1)