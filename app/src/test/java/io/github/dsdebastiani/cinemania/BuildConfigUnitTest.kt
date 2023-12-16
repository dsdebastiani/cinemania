package io.github.dsdebastiani.cinemania

import org.junit.Assert
import org.junit.Test

class BuildConfigUnitTest {
    @Test
    fun `has ApiKey defined`() {
        Assert.assertFalse(BuildConfig.TMDB_API_KEY.isEmpty())
    }
}
