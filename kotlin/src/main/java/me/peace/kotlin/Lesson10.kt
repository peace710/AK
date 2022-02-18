package me.peace.kotlin

//when表达式
fun main(){
    val a = 10
    when (a){
        1 -> 1
        2 -> 2
        else -> 3
    }

    when{
        a == 1 -> 5
        a > 1 -> 6
        else -> 7
    }
}

fun whenMethod(fail:Boolean,score:Int) = when{
    score == 60 -> 60
    score in 61..79 -> 80
    fail -> 50
    else -> 100
}