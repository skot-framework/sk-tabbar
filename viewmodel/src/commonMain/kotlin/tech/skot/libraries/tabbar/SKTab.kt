package tech.skot.libraries.tabbar

import tech.skot.core.components.SKComponent

abstract class SKTab<VC : SKTabVC>() : SKComponent<VC>() {
    abstract var selected: Boolean
    var onSelect: (() -> Unit)? = null

}