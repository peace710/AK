package me.peace.kotlin

//Kotlin中类和方法默认是不可继承和重写的
//所以需要加上open修饰符
open class Birds{
    open fun fly(){
        println("I can fly")
    }
}

//Kotlin中没有java的extends和implements，使用":"来代替类的继承和接口的实现
class Penguin:Birds(){
    override fun fly() {
        super.fly()
    }
}

interface Fly{
    fun fly()

    fun kind() = "[Fly]Flying animal"
}

interface Animal{
    val name:String

    fun eat()

    fun kind() = "[Animal]Flying animal"
}

//实现多个接口，其中kind方法实现Fly接口
class FlyBird(override val name: String):Animal,Fly{
    override fun fly() {
        println("I can fly")
    }

    override fun eat() {
        println("I can eat")
    }

    override fun kind(): String {
        return super<Fly>.kind()
    }
}

class InnerClass{
    val name = "This is inner class"

    //内部类
    inner class Inner{
        fun printName(){
            println("the name is $name")
        }
    }
}

fun main(){
    val flyBird = FlyBird("FlyBird")
    println(flyBird.kind())
}