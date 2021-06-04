package tech.skot.libraries.tabbar

import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKScreenView
import tech.skot.libraries.tabbar.viewlegacy.databinding.TabScreenBinding

class TabScreenView(
    activity: SKActivity,
    fragment: Fragment?,
    binding: TabScreenBinding
) : SKScreenView<TabScreenBinding>(activity, fragment, binding)