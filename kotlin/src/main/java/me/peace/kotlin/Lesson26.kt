package me.peace.kotlin

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

//使用@Synchronized和synchronized()实现锁模式
class Shop{
    private val goods = hashMapOf<Long,Int>()

    init{
        goods[1] = 10
        goods[2] = 25
    }

    @Synchronized fun buyGoods(id:Long){
        val stock = goods[id]
        if (stock != null) {
            goods[id] = stock - 1
        }
    }

    fun buyGoods2(id:Long){
        synchronized(this) {
            val stock = goods[id]
            if (stock != null) {
                goods[id] = stock - 1
            }
        }
    }

    @Volatile private var running = false


    private val lock: Lock = ReentrantLock()

    //使用ReentrantLock
    fun buyGoods3(id:Long){
        lock.lock()
        try {
            val stock = goods[id]
            if (stock != null) {
                goods[id] = stock - 1
            }
        }catch (e:Exception){
            e.printStackTrace()
        }finally {
            lock.unlock()
        }
    }


    private fun buyGoods4(id:Long){
        val stock = goods[id]
        if (stock != null) {
            goods[id] = stock - 1
        }
    }

    //使用withLock方式优化
    fun buy(){
        val lock = ReentrantLock()
        lock.withLock {
            buyGoods4(1)
        }
    }
}