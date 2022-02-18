package me.peace.kotlin

//sumFun01与sumFun02是等价的
fun sumFun01(x:Int) = { y:Int -> x + y}

//柯里化的方式实现
fun sumFun02(x:Int) :(Int) -> Int{
    return {y:Int -> x + y }
}

fun sumFun03(x:Int,y:Int,z:Int) = x + y + z

fun sumFun04(x:Int) = {y:Int ->{z :Int -> x + y + z}}

fun funBlock(block:() -> Unit){
    block()
}

fun funBlock(x:Int,block: (Int) -> Unit){
    block(x)
}

fun main(){
    println(sumFun01(1)(2))
    println(sumFun02(1)(2))

    println(sumFun03(1,2,3))
    println(sumFun04(1)(2)(3))


    funBlock(object : () -> Unit {
        override fun invoke() {
            println("block")
        }
    })

    //与上面的方法调用相同，采用柯里化的方式
    funBlock { println("block") }

    funBlock(10,object :(Int) -> Unit{
        override fun invoke(p1: Int) {
            println(p1)
        }
    })

    //与上面的方法调用相同，采用柯里化的方式
    funBlock(10){
        println(it)
    }

    val a = A()
    a.a()
    a.b()

}

//扩展函数
fun A.b(){
    println("b")
}

class A{
    fun a(){
        println("A")
    }
}