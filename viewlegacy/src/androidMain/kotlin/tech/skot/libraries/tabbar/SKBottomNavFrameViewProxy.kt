package tech.skot.libraries.tabbar

import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKComponentView
import tech.skot.core.components.SKComponentViewProxy
import tech.skot.core.components.SKFrameViewProxy
import tech.skot.libraries.tabbar.viewlegacy.databinding.SkBottomNavFrameBinding

class SKBottomNavFrameViewProxy(
        override val frame: SKFrameViewProxy,
        override val tabs:List<SKComponentViewProxy<*>>,
        override val addTabs:Boolean = true

):SKComponentViewProxy<SkBottomNavFrameBinding>(), SKBottomNavFrameVC {


    override fun bindingOf(view: View) = SkBottomNavFrameBinding.bind(view)

    override fun bindTo(activity: SKActivity, fragment: Fragment?, binding: SkBottomNavFrameBinding): SKComponentView<SkBottomNavFrameBinding> {
        frame._bindTo(activity, fragment, binding.frame)
        return SKBottomNavFrameView(this, activity, fragment, binding).also {
            if (addTabs) {
                tabs.forEach {
                    it.inflateInParentAndBind(activity, fragment,binding.tabbar)
                }
            }
        }
    }



}