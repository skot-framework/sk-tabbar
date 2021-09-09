package tech.skot.libraries.tabbar

import tech.skot.core.components.SKScreen
import tech.skot.core.components.SKStack
import tech.skot.libraries.tabbar.di.tabbarViewInjector

class TabScreen(initialScreen: SKScreen<*>):SKScreen<TabScreenVC>() {
    val stack = SKStack()
    init {
        stack.content = initialScreen
    }
    override val view = tabbarViewInjector.tabScreen(this, stack.view)
}