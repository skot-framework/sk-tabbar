package tech.skot.libraries.tabbar

import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.di.tabbarViewInjector

class SimpleTab(val label: String, val selectedIcon: Icon? = null, val unSelectedIcon: Icon, translateY:Boolean = false) : Tab<SimpleTabVC>() {

    override var selected: Boolean = false
        set(value) {
            field = value
            if (value) {
                view.icon = selectedIcon ?: unSelectedIcon
                view.labelColor = simpleTabSelectedColor
            } else {
                view.icon = unSelectedIcon
                view.labelColor = simpleTabUnSelectedColor
            }

        }

    override val view: SimpleTabVC = tabbarViewInjector.simpleTab(label = label, iconInitial = unSelectedIcon, labelColorInitial = simpleTabUnSelectedColor, onTap = {
        onSelect?.invoke()
    }, translateY = translateY)


}