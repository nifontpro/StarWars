package ru.nb.starwars.navigate

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.nb.starwars.R

@Composable
fun AboutScreen(paddingValues: PaddingValues) {
	Box(
		modifier = Modifier
			.padding(paddingValues)
			.fillMaxSize()
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 80.dp)
		) {
			Text(
				text = stringResource(R.string.test_work),
				style = MaterialTheme.typography.headlineLarge.copy(fontStyle = FontStyle.Italic),
				modifier = Modifier.align(Alignment.CenterHorizontally)
			)
		}

		Icon(
			imageVector = ImageVector.vectorResource(R.drawable.about),
			contentDescription = "",
			modifier = Modifier
				.align(Alignment.Center)
				.size(300.dp),
			tint = MaterialTheme.colorScheme.tertiary
		)

		BottomIcon(iconSize = 64.dp)
	}
}

@Composable
private fun BoxScope.BottomIcon(iconSize: Dp) {

	Row(
		modifier = Modifier
			.align(Alignment.BottomCenter)
			.fillMaxWidth()
			.padding(bottom = 80.dp)
			.padding(horizontal = 80.dp),
		horizontalArrangement = Arrangement.SpaceBetween,
	) {
		Image(
			imageVector = ImageVector.vectorResource(R.drawable.ic_kotlin_icon),
			contentDescription = "Kotlin",
			modifier = Modifier
				.size(iconSize)
		)
		Image(
			imageVector = ImageVector.vectorResource(R.drawable.ic_compose),
			contentDescription = "Compose",
			modifier = Modifier
				.size(iconSize)
		)
	}
}