package tech.skot.libraries.tabbar

import tech.skot.core.components.SKScreenVC
import tech.skot.core.components.SKStackVC

interface SKTabScreenVC: SKScreenVC {
    val stack:SKStackVC
}