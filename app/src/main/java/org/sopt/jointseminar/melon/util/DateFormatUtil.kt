package org.sopt.jointseminar.melon.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/** yyyy-MM-dd'T'HH:mm:ss.SSS'Z' -> long 타입으로 시간 포맷 변경 */
fun convertTimeZonToLong(strDate: String): Long? {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val date: Date?
    try {
        date = dateFormat.parse(strDate)
    } catch (e: ParseException) {
        e.printStackTrace()
        return null
    }
    return date.time
}

/** yyyy-MM-dd'T'HH:mm:ss.SSS'Z' -> yyyy.MM.dd 타입으로 시간 포맷 변경 */
fun convertTimeZonToYMD(date: String?): String? {
    val inputDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    val outputDateFormat = SimpleDateFormat("yyyy.MM.dd")
    val inputDate: Date
    val outputDate: String
    try {
        inputDate = inputDateFormat.parse(date)
        outputDate = outputDateFormat.format(inputDate)
    } catch (e: ParseException) {
        e.printStackTrace()
        return null
    }
    return outputDate
}