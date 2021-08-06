package study

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.math.sqrt
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

fun isPrime(n : Int) : Boolean {
    var j = 2
    if (n<=2){
        return false
    }
    while (j*j <= n){
        if(n%j == 0) return false
        j += 1
    }
    return true
}

fun main(args: Array<String>){
    val scan = Scanner(System.`in`)

    val n = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toTypedArray()

    n.forEach{
        val res = isPrime(it)

        if (res) {
            println("$it is prime")
        } else {
            println("$it is not prime")
        }
    }

}