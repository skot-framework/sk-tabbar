package tech.skot.libraries.tabbar.di

import tech.skot.core.components.SKComponentVC
import tech.skot.core.components.SKFrameVC
import tech.skot.core.components.SKStackVC
import tech.skot.core.components.SKVisiblityListener
import tech.skot.core.di.get
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.SKBottomNavFrameVC
import tech.skot.libraries.tabbar.SKSimpleTabVC
import tech.skot.libraries.tabbar.SKTabScreenVC

interface TabbarViewInjector {
    fun skBottomNavFrame(frame: SKFrameVC, tabs: List<SKComponentVC>): SKBottomNavFrameVC
    fun skSimpleTab(
        label: String,
        onTap: Function0<Unit>,
        iconInitial: Icon,
        labelColorInitial: Color,
        translateY:Boolean,
        centerTextInitial:String?
    ): SKSimpleTabVC
    fun skTabScreen(visibilityListener:SKVisiblityListener, stack: SKStackVC): SKTabScreenVC
}

val tabbarViewInjector: TabbarViewInjector = get()