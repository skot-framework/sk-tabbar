package tech.skot.libraries.tabbar

import android.view.View
import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKComponentView
import tech.skot.core.components.SKComponentViewProxy
import tech.skot.core.components.SKFrameViewProxy
import tech.skot.libraries.tabbar.viewlegacy.databinding.BottomNavFrameBinding

class BottomNavFrameViewProxy(
        override val frame: SKFrameViewProxy,
        override val tabs:List<SKComponentViewProxy<*>>

):SKComponentViewProxy<BottomNavFrameBinding>(), BottomNavFrameVC {


    override fun bindingOf(view: View) = BottomNavFrameBinding.bind(view)

    override fun bindTo(activity: SKActivity, fragment: Fragment?, binding: BottomNavFrameBinding, collectingObservers: Boolean): SKComponentView<BottomNavFrameBinding> {
        frame._bindTo(activity, fragment, binding.frame)
        tabs.forEach {
            it.inflateInParentAndBind(activity, fragment,binding.tabbar)
        }
        return BottomNavFrameView(activity, fragment, binding)
    }



}