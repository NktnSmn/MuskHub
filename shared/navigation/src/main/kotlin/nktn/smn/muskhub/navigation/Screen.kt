package nktn.smn.muskhub.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

//TODO Начальный Route (deeplink) будет приходить в экран как аргумент, не забыть занулить после выполнения роута
//Второй вариант - в этом интерфейсе объявлять Router свойством, а хранить его в скоупе Koin-а, но это запутаннее
interface Screen {
    val screenKey: String
}

fun interface Creator<A, R> {
    fun create(argument: A): R
}

interface FragmentScreen : Screen {
    val clearContainer: Boolean get() = true
    fun createFragment(): Fragment

    companion object {
        operator fun invoke(
            key: String? = null,
            clearContainer: Boolean = true,
            fragmentCreator: () -> Fragment
        ) = object : FragmentScreen {
            override val screenKey = key ?: fragmentCreator::class.java.name
            override val clearContainer = clearContainer
            override fun createFragment() = fragmentCreator.invoke()
        }
    }
}

interface ActivityScreen : Screen {
    val startActivityOptions: Bundle? get() = null
    fun createIntent(context: Context): Intent

    companion object {
        operator fun invoke(
            key: String? = null,
            startActivityOptions: Bundle? = null,
            intentCreator: Creator<Context, Intent>
        ) = object : ActivityScreen {
            override val screenKey = key ?: intentCreator::class.java.name
            override val startActivityOptions = startActivityOptions
            override fun createIntent(context: Context) = intentCreator.create(context)
        }
    }
}