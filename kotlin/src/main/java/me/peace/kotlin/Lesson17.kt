package me.peace.kotlin

fun main(){

    //数组类型，数组大小固定
    val list1 = arrayOf<Int>()

    val list2 = arrayOf<Int>(1,2,3,4,5)

    val list3 = intArrayOf(1,2,3,4,5)

    cut(Watermelon(3.0))

    println(getType<Watermelon>())
}

//泛型类
class SmartList<T>:ArrayList<T>(){
    fun find(t:T):T?{
        val index = this.indexOf(t);
        return if (index >= 0)  this[index] else null
    }
}

//泛型方法，扩展函数
fun <T> ArrayList<T>.find(t:T):T?{
    val index = this.indexOf(t)
    return if (index >=0) this[index] else null
}

open class Fruit(val weight:Double)

class Apple(weight:Double):Fruit(weight)

//泛型的类型约束，类型上限
class FruitPlate<T:Fruit>(val t:T)

interface Ground{

}

class Watermelon(weight: Double):Fruit(weight),Ground
//使用where关键字，对泛型参数添加约束
//只有是Fruit子类且实现Ground接口，才能调用，否则报错
fun <T> cut(t:T) where T:Fruit,T:Ground{
    println("You can cut me")
}

inline fun <reified T> getType(): Class<T> {
    return T::class.java
}