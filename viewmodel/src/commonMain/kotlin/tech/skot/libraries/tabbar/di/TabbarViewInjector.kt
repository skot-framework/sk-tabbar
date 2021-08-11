package tech.skot.libraries.tabbar.di

import tech.skot.core.components.SKComponentVC
import tech.skot.core.components.SKFrameVC
import tech.skot.core.components.SKStackVC
import tech.skot.core.di.get
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.BottomNavFrameVC
import tech.skot.libraries.tabbar.SimpleTabVC
import tech.skot.libraries.tabbar.TabScreenVC

interface TabbarViewInjector {
    fun bottomNavFrame(frame: SKFrameVC, tabs: List<SKComponentVC>): BottomNavFrameVC
    fun simpleTab(
        label: String,
        onTap: Function0<Unit>,
        iconInitial: Icon,
        labelColorInitial: Color,
        translateY:Boolean,
        centerTextInitial:String?
    ): SimpleTabVC
    fun tabScreen(stack: SKStackVC): TabScreenVC
}

val tabbarViewInjector: TabbarViewInjector = get()