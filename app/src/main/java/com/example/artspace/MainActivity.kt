package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    ArtSpaceLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    var currentPageNumber by remember { mutableIntStateOf(1) }

    val artwork = showArtwork(currentPageNumber)

    Surface(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
                .statusBarsPadding()
                .verticalScroll(rememberScrollState())
                .safeDrawingPadding()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1F)
            ) {
                Image(
                    painter = painterResource(artwork.artworkImage),
                    contentDescription = stringResource(artwork.artworkImageContentDesc),
                    modifier = Modifier.padding(16.dp)
                )
                ArtworkDescriptionTexts(
                    artwork.artworkTitle,
                    artwork.artworkArtist,
                    artwork.artworkYear,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(150.dp)
            )
            PreviousNextButtons(
                clickPrevious = {
                    if (currentPageNumber != 1) {
                        currentPageNumber--
                    } else currentPageNumber = 4
                },
                clickNext = {
                    if (currentPageNumber != 4) {
                        currentPageNumber++
                    } else currentPageNumber = 1
                },
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

@Composable
fun ArtworkDescriptionTexts(
    @StringRes artworkTitle: Int,
    @StringRes artworkArtist: Int,
    @StringRes artworkYear: Int,
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
        Text(
            text = stringResource(artworkTitle),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
        val artworkTitleAndYear = buildAnnotatedString {
            append(stringResource(artworkArtist))
            append(" ")
            withStyle(style = TextStyle(fontStyle = FontStyle.Italic).toSpanStyle()) {
                append(stringResource(artworkYear))
            }
        }
        Text(
            text = artworkTitleAndYear,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
    }
}

@Composable
fun PreviousNextButtons(
    clickPrevious: () -> Unit, clickNext: () -> Unit, modifier: Modifier = Modifier
) {
    Row(modifier = Modifier) {
        Button(onClick = clickPrevious, modifier = Modifier.width(152.dp)) {
            Text(text = stringResource(R.string.previous))
        }
        Spacer(
            modifier = Modifier
                .width(20.dp)
                .weight(1F)
        )
        Button(onClick = clickNext, modifier = Modifier.width(152.dp)) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@VisibleForTesting
internal fun showArtwork(currentPageNumber: Int): Artwork {
    return when (currentPageNumber) {
        1 -> {
            Artwork(
                artworkImage = R.drawable.scene_1,
                artworkImageContentDesc = R.string.content_desc_scene_1,
                artworkTitle = R.string.artwork_title_1,
                artworkArtist = R.string.artwork_artist_1,
                artworkYear = R.string.artwork_year_1
            )
        }

        2 -> {
            Artwork(
                artworkImage = R.drawable.scene_2,
                artworkImageContentDesc = R.string.content_desc_scene_2,
                artworkTitle = R.string.artwork_title_2,
                artworkArtist = R.string.artwork_artist_2,
                artworkYear = R.string.artwork_year_2
            )
        }

        3 -> {
            Artwork(
                artworkImage = R.drawable.scene_3,
                artworkImageContentDesc = R.string.content_desc_scene_3,
                artworkTitle = R.string.artwork_title_3,
                artworkArtist = R.string.artwork_artist_3,
                artworkYear = R.string.artwork_year_3
            )

        }

        else -> {
            Artwork(
                artworkImage = R.drawable.scene_4,
                artworkImageContentDesc = R.string.content_desc_scene_4,
                artworkTitle = R.string.artwork_title_4,
                artworkArtist = R.string.artwork_artist_4,
                artworkYear = R.string.artwork_year_4
            )
        }
    }
}

@VisibleForTesting
internal data class Artwork(
    @DrawableRes var artworkImage: Int,
    @StringRes var artworkImageContentDesc: Int,
    @StringRes var artworkTitle: Int,
    @StringRes var artworkArtist: Int,
    @StringRes var artworkYear: Int
)

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}