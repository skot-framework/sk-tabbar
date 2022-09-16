package tech.skot.libraries.tabbar

import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.di.skTabbarViewInjector

class SKSimpleTab(
    val label: String,
    val selectedIcon: Icon? = null,
    val unSelectedIcon: Icon?,
    val selectedColor: Color? = null,
    val unSelectedColor: Color,
    translateY: Boolean = false,
    val onTapped: (()->Unit)? = null
) : SKTab<SKSimpleTabVC>() {

    override var selected: Boolean = false
        set(value) {
            field = value
            if (value) {
                view.icon = selectedIcon ?: unSelectedIcon
                view.labelColor = selectedColor ?: unSelectedColor
            } else {
                view.icon = unSelectedIcon
                view.labelColor = unSelectedColor
            }

        }

    override val view: SKSimpleTabVC = skTabbarViewInjector.skSimpleTab(
        label = label,
        iconInitial = unSelectedIcon,
        labelColorInitial = unSelectedColor,
        onTap = {
            onSelect?.invoke()
            onTapped?.invoke()
        },
        translateY = translateY,
        centerTextInitial = null
    )


}