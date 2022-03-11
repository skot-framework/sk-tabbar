package tech.skot.libraries.tabbar

import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKComponentView
import tech.skot.core.setImageTint
import tech.skot.core.setBackground
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.viewlegacy.databinding.SkColorTabBinding
import tech.skot.libraries.tabbar.viewlegacy.databinding.SkSimpleTabBinding
import tech.skot.view.extensions.setOnClick
import tech.skot.view.extensions.setVisible

class SKColorTabView(
    override val proxy: SKColorTabViewProxy,
    activity: SKActivity,
    fragment: Fragment?,
    binding: SkColorTabBinding
): SKComponentView<SkColorTabBinding>(proxy, activity, fragment, binding) {


    fun onIcon(icon: Icon) {
        binding.ivIcon.setImageResource(icon.res)
    }

    fun onOnTap(onTap:()->Unit) {
        binding.root.setOnClick(onTap)
    }

    fun onIconTint(iconTint: Color) {
        binding.ivIcon.setImageTint(iconTint)
    }

    fun onBackgroundColor(backgroundColor:Color) {
        binding.root.setBackground(backgroundColor)
    }

    fun onBadge(badge:Boolean) {
        binding.badge.setVisible(badge)
    }
}