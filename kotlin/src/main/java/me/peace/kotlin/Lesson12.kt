package me.peace.kotlin

//中缀表达式,标准库里的to
//infix fun<A,B> A.to(that:B):Pair<A,B>
//A 中缀方法 B
//中缀函数必须是某个类的扩展函数或成员方法，且只能有一个参数，参数不能有默认值
class Person{
    infix fun called(name: String){
        println("name = $name")
    }
}


//vararg代表可变参数
fun printLetters(vararg letters:String,count:Int):Unit{
    print("$count letters are ")
    for (letter in letters) print(letter)
}

fun main(){
    mapOf(
        1 to "one",
        2 to "two"
    )

    val p = Person()
    p.called("Jane")
    p called "Angel"

    val letters = arrayOf("A","B","C")
    //*g来传入可变参数
    printLetters(*letters, count = 3)
}