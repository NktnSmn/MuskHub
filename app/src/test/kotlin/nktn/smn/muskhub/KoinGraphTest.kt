package nktn.smn.muskhub

import android.os.Build
import io.mockk.mockkClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.koin.test.mock.MockProvider
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class KoinDiTest : KoinTest {

    companion object {

        @BeforeClass
        @JvmStatic
        fun setup() = MockProvider.register { clazz ->
            mockkClass(clazz)
        }
    }

    @Test
    fun `check koin graph`() = getKoin().checkModules()
}
