package tech.skot.libraries.tabbar.di

import tech.skot.core.components.*
import tech.skot.core.di.BaseInjector
import tech.skot.core.di.module
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.BottomNavFrameViewProxy
import tech.skot.libraries.tabbar.SimpleTabViewProxy
import tech.skot.libraries.tabbar.TabScreenViewProxy

class TabbarViewInjectorImpl : TabbarViewInjector {
    override fun bottomNavFrame(frame: SKFrameVC, tabs: List<SKComponentVC>) =
        BottomNavFrameViewProxy(frame as SKFrameViewProxy, tabs as List<SKComponentViewProxy<*>>)

    override fun simpleTab(
        label: String,
        onTap: () -> Unit,
        iconInitial: Icon,
        labelColorInitial: Color,
        translateY:Boolean,
        centerTextInitial:String?
    ) = SimpleTabViewProxy(label, onTap, iconInitial, labelColorInitial, translateY, centerTextInitial)

    override fun tabScreen(visibilityListener:SKVisiblityListener, stack: SKStackVC) = TabScreenViewProxy(visibilityListener, stack as SKStackViewProxy)
}

val tabbarModule = module<BaseInjector> {
    single { TabbarViewInjectorImpl() as TabbarViewInjector }
}