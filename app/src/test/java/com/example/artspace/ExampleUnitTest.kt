package com.example.artspace

import junit.framework.TestCase.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun displayArtwork_pageNumber1() {
        val expectedArtwork = Artwork(
            artworkImage = R.drawable.scene_1,
            artworkImageContentDesc = R.string.content_desc_scene_1,
            artworkTitle = R.string.artwork_title_1,
            artworkArtist = R.string.artwork_artist_1,
            artworkYear = R.string.artwork_year_1
        )
        val actualArtwork = showArtwork(1)
        assertEquals(expectedArtwork, actualArtwork)
    }

    @Test
    fun displayArtwork_pageNumber2() {
        val expectedArtwork = Artwork(
            artworkImage = R.drawable.scene_2,
            artworkImageContentDesc = R.string.content_desc_scene_2,
            artworkTitle = R.string.artwork_title_2,
            artworkArtist = R.string.artwork_artist_2,
            artworkYear = R.string.artwork_year_2
        )
        val actualArtwork = showArtwork(2)
        assertEquals(expectedArtwork, actualArtwork)
    }

    @Test
    fun displayArtwork_pageNumber3() {
        val expectedArtwork = Artwork(
            artworkImage = R.drawable.scene_3,
            artworkImageContentDesc = R.string.content_desc_scene_3,
            artworkTitle = R.string.artwork_title_3,
            artworkArtist = R.string.artwork_artist_3,
            artworkYear = R.string.artwork_year_3
        )
        val actualArtwork = showArtwork(3)
        assertEquals(expectedArtwork, actualArtwork)
    }

    @Test
    fun displayArtwork_pageNumber4() {
        val expectedArtwork = Artwork(
            artworkImage = R.drawable.scene_4,
            artworkImageContentDesc = R.string.content_desc_scene_4,
            artworkTitle = R.string.artwork_title_4,
            artworkArtist = R.string.artwork_artist_4,
            artworkYear = R.string.artwork_year_4
        )
        val actualArtwork = showArtwork(4)
        assertEquals(expectedArtwork, actualArtwork)
    }
}