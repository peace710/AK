package me.peace.kotlin

data class Bird16(var weight:Double,var age:Int,var color:String)

data class Pair<out A,out B>(val first:A, val second:B)

data class Triple<out A,out B,out C>(val first:A,val second:B,val third:C)

class CompanionObject{
    //伴生对象
    companion object{
        const val TAG = "CompanionObject"
    }
}

//单例
object Single16{

}

//object表达式
val comparator = object : Comparator<String>{
    override fun compare(o1: String?, o2: String?): Int {
        if (o1 == null){
            return -1
        }else if (o2 == null){
            return 1
        }
        return o1.compareTo(o2)
    }
}

//Lambda表达式方式实现上述功能
val comparator2 = Comparator<String>{ o1,o2 ->
    if (o1 == null){
        return@Comparator -1
    }else if (o2 == null){
        return@Comparator 1
    }
    return@Comparator o1.compareTo(o2)
}

fun main(){
    val bird = Bird16(10.0,10,"blue")
    //通过copy的方式复制一个对象,浅拷贝
    val bird2 = bird.copy(age = 2)
    println(bird2.age)

    //componentN方法复制一个对象
    val (weight,age,color) = bird
    println("weight = $weight,age = $age ,color = $color")

    val p = Pair(20.0,1)
    val t = Triple(20.0,1,"blue")
    //使用componentN方法复制二元组和三元组数据
    val (weight1,age1) = p
    val (weight2,age2,color2) = t
}