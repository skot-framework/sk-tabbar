package tech.skot.libraries.tabbar

import androidx.fragment.app.Fragment
import tech.skot.core.SKLog
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKComponentView
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.viewlegacy.R
import tech.skot.libraries.tabbar.viewlegacy.databinding.SimpleTabBinding
import tech.skot.view.extensions.setIcon
import tech.skot.view.extensions.setOnClick

class SimpleTabView(
    activity: SKActivity,
    fragment: Fragment?,
    binding: SimpleTabBinding
) : SKComponentView<SimpleTabBinding>(activity, fragment, binding), SimpleTabRAI {


    override fun onLabel(label: String) {
        binding.tvLabel.text = label
    }

    override fun onOnTap(onTap: () -> Unit) {
        binding.root.setOnClick(onTap)
    }

    override fun onLabelColor(labelColor: Color) {
        binding.tvLabel.setTextColor(labelColor)
    }

    override fun onIcon(icon: Icon) {
        binding.ivIcon.setIcon(icon)
    }

    override fun onTranslateY(value: Boolean) {
        if (value) {
            binding.ivIcon.translationY = context.resources.getDimensionPixelSize(R.dimen.tabbar_simple_tab_translate_y).toFloat()
        }
    }
}
