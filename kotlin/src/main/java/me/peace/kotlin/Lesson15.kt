package me.peace.kotlin

//使用by lazy延迟初始化
val laziness:String by lazy{
    println("I will have a value")
    "I am a lazy-initialized string"
}

interface CanFly{
    fun fly()
}

interface CanEat{
    fun eat()
}

open class Flyer15:CanFly{
    override fun fly(){
        println("I can fly")
    }
}

open class Animal15:CanEat{
    override fun eat(){
        println("I can eat")
    }
}

//使用委托的方式（by）实现多继承
class Bird15(flyer:Flyer15,animal: Animal15):CanFly by flyer,CanEat by animal

//数据类data class (Java Bean)
data class BirdDataClass(var weight:Double,var age:Int,var color:String)

fun main(){
    val flyer = Flyer15()
    val animal = Animal15()
    val bird = Bird15(flyer,animal)
    bird.fly()
    bird.eat()
}