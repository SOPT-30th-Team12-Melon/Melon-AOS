package org.sopt.jointseminar.melon.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("timeFormat")
fun TextView.setTimeFormat(regTime: Long?) {
    if (regTime == null || regTime == 0L) run {
        text = ""
        return
    }

    val curTime = System.currentTimeMillis()
    var diffTime = (curTime - regTime) / 1000

    text = when {
        diffTime < TimeUtil.SEC -> {
            "방금 전"
        }
        TimeUtil.SEC.let { diffTime /= it; diffTime } < TimeUtil.MIN -> {
            "${diffTime}분 전"
        }
        TimeUtil.MIN.let { diffTime /= it; diffTime } < TimeUtil.HOUR -> {
            "${diffTime}시간 전"
        }
        TimeUtil.HOUR.let { diffTime /= it; diffTime } < TimeUtil.DAY_OF_MONTH -> {
            if (diffTime < TimeUtil.DAY_OF_WEEK)
            {
                "${diffTime}일 전"
            } else {
                diffTime /= TimeUtil.DAY_OF_WEEK
                "${diffTime}주 전"
            }
        }
        TimeUtil.DAY_OF_MONTH.let { diffTime /= it; diffTime } < TimeUtil.MONTH -> {
            "${diffTime}달 전"
        }
        else -> {
            diffTime /= TimeUtil.MONTH
            "${diffTime}년 전"
        }
    }
}