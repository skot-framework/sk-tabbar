package tech.skot.libraries.tabbar

import tech.skot.core.components.SKComponent

abstract class Tab<VC : TabVC>() : SKComponent<VC>() {
    abstract var selected: Boolean
    var onSelect: (() -> Unit)? = null

}