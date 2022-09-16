package tech.skot.libraries.tabbar

import tech.skot.core.view.Color
import tech.skot.core.view.Icon

interface SKSimpleTabVC: SKTabVC {
    val onTap:()->Unit
    val label:String
    var icon: Icon?
    var labelColor: Color
    val translateY:Boolean

    var centerText: String?
    fun animateIcon(newVal: String, onEnd: () -> Unit)
}