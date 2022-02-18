package me.peace.kotlin

fun main(){
    //val:引用不可变
    //尽可能采用val、不可变对象及纯函数来设计函数
    //作为防御性编码思维模式，更安全可靠，因为变量的值永远不会在其他地方被改变（反射技术除外，适合并发编程）
    val x = intArrayOf(1,2,3)
    //x = intArrayOf(2,3,4)  //Error:Val cannot be reassigned,类似于java的final,只读变量

    x[0] = 3 //引用虽然不可更改，值是可以改变的
    println(x[0]) //输出3

    //var 变量
    var y = 5
    y += 5
    println(y)

    var r = cal(listOf(1,2,3))
    println(r)
}

fun cal(list:List<Int>):Int{
    //[1,2,3],el为集合中的元素
    //res = 0
    //res *= el
    //res += el
    return list.fold(0) {
        res,el -> res * el + el
    }
}