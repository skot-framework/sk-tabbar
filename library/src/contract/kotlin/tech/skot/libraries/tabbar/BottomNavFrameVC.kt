package tech.skot.libraries.tabbar

import tech.skot.core.components.SKComponentVC
import tech.skot.core.components.SKFrameVC


interface BottomNavFrameVC: SKComponentVC {
    val frame:SKFrameVC
    val tabs:List<SKComponentVC>
}