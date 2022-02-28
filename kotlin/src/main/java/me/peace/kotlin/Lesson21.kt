package me.peace.kotlin

data class Area(val value:Double)

//运算符重载
operator fun Area.plus(that:Area):Area{
    return Area(this.value + that.value)
}

fun main(){
    val area1 = Area(10.0)
    val area2 = Area(20.0)
    println(area1 + area2)

    val mutableListOf = mutableListOf(10, 20)
    mutableListOf.exchange(0,1)
    println(mutableListOf)

    Son.foo()

    val son = Son()
    son.extend()

    Parent.main()
}

//扩展函数，MutableList<Int>为接收者类型
fun MutableList<Int>.exchange(fromIndex:Int,toIndex:Int){
    val tmp = this[fromIndex]
    this[fromIndex] = this[toIndex]
    this[toIndex] = tmp
}

class Son{
    companion object{
        val age = 10
    }

    //成员方法优先级高于扩展函数
    fun extend(){
        println("extend in Son")
    }

    fun doSomeThing(){
        println("son do some thing")
    }
}

object Parent{
    fun doSomeThing(){
        println("parent do some thing")
    }

    fun main(){
        fun Son.doThing(){
            this.doSomeThing()
            this@Parent.doSomeThing()
        }

        Son().doThing()
    }
}

fun Son.extend(){
    println("extend in extension")
}

//静态扩展函数，需要将其定义在伴生对象上
fun Son.Companion.foo(){
    println("age = $age")
}