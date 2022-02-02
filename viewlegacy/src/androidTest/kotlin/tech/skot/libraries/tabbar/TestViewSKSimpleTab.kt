package tech.skot.libraries.tabbar

import org.junit.Test
import tech.skot.core.components.SKBoxViewProxy
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.viewlegacy.test.R
import tech.skot.view.tests.SKTestView
import tech.skot.view.tests.testComponent

class TestViewSKSimpleTab: SKTestView() {


    @Test
    fun ui() {


        val tab1 = SKSimpleTabViewProxy(
            label = "tab1",
            iconInitial = Icon(R.drawable.ic_android_black_24dp),
            labelColorInitial = Color(android.R.color.black),
            onTap = toast("tap1")
        )
        val tab2 = SKSimpleTabViewProxy(
            label = "tab2",
            iconInitial = Icon(R.drawable.ic_android_black_24dp),
            labelColorInitial = Color(android.R.color.holo_red_dark),
            onTap = toast("tap2")
        )
        val tab3 = SKSimpleTabViewProxy(
            label = "tab3",
            iconInitial = Icon(R.drawable.ic_android_black_24dp),
            labelColorInitial = Color(android.R.color.black),
            onTap = toast("tap3"),
            centerTextInitial = "3"
        )
        val tab4 = SKSimpleTabViewProxy(
            label = "tab4",
            iconInitial = Icon(R.drawable.ic_android_black_24dp),
            labelColorInitial = Color(android.R.color.black),
            onTap = toast("tap4"),
            translateY = true
        )

        val box = dummyBox(
            tab1,
            tab2,
            tab3,
            tab4
        )

        testComponent(box)

    }


}