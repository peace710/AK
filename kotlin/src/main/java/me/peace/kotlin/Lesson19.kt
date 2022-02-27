package me.peace.kotlin

data class Student(val name:String,val score:Int,val sex:String,val hobbies:List<String>)

fun main(){
    val students = listOf<Student>(
        Student("Jim",90,"m",listOf("running")),
        Student("Tom",80,"f",listOf("reading")),
        Student("Jerry",100,"m",listOf("coding")),
        Student("Daisy",90,"m",listOf("game","singing")),
        Student("Lucy",100,"f",listOf("writing"))
    )

    //groupBy分组
    val groupBy = students.groupBy { it.sex }
    println(groupBy)
    println(groupBy["m"])
    println(groupBy["f"])


    //fold求和
    val sumFold = students.fold(0){
        scores,stu -> scores + stu.score
    }

    println(sumFold)

    //sumOf求和
    val scores = students.sumOf { it.score }
    println(scores)

    val list = listOf<Int>(80,80,100)

    //sum求和
    val scoreList = list.sum()
    println(scoreList)

    //flatten处理嵌套集合
    val strList = listOf(listOf("angel","ben","daisy"),listOf("jackson","ken"), listOf("nick"))
    val flatten = strList.flatten()
    println(flatten)

    //flatMap处理嵌套集合
    val flatMap = students.flatMap { it.hobbies }
    println(flatMap)
}

