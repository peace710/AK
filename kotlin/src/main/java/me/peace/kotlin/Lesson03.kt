package me.peace.kotlin


fun main(){

    val fn = fun04(10)
    fn(20)

    val fn05 = object : (Int) -> Int{
        override fun invoke(p: Int): Int {
            return p * 5
        }
    }
    fun05(fn05)
}

//函数类型

fun fun01(x:Int):Int{
    //（Int）-> Int
    // 1个int类型参数，返回值类型为Int
    return x + 5
}

fun fun02(){
    //（）-> Unit
    // 没有参数，返回值类型为Unit
}

fun fun03(x:Int,s:String):Unit{
    //(Int,String) -> Unit
    //1个int类型参数，1个String类型参数，返回值类型为Unit
}

//(Int)->((Int)->Unit)
//(Int)->Int->Unit
//1个int参数，返回值类型为(Int)->Unit
fun fun04(x:Int):((Int) -> Unit){
    return object : (Int) -> Unit{
        override fun invoke(p: Int) {
            println(x + p)
        }
    }
}

//((Int)->Int)->Unit
//1个(Int)->Int类型参数，返回值类型为Unit
fun fun05(fn:(Int)->Int):Unit{
    val r = fn(10)
    println(r)
}