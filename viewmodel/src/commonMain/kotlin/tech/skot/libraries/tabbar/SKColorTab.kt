package tech.skot.libraries.tabbar

import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.di.skTabbarViewInjector

class SKColorTab(
    icon: Icon,
    val iconSelectedColor: Color,
    val iconUnSelectedColor: Color,
    val backgroundSelectedColor: Color,
    val backgroundUnSelectedColor: Color,
    selectedInitial: Boolean = false,
    badgeInitial: Boolean = false
) : SKTab<SKColorTabVC>() {


    override var selected: Boolean = selectedInitial
        set(value) {
            field = value
            if (value) {
                view.iconTint = iconSelectedColor
                view.backgroundColor = backgroundSelectedColor
            } else {
                view.iconTint = iconUnSelectedColor
                view.backgroundColor = backgroundUnSelectedColor
            }

        }


    var badge: Boolean
        get() = view.badge
        set(value) {
            view.badge = value
        }

    override val view = skTabbarViewInjector.skColorTab(
        icon = icon,
        iconTintInitial = if (selectedInitial) iconSelectedColor else iconUnSelectedColor,
        backgroundColorInitial = if (selectedInitial) backgroundSelectedColor else backgroundUnSelectedColor,
        badgeInitial = badgeInitial,
        onTap = {
            onSelect?.invoke()
        }
    )
}