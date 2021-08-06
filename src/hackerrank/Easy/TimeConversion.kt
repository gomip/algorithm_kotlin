package hackerrank.Easy

import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*

/*
 * Complete the timeConversion function below.
 */
fun timeConversion(s: String): String {
    /*
     * Write your code here.
     */
    var res = ""

    var date :SimpleDateFormat = SimpleDateFormat("hh:mm:ssa")
    var convert = date.parse(s)
    var format:SimpleDateFormat = SimpleDateFormat("HH:mm:ss")
    res = format.format(convert)

    // println("result : $res")

    return res
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = timeConversion(s)

    println(result)
}
