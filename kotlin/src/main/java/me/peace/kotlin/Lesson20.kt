package me.peace.kotlin

fun main(){
    inlineFoo {
        println("It it in the inline")
    }


    inlineFoo(object : () -> Unit {
        override fun invoke() {
            println("It it in the inline")
        }

    }){
        println("It it out of the inline")
    }

    localReturn {
        return
    }

    //使用标签实现Lambda非局部返回
    localReturnLambda {
        return@localReturnLambda
    }

    getClassType<Int>()

}

//内联函数,inline
inline fun inlineFoo(block:() -> Unit){
    println("before inline")
    block()
    println("after inline")
}

//内联函数,noinline避免参数被内联
inline fun inlineFoo(block:() -> Unit,noinline block2: () -> Unit){
    println("before inline")
    block()
    block2()
    println("after inline")
}

//inline实现非局部返回
inline fun localReturn(returning:()->Unit){
    println("before local return")
    returning()
    println("after local return")
    return
}


fun localReturnLambda(returning: () -> Unit){
    println("before local return localReturnLambda")
    returning()
    println("after local return localReturnLambda")
    return
}

inline fun localReturnCrossInLine(crossinline returning: () -> Unit){
    println("before local return localReturnCrossInLine")
    returning()
    println("after local return localReturnCrossInLine")
    return
}

//由于运行时的类型擦除，使用reified可以实现获取参数的具体类型
inline fun <reified T> getClassType(){
    println(T::class.java)
}