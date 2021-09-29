package tech.skot.libraries.tabbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKScreenViewProxy
import tech.skot.core.components.SKStackViewProxy
import tech.skot.core.components.SKVisiblityListener
import tech.skot.libraries.tabbar.viewlegacy.R
import tech.skot.libraries.tabbar.viewlegacy.databinding.SkTabScreenBinding
import java.lang.IllegalStateException

class SKTabScreenViewProxy(override val visibilityListener: SKVisiblityListener, override val stack: SKStackViewProxy
) : SKScreenViewProxy<SkTabScreenBinding>(), SKTabScreenVC {
    override val layoutId: Int = R.layout.sk_tab_screen

    override fun saveState() {
        stack.saveState()
    }

    override fun getActivityClass() = throw IllegalStateException("This Screen must not be used as single screen")
    override fun bindingOf(view: View): SkTabScreenBinding = SkTabScreenBinding.bind(view)

    override fun inflate(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        attachToParent: Boolean
    ): SkTabScreenBinding = SkTabScreenBinding.inflate(layoutInflater, parent, attachToParent)
    override fun bindTo(
        activity: SKActivity,
        fragment: Fragment?,
        binding: SkTabScreenBinding,
        collectingObservers: Boolean
    ): SKTabScreenView = SKTabScreenView(this, activity, fragment, binding).apply {
        collectObservers = collectingObservers
        stack._bindTo(activity, fragment, binding.stack)
    }
}

