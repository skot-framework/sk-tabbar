package tech.skot.libraries.tabbar

import org.junit.Test
import tech.skot.core.components.SKBoxViewProxy
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.viewlegacy.test.R
import tech.skot.view.tests.SKTestView
import tech.skot.view.tests.testComponent

class TestViewSKColorTab: SKTestView() {


    @Test
    fun ui() {

        fun getTab() = SKColorTabViewProxy(
            icon = Icon(R.drawable.ic_android_black_24dp),
            iconTintInitial = Color(android.R.color.black),
            backgroundColorInitial = Color(android.R.color.white),
            badgeInitial = false,
            onTap = toast("tap")
        )
        val tab1 = getTab()
        val tab2 = getTab().apply {
            backgroundColor = Color(android.R.color.holo_red_dark)
        }
        val tab3 = getTab()
        val tab4 = getTab().apply {
            badge = true
        }

        val box = dummyBox(
            tab1,
            tab2,
            tab3,
            tab4
        )

        testComponent(box)

    }


}