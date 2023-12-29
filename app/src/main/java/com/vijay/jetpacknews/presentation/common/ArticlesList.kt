package com.vijay.jetpacknews.presentation.common

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.vijay.jetpacknews.domain.model.Article
import com.vijay.jetpacknews.presentation.Dimens.ExtraSmallPadding2
import com.vijay.jetpacknews.presentation.Dimens.MediumPadding

//@Composable
//fun ArticlesList(
//    modifier: Modifier = Modifier,
//    articles: LazyPagingItems<Article>,
//    onClick:(Article)->Unit
//){
//
//}

@Composable
fun ArticleList(
    modifier: Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {
    val handlePagingResult = handlePagingResult(articles=articles)
    if (handlePagingResult) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding),
            contentPadding = PaddingValues(all = ExtraSmallPadding2)
        ) {
            items(count = articles.itemCount) {
                articles[it]?.let {
                    ArticleCard(article = it, onClick = { onClick(it) })
                }
            }
        }
    }
}

@Composable
fun handlePagingResult(
    articles:LazyPagingItems<Article>
):Boolean{
        val loadState = articles.loadState
    val error =when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else  -> null
    }
    return  when{
        loadState.refresh is LoadState.Loading ->{
            ShimmerEffect()
            false
        }
//        error != null ->{
//            ShimmerEffect()
//            false
//        }
        else ->{
            true
        }
    }
    }


@Composable
private fun ShimmerEffect(){
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding)) {
        repeat(10){
            ArticleCardShimmereffect(
                modifier = Modifier.padding(horizontal = MediumPadding)
            )
        }
    }
}