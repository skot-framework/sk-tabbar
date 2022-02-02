package tech.skot.libraries.tabbar

import tech.skot.core.view.Color
import tech.skot.core.view.Icon

interface SKColorTabVC: SKTabVC {
    val icon: Icon
    var iconTint:Color
    var backgroundColor:Color
    var badge:Boolean
    val onTap:()->Unit
}