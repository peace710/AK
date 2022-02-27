package me.peace.kotlin

fun main() {
    //带接收者的lambda
    val sum : Int.(Int) -> Int = {other -> plus(other)}
    println(2.sum(1))


    //with
    val tv = TV("Sharp",60,1000.0)
    with(tv){
        println(this.name)
        println(this.size)
        println(this.price)
    }

    //apply
    tv.apply{
        println(this.name)
        println(this.size)
        println(this.price)
    }

    //map
    val list = arrayListOf<Int>(1,2,3,4)
    val mapList = list.map { it * 2 }
    mapList.forEach {
        print(it)
    }

    println()

    //filter
    val filterList = list.filter { it > 1 }
    filterList.forEach {
        print(it)
    }
    println()

    //count
    val count = list.count { it > 1 }
    println(count)

}

data class TV(val name:String ,val size:Int,val price:Double)