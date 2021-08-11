package tech.skot.libraries.tabbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKScreenViewProxy
import tech.skot.core.components.SKStackViewProxy
import tech.skot.libraries.tabbar.viewlegacy.R
import tech.skot.libraries.tabbar.viewlegacy.databinding.TabScreenBinding
import java.lang.IllegalStateException

class TabScreenViewProxy(override val stack: SKStackViewProxy
) : SKScreenViewProxy<TabScreenBinding>(), TabScreenVC {
    override val layoutId: Int = R.layout.tab_screen

    override fun saveState() {
        stack.saveState()
    }

    override fun getActivityClass() = throw IllegalStateException("This Screen must not be used as single screen")
    override fun bindingOf(view: View): TabScreenBinding = TabScreenBinding.bind(view)

    override fun inflate(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        attachToParent: Boolean
    ): TabScreenBinding = TabScreenBinding.inflate(layoutInflater, parent, attachToParent)
    override fun bindTo(
        activity: SKActivity,
        fragment: Fragment?,
        binding: TabScreenBinding,
        collectingObservers: Boolean
    ): TabScreenView = TabScreenView(this, activity, fragment, binding).apply {
        collectObservers = collectingObservers
        stack._bindTo(activity, fragment, binding.stack)
    }
}

