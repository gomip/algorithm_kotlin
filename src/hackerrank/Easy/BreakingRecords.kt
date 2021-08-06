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

// Complete the breakingRecords function below.
fun breakingRecords(scores: Array<Int>): MutableList<Int> {
    var min = 0
    var max = 0
    var minp = 0
    var maxp = 0
    var res = mutableListOf<Int>()

    scores.forEachIndexed{idx, item ->
        if (idx ==0){
            min = item
            max = item
        } else {
            if (item > max){
                maxp = maxp + 1
                max = item
            } else if (item < min){
                minp = minp + 1
                min = item
            }
        }
    }

    res.add(maxp)
    res.add(minp)

    return res
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val scores = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = breakingRecords(scores)

    println(result.joinToString(" "))
}
