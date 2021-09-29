package tech.skot.libraries.tabbar

import tech.skot.core.components.SKScreen
import tech.skot.core.components.SKStack
import tech.skot.libraries.tabbar.di.tabbarViewInjector

class SKTabScreen(initialScreen: SKScreen<*>):SKScreen<SKTabScreenVC>() {
    val stack = SKStack()
    init {
        stack.content = initialScreen
    }
    override val view = tabbarViewInjector.skTabScreen(this, stack.view)
}