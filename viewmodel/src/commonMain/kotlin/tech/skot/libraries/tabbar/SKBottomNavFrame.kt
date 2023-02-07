package tech.skot.libraries.tabbar

import tech.skot.core.components.SKComponent
import tech.skot.core.components.SKFrame
import tech.skot.core.components.SKScreen
import tech.skot.libraries.tabbar.di.skTabbarViewInjector


class SKBottomNavFrame(
    addTabs: Boolean = true,
    val tabs: List<TabConf>,
    selectedTab: TabConf = tabs.first(),
) :
    SKComponent<SKBottomNavFrameVC>() {

    constructor(vararg tabs: TabConf) : this(true, tabs.toList())

    open class TabConf(
        val tab: SKTab<*>,
        val screen: SKScreen<*>?,
        val onReSelect: (() -> Unit)? = null,
    )

    companion object {
        fun tabWithStack(
            tab: SKTab<*>,
            rootScreen: () -> SKScreen<*>,
            recreateRootOnReselect: Boolean = true,
            onRootAndBackPressed: (() -> Unit)? = null,
        ): TabConf {
            val tabScreen = SKTabScreen(rootScreen(), onRootAndBackPressed)
            return TabConf(
                tab = tab,
                screen = tabScreen,
                onReSelect = if (recreateRootOnReselect) {
                    {
                        tabScreen.stack.content = rootScreen()
                    }
                } else {
                    {
                        tabScreen.stack.state.screens.firstOrNull()?.removeAllScreensOnTop()

                    }
                }

            )
        }
    }


    private val frame = SKFrame(
        screens = tabs.mapNotNull { it.screen }.toSet()
    )


    var selected: TabConf? = null
        set(value) {
            field = value
            tabs.forEach {
                it.tab.selected = it == value
            }
            frame.screen = value?.screen
        }

    init {
        tabs.forEach { tabConf ->
            if (tabConf.screen != null) {

                tabConf.tab.onSelect = {
                    if (selected == tabConf) {
                        tabConf.onReSelect?.invoke()
                    } else {
                        selected = tabConf
                    }
                }
            }
        }

        selected = selectedTab
    }

    override val view = skTabbarViewInjector.skBottomNavFrame(
        frame.view,
        tabs.map { it.tab.view },
        addTabs = addTabs
    )

}

