package hackerrank

import java.util.*

fun main(args: Array<String>){
//    hackerrank.Q1()
//    hackerrank.Q2()
//    hackerrank.Q3()
//    hackerrank.Q4()
//    hackerrank.Q5()
//    hackerrank.Q6()
//    hackerrank.Q7()
//    hackerrank.Q8()
//    hackerrank.Q9()
//    hackerrank.Q10()
//    hackerrank.Q11()
//    hackerrank.Q12()
//    hackerrank.Q91()
    Q92()
//    subArray()
}


/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q1 (2020.08.05)
   input 합
--------------------------------------------------------------------------------------------------------------------- */

fun Q1() {
    println("=======================================================================")
    println("hackerrank.Q1")
    val sc = Scanner(System.`in`)
    val num1 = sc.nextInt()
    val num2 = sc.nextInt()
    val sum = solveMeFirst(num1, num2)
    println("answer : $sum")
    println("=======================================================================")
}

fun solveMeFirst(a: Int, b: Int) : Int{
    return a+b
}

/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q2 (2020.08.05)
   배열 원소 합
--------------------------------------------------------------------------------------------------------------------- */

fun Q2() {
    println("=======================================================================")
    println("hackerrank.Q2")
    val scan = Scanner(System.`in`)

    val arCount = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = simpleArraySum(ar)

    println("answer : $result")
    println("=======================================================================")
}

fun simpleArraySum(ar: Array<Int>) : Int {
    var res = 0
    for (i in ar.indices){
        res += ar[i]
    }
    return res
}

/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q3 (2020.08.05)
   각각 a랑 b에게 3개의 점수를 주고, 같은 index끼리 비교해서 점수 주기
   a[0]>b[0] => alice +1
   a[0]=b[0] => draw
   a[0]<b[0] => bob +1
   result = {alice 점수, bob 점수}

   1st input : Alice 점수
   2nd input : Bob 점수
--------------------------------------------------------------------------------------------------------------------- */

fun Q3(){
    println("=======================================================================")
    println("hackerrank.Q3")
    val a = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toTypedArray()
    val b = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toTypedArray()

    val result = compareTriplets(a,b)
    println("answer : ${result.joinToString(" ")}")
    println("=======================================================================")
}
fun compareTriplets(a: Array<Int>, b: Array<Int>) : Array<Int>{
    val point = arrayOf(0,0)
    for (i in a.indices) {
        if(a[i]>b[i]) {
            point[0] += 1
        } else if (a[i] < b[i]) {
            point[1] +=1
        }
    }
    return point
}

/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q4 (2020.08.05)
   음청 큰 수를 더하자
   1st input : input 갯수
   2nd input : input 값
--------------------------------------------------------------------------------------------------------------------- */

fun Q4(){
    println("=======================================================================")
    println("hackerrank.Q4")
    val scan = Scanner(System.`in`)
    val arCount = scan.nextLine().trim().toInt()
    val ar = scan.nextLine().split(" ").map{it.trim().toLong()}.toTypedArray()

    var result : Long = 0
    if (ar.size <= arCount){
        result = aVeryBigSum(ar)
    }
    println("answer : $result")
    println("=======================================================================")
}

fun aVeryBigSum(ar: Array<Long>) : Long{
    var res : Long = 0
    for (i in ar.indices){
        res += ar[i]
    }
    return res
}

/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q5 (2020.08.05)
   음수 양수 0 비율 구하기
   1st input : input 갯수
   2nd input : input

   output : 양수 음수 0 순으로 출력력
--------------------------------------------------------------------------------------------------------------------- */

fun Q5() {
    println("=======================================================================")
    println("hackerrank.Q5")
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    if (arr.size <= n) {
        plusMinus(arr)
    }
    println("=======================================================================")
}

fun plusMinus(arr: Array<Int>) : Unit {
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

/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q6 (2020.08.05)
   별 찍기
   하나의 input으로 최대 층이랑 갯수 설정
   오른쪽으로 그려져야됨
--------------------------------------------------------------------------------------------------------------------- */

fun Q6(){
    println("=======================================================================")
    println("hackerrank.Q6")
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    staircase(n)
    println("=======================================================================")
}

fun staircase(n: Int) : Unit {
    for(i in 0 until n){
        for(j in n-1 downTo 0){
            if(i<j){
                print(" ")
            } else{
                print("#")
            }
        }
        println()
    }
}

/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q7 (2020.08.08)
   .사과 거리 계산
--------------------------------------------------------------------------------------------------------------------- */
fun Q7(){
    val scan = Scanner(System.`in`)

    val st = scan.nextLine().split(" ")

    val s = st[0].trim().toInt()

    val t = st[1].trim().toInt()

    val ab = scan.nextLine().split(" ")

    val a = ab[0].trim().toInt()

    val b = ab[1].trim().toInt()

    val mn = scan.nextLine().split(" ")

    val m = mn[0].trim().toInt()

    val n = mn[1].trim().toInt()

    val apples = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val oranges = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    countApplesAndOranges(s, t, a, b, apples, oranges)
}

fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
    var apple = 0
    var orange = 0

    // 사과
    for (i in apples.indices){
        if(apples[i]+a in s..t){
            apple += 1
        }
    }

    for (j in oranges.indices){
        if(oranges[j]+b in s..t){
            orange +=1
        }
    }

    println("apple : $apple")
    println("orange : $orange")
}

/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q8 (2020.08.08)
   캥거루 거리계산
--------------------------------------------------------------------------------------------------------------------- */
fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {
    var res = ""

    for (i in 1..10000){
        if (x1 + v1*i == x2 +v2*i){
            res = "YES"
            break
        } else {
            res = "NO"
        }
    }
    return res
}

