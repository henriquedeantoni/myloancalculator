package com.henrianthony.myloancalculator.data

import com.henrianthony.myloancalculator.News
import java.time.LocalDate

object MockNews {
    val mockList = listOf(
        News("Title 1", "Review of the news 1", LocalDate.of(2026, 8, 6)),
        News("Title 2", "Review of the news 2", LocalDate.of(2026, 8, 7)),
        News("Title 3", "Review of the news 3", LocalDate.of(2026, 8, 7))
    )
}