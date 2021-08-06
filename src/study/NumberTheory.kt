package study

import java.util.*

/**
 * 정수론 너무 좋잖아
 */
fun numberTheory(n: Int): Int {
    var res = 0

    for (i in 1..n) {
        if (n % i == 0 && i % 2 == 0) {
            res += 1
        }
    }

    return res
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    var num = scan.nextLine().trim().toInt()

    val start = System.nanoTime()
    val res = numberTheory(num)
    val end = System.nanoTime()
    println("res1       : $res")
    println("totla time : ${end - start}")

    println("----------------------")
}