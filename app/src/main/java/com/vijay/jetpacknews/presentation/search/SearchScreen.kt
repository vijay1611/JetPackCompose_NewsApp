package com.vijay.jetpacknews.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vijay.jetpacknews.presentation.Dimens.MediumPadding


@Composable
fun SearchScreen(
    state: SearchState,
    event :(SearchEvent) -> Unit
){
    Column(
        modifier = Modifier.padding(top = MediumPadding, start = MediumPadding, end = MediumPadding)
            .statusBarsPadding()
    ) {
           // SearchBar
    }

}