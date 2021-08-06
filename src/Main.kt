import kotlin.concurrent.timer

/**
 * 2020.08.04 | gomip | created
 * 2020.08.15 | gomip | day 5~12 added
 */

fun main(args: Array<String>){
//    day1()
//    day2()
//    day3()
//    day4()
//    day5()
//    day6()
//    day7()
//    day8()
//    day9()
//    day10()
//    day11()
    day12()
}

/* ---------------------------------------------------------------------------------------------------------------------
   Day 1 (2020.08.04)
   배열과 덧셈 결과값이 주어졌을때, 배열안의 요소들로 덧셈값이 나올수 있는지 판별하는 문제.
   해쉬 사용
--------------------------------------------------------------------------------------------------------------------- */
fun day1() {
    val arr = mutableListOf(10, 3, 5, 7)
    val answer = 13

    var result = HashSet<Int>()
    for (i in 0 until arr.size) {
        val tmp = answer - arr[i]

        if (result.contains(tmp)) {
            println("Day 1 : true")
        }
        result.add(arr[i])
    }
}

/* ---------------------------------------------------------------------------------------------------------------------
   Day 2 (2020.08.05)
   배열이 주어지면 루프를 돌면서 해당 인덱스에 있는 값을 제외하고 곱셈 수행
--------------------------------------------------------------------------------------------------------------------- */
fun day2(){
    val arr     = mutableListOf(1,2,3,4,5)
    var answer  = mutableListOf<Int>()

    var a = 1
    for (i in 0 until arr.size){
        answer.add(a)
        a *= arr[i]
    }

    var b = 1
    for (i in arr.size-1 downTo 0){
        answer[i] *= b
        b *= arr[i]
    }
    println("Day 2 : $answer")
}

/* ---------------------------------------------------------------------------------------------------------------------
   day4 (2020.08.15)
   배열에 랜덤값이 주어지면 다음으로 나와야하는 양수 출력
--------------------------------------------------------------------------------------------------------------------- */
fun day4(){
    val list : MutableList<Int> = mutableListOf()               // 랜덤 변수를 저장할 리스트 선언
    val size = 5                                                // 임의의 리스트 크기 선언

    for (i in 0 until size){
        list.add((-10..10).random())                            // 랜덤변수로 리스트 채우기
    }

    list.sort()                                                 // 오름 차순 정렬

    println("리스트 정렬 후 : $list")                             // 정렬 후 리스트 출력

    val ans = findPos(list)                                     // 결과 리턴

    println("결과 : $ans")
}

fun findPos(list2 : MutableList<Int>) : Int {
    val size = list2.size                                       // 리스트 크기
    var ans = 1                                                 // 초기값은 1로 설정

    for (i in 1..size) {
        if (!list2.contains(i)){                                // list가 i를 포함하고 있지 않으면 그 값을 결과로 지정
            ans = i
            return ans
        }
    }
    return size + 1                                             // 전부 포함하고 있으면 사이즈 + 1
}


/* ---------------------------------------------------------------------------------------------------------------------
   day5 (2020.08.15)
   cons(a,b) -> pair(a,b)
   car(a,b)  -> return a
   cdr(a,b)  -> return b
--------------------------------------------------------------------------------------------------------------------- */
fun day5(){
    val a = (0..5).random()
    val b = (0..5).random()
    val pair = Pair(a,b)                                        // pair 생성

    val car  = first(a,b)                                       // car 함수 호출
    val cons = last(a,b)                                        // cons 함수 호출

    println("pair : $pair")
    println("car  : $car")
    println("cons : $cons")
}

fun first(a: Int, b: Int) : Int{
    return a
}

fun last(a: Int, b: Int) : Int {
    return b
}


/* ---------------------------------------------------------------------------------------------------------------------
   day6 (2020.08.15)
   xor 생성
--------------------------------------------------------------------------------------------------------------------- */

