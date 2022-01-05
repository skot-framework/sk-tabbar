package tech.skot.libraries.tabbar

import tech.skot.core.components.*

class SKTabScreenViewMock(stack: SKStackVC): SKScreenViewMock(), SKTabScreenVC {
    override val stack = stack
}