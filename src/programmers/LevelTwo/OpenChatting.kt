package programmers.LevelTwo

/* =====================================================================================================================
 * 2021.08.06 | gomip | created
 * 프로그래머스 2단계 > 2019 카카오 블라인드 채용 > 오픈채팅
 * ================================================================================================================== */
fun openChat(record: MutableList<String>): Array<String>{
    val user: MutableMap<String, String> = mutableMapOf()                                                               // 사용자 아이디 - 이름 매핑
    val result: MutableList<String> = mutableListOf()

    // 사용자 정보 우선 저장
    record.forEach{ item ->
        val temp = item.split(" ")                                                                             // 여백으로 문장을 쪼개서 저장
        if (temp[0] == "Enter") {
            user.put(temp[1], temp[2])
        } else if (temp[0] == "Change") {
            user.put(temp[1], temp[2])
        }
    }
    record.forEach{ item ->
        val temp = item.split(" ")
        if (temp[0] == "Enter"){
            result.add("${user.get(temp[1])}님이 들어왔습니다.")
        } else if (temp[0] == "Leave") {
            result.add("${user.get(temp[1])}님이 나갔습니다.")
        }
    }
    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val record: MutableList<String> = mutableListOf<String>()                                                           // 로그내역 저장할 변수
    // 로그값 초기화
    record.add("Enter uid1234 Muzi")
    record.add("Enter uid4567 Prodo")
    record.add("Leave uid1234")
    record.add("Enter uid1234 Prodo")
    record.add("Change uid4567 Ryan")

    val ans = openChat(record)
    ans.forEachIndexed{ idx, item ->
        println("log - $idx : $item")
    }
}