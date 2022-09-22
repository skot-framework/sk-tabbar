package tech.skot.libraries.tabbar

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKComponentView
import tech.skot.core.components.SKComponentViewProxy
import tech.skot.core.components.SKFrameViewProxy
import tech.skot.libraries.tabbar.viewlegacy.databinding.SkBottomNavFrameBinding

class SKBottomNavFrameViewProxy(
        override val frame: SKFrameViewProxy,
        override val tabs:List<SKComponentViewProxy<*>>,
        override val addTabs:Boolean = true

):SKComponentViewProxy<View>(), SKBottomNavFrameVC {


    override fun bindTo(activity: SKActivity, fragment: Fragment?, binding: View): SKComponentView<View> {

        val frameView = binding.findViewWithTag<FrameLayout>("sk_tabbar_frame")
        val tabbarView = binding.findViewWithTag<ViewGroup>("sk_tabbar_tabbar")
        frame._bindTo(activity, fragment, frameView)
        return SKBottomNavFrameView(this, activity, fragment, binding).also {
            if (addTabs) {
                tabs.forEach {
                    it.inflateInParentAndBind(activity, fragment,tabbarView)
                }
            }
        }
    }



}