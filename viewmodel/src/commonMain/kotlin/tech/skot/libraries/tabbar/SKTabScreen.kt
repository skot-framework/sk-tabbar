package tech.skot.libraries.tabbar

import tech.skot.core.components.SKScreen
import tech.skot.core.components.SKStack
import tech.skot.libraries.tabbar.di.skTabbarViewInjector

class SKTabScreen(initialScreen: SKScreen<*>, onRootAndBackPressed: (() -> Unit)? = null) :
    SKScreen<SKTabScreenVC>() {
    val stack = SKStack()
    override val view = skTabbarViewInjector.skTabScreen(this, stack.view)

    init {
        stack.content = initialScreen
        view.onBackPressed = {
            if (stack.state.screens.size == 1) {
                onRootAndBackPressed?.invoke()
            }
        }
    }

}