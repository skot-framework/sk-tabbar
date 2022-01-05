package tech.skot.libraries.tabbar

import tech.skot.core.components.SKComponentViewMock
import tech.skot.core.view.Color
import tech.skot.core.view.Icon

class SKSimpleTabViewMock(
        override val label: String,
        override val onTap: Function0<Unit>,
        iconInitial: Icon,
        labelColorInitial: Color,
        override val translateY:Boolean,
        centerTextInitial:String?
): SKComponentViewMock(), SKSimpleTabVC {
    override var icon: Icon = iconInitial
    override var labelColor: Color = labelColorInitial
    override var centerText: String? = centerTextInitial

    fun userTap() {
        onTap.invoke()
    }

    data class AnimateIconCall(val newVal: String, val onEnd: () -> Unit)

    val animateIcons: MutableList<AnimateIconCall> = mutableListOf()
    override fun animateIcon(newVal: String, onEnd: () -> Unit) {
        animateIcons.add(AnimateIconCall(newVal, onEnd))
    }
}

fun SKSimpleTabVC.userTap() {
    (this as SKSimpleTabViewMock).userTap()
}