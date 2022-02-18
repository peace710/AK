package me.peace.kotlin



fun main(){
    //Lambda表达式，类型为(Int) -> Int
    {x:Int -> x + 1}

    //函数体表达式，类型为(Int) -> Unit
    fun (x : Int){println(x)}

    val x = 10

    //if-else表达式，类型为Int
    if (x > 1) x else 1

   //复合表达式，try表达式和if表达式结合使用
//    val res:Int? = try{
//        if (result.success){
//            jsonDecode(result.response)
//        }else{
//            null
//        }
//    }   catch (e:JsonDecodeException){
//        null
//    }

    //?: Elvis运算符或null合并运算符
    val maybeInt:Int? = null
    maybeInt ?:1 //maybeInt值为1
}


