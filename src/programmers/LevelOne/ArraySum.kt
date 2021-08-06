package programmers.LevelOne

/**
 * sortedSetOf 너무 좋잖어~
 * Level 1. 두개 뽑아서 더하기
 */
fun solution(numbers: IntArray): IntArray {
    var answer: IntArray = intArrayOf()

    var list = sortedSetOf<Int>()
    for (i in numbers.indices){
        var j = 1
        while(j <numbers.size) {
            if(i!=j){
                var sum = numbers[i] + numbers[j]
                list.add(sum)
            }
            j+=1
        }
    }

    answer = list.toIntArray()
    return answer
}

fun main(args: Array<String>){
    var list = intArrayOf(5,0,2,7)
    var res = solution(list)

    res.forEach{
        println(it)
    }

}