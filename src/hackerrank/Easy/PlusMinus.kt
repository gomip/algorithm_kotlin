package hackerrank.Easy

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
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the plusMinus function below.
fun plusMinus(arr: Array<Int>): Unit {

    var pos : Double = 0.0
    var neg : Double = 0.0
    var zero : Double = 0.0

    for (i in arr.indices){
        if (arr[i]>0) {
            pos += 1
        } else if (arr[i]<0){
            neg += 1
        } else {
            zero += 1
        }
    }

    println(String.format("%.6f",pos/arr.size))
    println(String.format("%.6f",neg/arr.size))
    println(String.format("%.6f",zero/arr.size))

}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    if (arr.size <= n) {
        plusMinus(arr)
    }
}
