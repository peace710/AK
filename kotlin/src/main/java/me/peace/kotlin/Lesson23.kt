package me.peace.kotlin

//注解类定义
annotation class Cache(val namespace:String,val expires:Int)

annotation class CacheKey(val keyName:String,val buckets:IntArray)

@Cache(namespace = "hero",expires = 3600)
data class Hero(
    @CacheKey(keyName = "heroName", buckets = [1, 2, 3])
    val name:String,
    val attack:Int,
    val defense:Int,
    val initHp:Int
)


//控制注解的位置
@Cache(namespace = "hero",expires = 3600)
data class SuperHero(
    @property:CacheKey(keyName = "superHeroName", buckets = [1, 2, 3])
    val name:String,
    @field:CacheKey(keyName = "atk", buckets = [1, 2, 3])
    val attack:Int,
    @get:CacheKey(keyName = "def", buckets = [1, 2, 3])
    val defense:Int,
    val initHp:Int
)