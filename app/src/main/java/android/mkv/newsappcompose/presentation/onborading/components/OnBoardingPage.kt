package android.mkv.newsappcompose.presentation.onborading.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.mkv.newsappcompose.R
import android.mkv.newsappcompose.presentation.Dimens.MediumPadding1
import android.mkv.newsappcompose.presentation.Dimens.MediumPadding2
import android.mkv.newsappcompose.presentation.onborading.Page
import android.mkv.newsappcompose.presentation.onborading.pages
import android.mkv.newsappcompose.ui.theme.NewsAppComposeTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier, page: Page
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = page.image),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.Bold
            ),
            color = colorResource(id = R.color.display_small)
        )

        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = MediumPadding2, vertical = 10.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )

    }
}


@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingPagePreview() {
    NewsAppComposeTheme {
        Surface {
            OnBoardingPage(
                modifier = Modifier, page = pages[0]
            )
        }

    }

}