package me.peace.kotlin

class Book(val name:String)

fun main(){
    //方法引用，类的构造方法引用
    val getBook = ::Book
    //输出Dive into Kotlin
    println(getBook("Dive into Kotlin").name)

    //成员引用
    val bookNames = listOf(Book("Thinking in Java"),Book("Dive int Kotlin")).map(Book::name)
    //输出[Thinking in Java, Dive int Kotlin]
    println(bookNames)
}