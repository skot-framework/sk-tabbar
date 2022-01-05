package tech.skot.libraries.tabbar

import tech.skot.core.components.SKComponentVC
import tech.skot.core.components.SKComponentViewMock
import tech.skot.core.components.SKFrameVC

class SKBottomNavFrameViewMock(
        override val frame: SKFrameVC, override val tabs: List<SKComponentVC>
) : SKComponentViewMock(), SKBottomNavFrameVC