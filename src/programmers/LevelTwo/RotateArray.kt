package programmers.LevelTwo

/* =====================================================================================================================
 * 2021.08.06 | gomip | created
 * 프로그래머스 2단계 > 2021 Dev-Matching: 웹 백엔드 개발 > 행렬 테두리 회전하기
 * ================================================================================================================== */

fun solution(row: Int, column: Int, queries: Array<IntArray>): IntArray {
    var matrix: Array<IntArray> = Array<IntArray>(row){IntArray(column)}

    // 배열 초기화 -------------------------------------------------------------------------------------------------------
    for (r in 0 until row) {
        var temp = IntArray(column) { 0 }
        for (c in 0 until column) {
            temp[c] = r * column + c + 1                                                                                // 1 부터 순서대로 column에 해당하는 값을 저장하기 위한 공식
        }
        matrix[r] = temp
    }

    // 행렬 회전 ---------------------------------------------------------------------------------------------------------
    // 회전 순서
    // (4)------→
    //  ↑      (3)
    //  |       |
    // (1)      ↓
    //  ←------(2)
    var answer = IntArray(queries.size)
    // queries의 배열 값 (x1,x2,y1,y2) => 시작점 (x1, y1), 마지막점 (x2,y2)
    queries.forEachIndexed{ idx, item ->
        val startX = item[0] - 1
        val startY = item[1] - 1
        val endX   = item[2] - 1
        val endY   = item[3] - 1
        println("start : [$startX, $startY] | end : [$endX, $endY]")

        val cur = matrix[startX][startY]
        println("cur : $cur")
        var min : Int = cur                                                                                             // 최소값 저장하는 변수를 회전의 시작값으로 저장

        for (i in startX until endX) {                                                                                  // (1) 회전
            matrix[i][startY] = matrix[i+1][startY]
            if (min > matrix[i][startY]) {
                min = matrix[i][startY]
            }
            println("(1)번회전 [$idx]번째 최소값 : $min ($i)")
        }
        for (i in startY until endY) {                                                                                  // (2) 회전
            matrix[endX][i] = matrix[endX][i+1]
            if (min > matrix[endX][i]) {
                min = matrix[endX][i]
            }
            println("(2)번회전 [$idx]번째 최소값 : $min ($i)")
        }
        for (i in endX downTo startX+1) {                                                                               // (3) 회전
            matrix[i][endY] = matrix[i-1][endY]
            if (min > matrix[i][endY]) {
                min = matrix[i][endY]
            }
            println("(3)번회전 [$idx]번째 최소값 : $min ($i)")
        }
        for (i in endY downTo startY + 1) {                                                                             // (4) 회전
            matrix[startX][i] = matrix[startX][i-1]
            if (min > matrix[startX][i]) {
                min = matrix[startX][i]
            }
            println("(4)번회전 [$idx]번째 최소값 : $min ($i)")
        }
        println("[${idx + 1}]번째 최소값 : $min")
        println("============================")
        answer[idx] = min
        matrix[startX][startY+1] = cur                                                                                  // 시작의 다음값은 계속 값이 변경됨고 있음으로 초기에 저장해둔 값으로 초기화를 다시해줘야 맞게 회전한다.

        matrix.forEach{
            it.forEach{
                print("$it ")
            }
            println("")
        }
        println("============================")
    }
    return answer
}

fun main(args: Array<String>) {
    val row = 3
    val column = 3
    val queries = arrayOf(intArrayOf(1,1,2,2),intArrayOf(1,2,2,3),intArrayOf(2,1,3,2),intArrayOf(2,2,3,3))

    val ans = solution(row, column, queries)

    ans.forEachIndexed{ idx , item ->
        println("${idx+1} 회전 최소값 : $item")
    }
}