package tech.skot.libraries.tabbar.di

import tech.skot.core.components.*
import tech.skot.core.di.InjectorMock
import tech.skot.core.di.module
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.SKBottomNavFrameViewMock
import tech.skot.libraries.tabbar.SKColorTabViewMock
import tech.skot.libraries.tabbar.SKSimpleTabViewMock
import tech.skot.libraries.tabbar.SKTabScreenViewMock

class SKTabbarViewInjectorMock : SKTabbarViewInjector {
    override fun skBottomNavFrame(frame: SKFrameVC, tabs: List<SKComponentVC>, addTabs:Boolean) =
        SKBottomNavFrameViewMock(frame as SKFrameViewMock, tabs as List<SKComponentViewMock>, addTabs)

    override fun skSimpleTab(
        label: String,
        onTap: () -> Unit,
        iconInitial: Icon?,
        labelColorInitial: Color,
        translateY: Boolean,
        centerTextInitial: String?
    ) = SKSimpleTabViewMock(
        label,
        onTap,
        iconInitial,
        labelColorInitial,
        translateY,
        centerTextInitial
    )

    override fun skColorTab(
        icon: Icon,
        iconTintInitial: Color,
        backgroundColorInitial: Color,
        badgeInitial: Boolean,
        onTap: () -> Unit
    ) = SKColorTabViewMock(icon, iconTintInitial, backgroundColorInitial, badgeInitial, onTap)

    override fun skTabScreen(visibilityListener: SKVisiblityListener, stack: SKStackVC) =
        SKTabScreenViewMock(stack as SKStackViewMock)
}

val skTabbarModuleMock = module<InjectorMock> {
    single<SKTabbarViewInjector> { SKTabbarViewInjectorMock() }
}