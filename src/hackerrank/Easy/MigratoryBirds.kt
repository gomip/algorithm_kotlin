package hackerrank.Easy

import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

// Complete the migratoryBirds function below.
// 배열에서 중복이 많은 값중 최소키값

fun migratoryBirds(arr: Array<Int>): Int {
    var res = 0
    var map = mutableMapOf<Int,Int>()
    for (i in arr){
        var cnt = map[i]
        if (cnt == null) cnt = 0
        map[i] = cnt + 1

        map.put(i, map[i]!!)
    }

    println("map : $map")
    val maxv = map.values.max()

    val list = map.filterValues { it == maxv }.keys

    res = list.min()!!

    return res
//    var map = hashMapOf<Int, Int>()
//    for (i in 0 until arr.size) {
//        var current = arr[i]
//        for (j in 0 until arr.size) {
//            if (current == arr[j]){
//                res += 1
//            }
//        }
//        map.put(current, res)
//        res = 0
//    }
//
//    var v = map.values
//
//    val maxv = v.max()
//
//    val list = map.filterValues { it == maxv}.keys
//
//    res = list.min()!!
}

fun main(args: Array<String>) {
    val arrCount = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = migratoryBirds(arr)

    println(result)
}
