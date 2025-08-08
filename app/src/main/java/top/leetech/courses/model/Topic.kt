package top.leetech.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val title: Int,
    val coursesCount: Int,
    @DrawableRes val image: Int
)
