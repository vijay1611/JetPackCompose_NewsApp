package com.vijay.jetpacknews.presentation.common

import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.vijay.jetpacknews.R
import com.vijay.jetpacknews.presentation.Dimens
import com.vijay.jetpacknews.presentation.Dimens.MediumPadding

fun Modifier.shimmerEffect() = composed {
    val transition = rememberInfiniteTransition()
    val alpha =  transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
        animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
    )).value
    background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
}


@Composable
fun ArticleCardShimmereffect(
    modifier: Modifier=Modifier
) {
    Row(modifier = Modifier) {
        Box(
            modifier = Modifier
                .size(Dimens.articleCardSize)
                .clip(MaterialTheme.shapes.medium)
                .shimmerEffect(),
        )
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = Dimens.ExtraSmallPadding)
                .height(Dimens.articleCardSize)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(30.dp)
                    .padding(horizontal = MediumPadding)
                    .shimmerEffect(),
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .height(15.dp)
                        .padding(horizontal = MediumPadding)
                        .shimmerEffect(),
                )
            }
        }
    }
}