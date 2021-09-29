package tech.skot.libraries.tabbar.di

import tech.skot.core.components.*
import tech.skot.core.di.BaseInjector
import tech.skot.core.di.module
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.SKBottomNavFrameViewProxy
import tech.skot.libraries.tabbar.SKSimpleTabViewProxy
import tech.skot.libraries.tabbar.SKTabScreenViewProxy

class SKTabbarViewInjectorImpl : SKTabbarViewInjector {
    override fun skBottomNavFrame(frame: SKFrameVC, tabs: List<SKComponentVC>) =
        SKBottomNavFrameViewProxy(frame as SKFrameViewProxy, tabs as List<SKComponentViewProxy<*>>)

    override fun skSimpleTab(
        label: String,
        onTap: () -> Unit,
        iconInitial: Icon,
        labelColorInitial: Color,
        translateY:Boolean,
        centerTextInitial:String?
    ) = SKSimpleTabViewProxy(label, onTap, iconInitial, labelColorInitial, translateY, centerTextInitial)

    override fun skTabScreen(visibilityListener:SKVisiblityListener, stack: SKStackVC) = SKTabScreenViewProxy(visibilityListener, stack as SKStackViewProxy)
}

val skTabbarModule = module<BaseInjector> {
    single { SKTabbarViewInjectorImpl() as SKTabbarViewInjector }
}