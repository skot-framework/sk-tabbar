package tech.skot.libraries.tabbar

import tech.skot.core.components.SKComponentViewMock
import tech.skot.core.view.Color
import tech.skot.core.view.Icon

class SKColorTabViewMock(
    override var icon: Icon,
    override var iconTint: Color,
    override var backgroundColor: Color,
    override var badge: Boolean,
    override val onTap: () -> Unit
) : SKComponentViewMock(), SKColorTabVC {

    fun userTap() {
        onTap.invoke()
    }
}

fun SKColorTabVC.userTap() {
    (this as SKSimpleTabViewMock).userTap()
}