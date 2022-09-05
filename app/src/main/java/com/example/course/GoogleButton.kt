package com.example.course


import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.course.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun GoogleButton(){
	var clicked by remember {
		mutableStateOf(false)
	}

	Surface(
		onClick = {clicked = !clicked},
		shape = Shapes.medium,
		border = BorderStroke(width = 1.dp, Color.LightGray),
		color = MaterialTheme.colors.surface
	)
	{
		Row (
			modifier = Modifier.padding(
				start = 12.dp,
				end = 16.dp,
				bottom = 12.dp,
				top = 12.dp
			).animateContentSize (
				animationSpec = tween(
					durationMillis = 300,
					easing = LinearEasing
				)
					),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Center
				) {
			Icon(
				painter = painterResource(id = R.drawable.ic_google_logo),
				contentDescription = "Google",
				tint = Color.Unspecified
			)
			Spacer(modifier = Modifier.width(6.dp))
			Text(text = "Sign with Google")
			if (clicked)
			{
				CircularProgressIndicator(
					modifier = Modifier
						.height(16.dp)
						.width(16.dp),
					strokeWidth = 2.dp,
					color = MaterialTheme.colors.primary
				)
			}
		}
	}
}

@ExperimentalMaterialApi@Composable
@Preview
private fun GooglePreview() {
	GoogleButton()
}