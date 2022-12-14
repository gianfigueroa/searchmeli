package com.giancarlosfigueroa.searchmeli.feature_search.presentation.components

import android.text.Layout
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun LoadingShimmerEffect(){

   //These colors will be used on the brush. The lightest color should be in the middle

   val gradient = listOf(
       LightGray.copy(alpha = 0.4f), //darker grey (90% opacity)
       LightGray.copy(alpha = 0.1f), //lighter grey (30% opacity)
       LightGray.copy(alpha = 0.4f)
   )
   
   val transition = rememberInfiniteTransition() // animate infinite times

   val translateAnimation = transition.animateFloat( //animate the transition
       initialValue = 0f,
       targetValue = 1000f,
       animationSpec = infiniteRepeatable(
           animation = tween(
               durationMillis = 1000, // duration for the animation
               easing = FastOutLinearInEasing
           )
       )
   )
   val brush = linearGradient(
       colors = gradient,
       start = Offset(200f, 200f),
       end = Offset(x = translateAnimation.value,
       y = translateAnimation.value)
   )
   ShimmerGridItem(brush = brush)
}

@Composable
fun ShimmerGridItem(brush: Brush) {
    Row(modifier = Modifier
        .fillMaxSize()
        .padding(all = 10.dp), verticalAlignment = Alignment.Top) {

        Spacer(modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(verticalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.5f)
                .background(brush)
            )

            Spacer(modifier = Modifier.height(10.dp)) //creates an empty space between
            Spacer(modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.7f)
                .background(brush)
            )

            Spacer(modifier = Modifier.height(10.dp)) //creates an empty space between
            Spacer(modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.9f)
                .background(brush))
        }
    }


}