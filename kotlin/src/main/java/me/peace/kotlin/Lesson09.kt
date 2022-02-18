package me.peace.kotlin

//枚举类
enum class Day1{
    MON,
    TUE,
    WEN,
    THU,
    FRI,
    SAT,
    SUN
}

enum class Day2(val day:Int){
    MON(1),
    TUE(2),
    WEN(3),
    THU(4),
    FRI(5),
    SAT(6),
    SUN(7);

    fun getDayNumber():Int{
        return day
    }
}

fun main(){
    val day = Day2.FRI
    println(day.getDayNumber())
}

