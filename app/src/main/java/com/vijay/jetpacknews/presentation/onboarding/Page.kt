package com.vijay.jetpacknews.presentation.onboarding

import androidx.annotation.DrawableRes
import com.vijay.jetpacknews.R

data class Page(
    val title:String,
    val description:String,
    @DrawableRes val image:Int
)

val pages = listOf(
    Page(
        title = "first",
        description = "this is description for this...",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "second",
        description = "this is description for this...",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "third",
        description = "this is description for this...",
        image = R.drawable.onboarding3
    )
)