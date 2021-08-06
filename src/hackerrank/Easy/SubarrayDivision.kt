package hackerrank.Easy

import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the birthday function below.
// 5
// 1 2 1 3 2
// d = 3 m = 2
fun birthday(s: Array<Int>, d: Int, m: Int): Int {
    var res = 0


    return res
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val s = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val dm = readLine()!!.trimEnd().split(" ")

    val d = dm[0].toInt()

    val m = dm[1].toInt()

    val result = birthday(s, d, m)

    println(result)
}
