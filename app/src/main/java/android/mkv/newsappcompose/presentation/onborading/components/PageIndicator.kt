package android.mkv.newsappcompose.presentation.onborading.components

import android.content.res.Configuration
import android.mkv.newsappcompose.presentation.Dimens.IndicatorSize
import android.mkv.newsappcompose.ui.theme.BlueGray
import android.mkv.newsappcompose.ui.theme.NewsAppComposeTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BlueGray
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .padding(horizontal = 1.dp)
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(if (page == selectedPage) selectedColor else unselectedColor)
            )
        }
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PageIndicatorPreview() {
    NewsAppComposeTheme {
        Surface {
            PageIndicator(pageSize = 5, selectedPage = 2)
        }
    }
}