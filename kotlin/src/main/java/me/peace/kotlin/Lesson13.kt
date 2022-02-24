package me.peace.kotlin

import kotlin.properties.Delegates

//Kotlin中的一个类，相当于java中public final class Bird
//如需要被继承，需要更改成open class Bird
class Bird{
    //成员属性,相当于private final double weight = 500.0D
    val weight:Double = 500.0
    val color:String = "blue"
    val age:Int = 1
    //成员方法,相当public final void fly()
    //方法若需要被覆盖，需要更改成open fun fly()
    fun fly(){

    }
}

//Kotlin以此方式解决构造方法过多的问题，避免不必要的方法重载
class Bird2(val weight:Double =0.00,val age:Int = 0,val color:String = "blue") {
    //init语句块，可在初始化时进行额外的操作
    init {
        println("do something in init block")
    }

    init{
        //多个init语句块，从从上往下的顺序执行
        println("the second init block")
    }
}


//在没有val或var的时候，构造方法的参数可在init语句块被直接调用
class Bird3(weight: Double= 0.00,age:Int = 0,color: String = "blue"){
    val weight:Double = weight
    val age:Int = age
    val color:String = color
}

//by lazy方式来修饰
//1.该变量必须引用不可变，不能通过var来声明
//2.在被首次调用时，才会进行赋值操作。一旦被赋值，后续它将不能被更改
//lazy的背后是接受一个lambda并返回一个Lazy<T>实例的函数，第一次访问该属性时
//会执行lazy对应的Lambda表达式并记录结果，后续访问该属性时只是返回记录的结果
//另外系统会给lazy属性默认加上同步锁，也就是LazyThreadSafetyMode.SYNCHRONIZED
//同一时刻只允许一个线程对lazy属性进行初始化，所以它是线程安全的
class Bird4(val weight:Double, val age:Int, private val color:String){
    val sex :String by lazy{
        if (color == "yellow") "male" else "female"
    }

    //不存在安全问题，可以指这种方式，并行执行
    val sex2:String by lazy(LazyThreadSafetyMode.PUBLICATION){
        if (color == "yellow") "male" else "female"
    }

    //不做任何线程保证，不会有任何线程开销
    val sex3:String by lazy(LazyThreadSafetyMode.NONE){
        if (color == "yellow") "male" else "female"
    }

    //lateint用于var变量的声明，可以延迟初始化
    lateinit var sex4:String

    fun printSex(){
        this.sex4 = if (color == "yellow") "male" else "female"
    }

    //使用Delegates.notNull<T>的方式对基本数据类型进行延迟初始化
    var test by Delegates.notNull<Int>()
    fun doSomething(){
        test = 10
    }
}


//主从构造方法
class Bird5{
    constructor(weight: Double):this(weight, 10)

    constructor(weight: Double,age: Int):this(weight,age,"blue")

    constructor(weight: Double,age: Int,color: String)
}


interface Flyer {
    //相当于java中 int getSpeed()
    val speed:Int
    //kotlin通过这种方式实现interface中给常量赋值
    val speedOther:Int
            get() = 1000

    fun kind()
    //默认方法，相当于java default public void fly()
    fun fly(){
        println("I can fly")
    }
}

fun main(){
    //Kotlin通过这种方式声明一个类的对象
    val bird = Bird()

    //用如下的方法构造对象，对需要的参数进行参数设置（具名方法），未指定的使用默认值
    val bird1 = Bird2(color = "black")

    val bird2 = Bird2(weight = 1000.00,color = "black")
}