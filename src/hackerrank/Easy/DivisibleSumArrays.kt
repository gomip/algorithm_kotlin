package hackerrank.Easy

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

// Complete the divisibleSumPairs function below.
// k로 나눠지는 값 구하기
// n 배열크기
// k 나눠질 값
//
fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
    var res = 0

    for (i in 0 until n){
        for (j in i+1 until n) {
            val s = ar[i] + ar[j]
            if (s % k == 0) {
                res += 1
            }
        }
    }

    return res
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = divisibleSumPairs(n, k, ar)

    println(result)
}