/* ---------------------------------------------------------------------------------------------------------------------
   day7 (2020.08.15)
   a=1 b=2 ... z=26이라고 주어졌을때
   111 = aaa 혹은 ka 혹은 ak로 디코드하는 함수 생성
   + 0은 포함될수없다
--------------------------------------------------------------------------------------------------------------------- */
fun day7(){
    val input = readLine()!!.trim()                     // input 입력
    decode(input)
}

fun decode(input : String){

}

/* ---------------------------------------------------------------------------------------------------------------------
   day8 (2020.08.15)
   unival tree가 주어지면 서브트리 갯수 갯수 count
--------------------------------------------------------------------------------------------------------------------- */

/* ---------------------------------------------------------------------------------------------------------------------
    day9 (2020.08.15)
    배열이 주어지면 떨어져있는 원소들간의 합으로 최대값 구하기
--------------------------------------------------------------------------------------------------------------------- */
fun day9(){
    val size = readLine()!!.trim().toInt()                              // 크기 선언
    val list : MutableList<Int> = mutableListOf()                       // 배열 선언

    for (i in 0 until size){
        list.add((0..10).random())                                      // 크기만큼 0~10의 임의의 값 저장
    }

    println("list : $list")                                             // list값 출력
    val ans = findMax(list, size)                                       // 결과 출력

    println("maximum value = $ans")
}

fun findMax(list: MutableList<Int>,size: Int) : Int {
    var tmp = 0                                                         // 초기값
    var incl = list[0]                                                  // 현재 idx값을 포함한 최대값
    var excl = 0                                                        // 현재 idx값을 제외한 최대값

    for (i in 0 until size) {
        tmp = Math.max(incl, excl)                                       // incl 와 excl중 큰값을 저장
        incl = excl + list[i]                                           // 기존의 excl + 현재 idx에 위치한 값
        excl = tmp                                                      // incl , excl중 큰값을 저장
    }

    if (incl > excl) {
        return incl
    } else {
        return excl
    }
}

/* ---------------------------------------------------------------------------------------------------------------------
    day10 (2020.08.15)
    n ms 후에 함수 f가 호출되도록
--------------------------------------------------------------------------------------------------------------------- */
fun day10(){
    val n: Long = readLine()!!.trim().toLong()*1000             // input으로 초 입력
    var second:Long = 0

    timer(period = 1000,initialDelay = 1000){
        second += 1
        println("$second passed")                               // 몇초가 지났는지 출력
        if(second*1000 == n) {                                  // 해당 초가 지나면 함수가 수행되도록 출력
            ans(n)
            cancel()
        }
    }

}

fun ans(n: Long) : String{
    return ("${n/1000} ms has been passed.")
}

/* ---------------------------------------------------------------------------------------------------------------------
    day11 (2020.08.15)
    input이랑 배열일아 비교해서 포함되는 값을 출력
--------------------------------------------------------------------------------------------------------------------- */
fun day11(){
    val str : MutableList<String> = mutableListOf("dd","dog","deer","draft","dear","database","code")
    val input = readLine()!!.trim().toString()
    val ans : MutableList<String> = mutableListOf() // 결과 저장할 리스트
    str.sort()                                      // 리스트 정렬
    println(str)

    for(i in 0 until str.size) {
        if(str[i].startsWith(input)){               // input으로 검색한 결과로 시작하는 단어들만 추출
            ans.add(str[i])
        }
    }

    println("ans : $ans")
}

/* ---------------------------------------------------------------------------------------------------------------------
    day12 (2020.08.15)
    1,2로 .input  N 에 대하여 조합 만들기
    (what if, 1,2 가 아닌 모든 숫자로)
--------------------------------------------------------------------------------------------------------------------- */
fun day12(){
    val N = readLine()!!.trim().toInt()                                     // input N
    val ans = findAllCombinations(N)
    println("ans : $ans")
}

fun fib(n: Int) : Int{
    if (n <= 1){
        return n
    } else {
        return fib(n-1) + fib(n-2)
    }
}

fun findAllCombinations(n: Int) : Int{
    return fib(n+1)
}
