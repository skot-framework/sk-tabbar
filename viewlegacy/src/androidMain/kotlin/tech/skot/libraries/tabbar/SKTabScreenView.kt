package tech.skot.libraries.tabbar

import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKScreenView
import tech.skot.libraries.tabbar.viewlegacy.databinding.SkTabScreenBinding

class SKTabScreenView(
    override val proxy: SKTabScreenViewProxy,
    activity: SKActivity,
    fragment: Fragment?,
    binding: SkTabScreenBinding
) : SKScreenView<SkTabScreenBinding>(proxy, activity, fragment, binding)