fun Q8() {
    val scan = Scanner(System.`in`)

    val x1V1X2V2 = scan.nextLine().split(" ")

    val x1 = x1V1X2V2[0].trim().toInt()

    val v1 = x1V1X2V2[1].trim().toInt()

    val x2 = x1V1X2V2[2].trim().toInt()

    val v2 = x1V1X2V2[3].trim().toInt()

    val result = kangaroo(x1, v1, x2, v2)

    println(result)
}

/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q9 (2020.08.08)
   연속되는 s캐릭터 제거
--------------------------------------------------------------------------------------------------------------------- */
fun superReducedString(s: String): String {
    var res = ""
    var arr = s.toCharArray()

    var len = s.length

    if (len < 2) {
        return s
    }

    var j = 0
    for (i in 0 until len){
        if (arr[j] != arr[j]) {
            j++
            arr[j]=arr[i]
        }
    }
    return res
}

fun Q9() {
    val s = readLine()!!

    val result = superReducedString(s)

    println(result)
}

/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q10 (2020.08.28)
   대각의 합 차이 구하기
--------------------------------------------------------------------------------------------------------------------- */
fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var ans = 0

    val size = arr.size
    var d1 = 0                  // 좌 -> 우 대각
    var d2 = 0                  // 우 -> 좌 대각

    arr.forEachIndexed { index, it ->
        d1 += it[index]
        d2 += it[size-index-1]
    }

    ans = d1 - d2

    if (ans < 0) {              // 음수면 -1 을 곱해준다.
        ans *= -1
    }

    return ans
}

fun Q10(){
    val n = readLine()!!.trim().toInt()

    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}
/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q11 (2020.08.28)
   크기가 5인 int형 배열이 주어지면 최대합과 최소합 구하기
--------------------------------------------------------------------------------------------------------------------- */
fun miniMaxSum(arr: Array<Int>): Unit {
    var min : Long= 0
    var max : Long= 0

    arr.sort()

    arr.forEach{
        println(" arr : $it")
    }

    for (i in 0 until arr.size-1){
        min += arr[i]
        max += arr[i+1]

        println("min [$i] : $min")
        println("max [$i] : $max")
    }

    return println("$min $max")
}

fun Q11() {
    val scan = Scanner(System.`in`)

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    miniMaxSum(arr)
}
/* ---------------------------------------------------------------------------------------------------------------------
   hackerrank.Q12 (2020.08.28)
   생일 케이크 촛불 끄기
--------------------------------------------------------------------------------------------------------------------- */
fun birthdayCakeCandles(ar: Array<Int>): Int {
    var ans = 0

    val max = ar.max()          // 최대값

    ar.forEach {
        if (it == max){
            ans += 1
        }
    }

    return ans
}

fun Q12(){
    val scan = Scanner(System.`in`)

    val arCount = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = birthdayCakeCandles(ar)

    println(result)
}
/* ---------------------------------------------------------------------------------------------------------------------
   Q?? (2020.09.01)
   Run length alg
--------------------------------------------------------------------------------------------------------------------- */
fun Q91(){
    val a = "aaaabbccc" // 4a2b3c
    val b = "2a3b4c"    // aabbbcccc

    val res1 = ecd(a)
    val res2 = dcd(b)

    println("encode $a: $res1 ")
    println("decode $b: $res2 ")
}

fun ecd(a : String) : String {
    var ans = ""
    val tmp = a.toCharArray()
    var cnt = 1
    var c = ""
    for (i in 0 until a.length){
        if (i < a.length -1 && tmp[i] == tmp[i+1]){
            cnt += 1
            c = tmp[i].toString()
        }
        else {
            ans += "$cnt$c"
            cnt = 1
            c = ""
            continue
        }
    }
    return ans
}

fun dcd(b : String) : String {
    var ans = ""
    val regex = """[0-9]""".toRegex()
    var num = 0
    var tmp = b.toCharArray()


    for (i in 0 until b.length){
        if(regex.matches(tmp[i].toString())){
            num = Integer.parseInt(tmp[i].toString())
        } else {
            ans += tmp[i].toString().repeat(num)
            num = 0
            continue
        }
    }

    return ans
}
/* ---------------------------------------------------------------------------------------------------------------------
   Q?? (2020.09.01)
   괄호닫기
--------------------------------------------------------------------------------------------------------------------- */
fun Q92(){
    val b1 = "()[{]}"
    val b2 = "(}{"

    val chk1 = isClosed(b1)
    val chk2 = isClosed(b2)

    println("b1 : $chk1")
    println("b2 : $chk2")
}

fun isClosed(str: String) : Boolean {
    var dq : Deque<String> = LinkedList<String>()
    var tmp = str.toCharArray()

    for (i in 0 until str.length){
        if (tmp[i] == '(' || tmp[i] =='{' || tmp[i] == '['){
            dq.add(tmp[i].toString())
        } else {
            if (dq.isNotEmpty()
                    && (dq.peekFirst() == "(" && tmp[i]==')')
                    || (dq.peekFirst() == "{" && tmp[i]=='}')
                    || (dq.peekFirst() == "[" && tmp[i]==']')
            ){
                dq.removeFirst()
            } else {
                return false
            }
        }
    }
    return true
}


/* ---------------------------------------------------------------------------------------------------------------------
   Q?? (2020.09.01)
   powerset
--------------------------------------------------------------------------------------------------------------------- */
fun Q93(){
    val input = listOf(1,2,3)
    val ans = generateSet(input)
    println(ans)
}

fun generateSet(input : List<Int>) : MutableList<MutableList<Int>>{
    var res : MutableList<MutableList<Int>> = mutableListOf()
    return res
}