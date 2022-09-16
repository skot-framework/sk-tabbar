package tech.skot.libraries.tabbar

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.util.TypedValue
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKComponentView
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.viewlegacy.R
import tech.skot.libraries.tabbar.viewlegacy.databinding.SkSimpleTabBinding
import tech.skot.view.extensions.setIcon
import tech.skot.view.extensions.setOnClick

class SKSimpleTabView(
    override val proxy: SKSimpleTabViewProxy,
    activity: SKActivity,
    fragment: Fragment?,
    binding: SkSimpleTabBinding
) : SKComponentView<SkSimpleTabBinding>(proxy, activity, fragment, binding), SimpleTabRAI {


    override fun onLabel(label: String) {
        binding.tvLabel.text = label
    }

    override fun onOnTap(onTap: () -> Unit) {
        binding.root.setOnClick(onTap)
    }

    override fun onLabelColor(labelColor: Color) {
        binding.tvLabel.setTextColor(labelColor)
    }

    override fun onIcon(icon: Icon?) {
        icon?.let { binding.ivIcon.setIcon(it) } ?: run { binding.ivIcon.setImageDrawable(null) }

    }

    override fun onTranslateY(value: Boolean) {
        if (value) {
            binding.ivIcon.translationY = context.resources.getDimensionPixelSize(R.dimen.tabbar_simple_tab_translate_y).toFloat()
        }
    }

    init {
        binding.tvCenter.setFactory {
            TextView(activity).apply {
                setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10f)
                setTextColor(proxy.labelColor)
            }
        }
    }

    override fun onCenterText(centerText: String?) {
        binding.tvCenter.setCurrentText(centerText)
    }

    private val ANIMATION_DURATION = 500L

    override fun animateIcon(newVal: String, onEnd: () -> Unit) {
        binding.tvCenter.apply {
            inAnimation = AnimationUtils.loadAnimation(context, R.anim.in_from_bottom).apply { duration = ANIMATION_DURATION }
            outAnimation = AnimationUtils.loadAnimation(context, R.anim.out_to_top).apply { duration = ANIMATION_DURATION }
            setText(newVal)
        }
        AnimatorSet().apply {
            play(ObjectAnimator.ofFloat(binding.ivIcon, "scaleX", 1f, 1.5f, 1f).apply { duration = ANIMATION_DURATION })
                .with(ObjectAnimator.ofFloat(binding.ivIcon, "scaleY", 1f, 1.5f, 1f).apply { duration = ANIMATION_DURATION })
            addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(p0: Animator?) {
                    // nu
                }

                override fun onAnimationEnd(p0: Animator?) {
                    binding.tvCenter.apply {
                        inAnimation = null
                        outAnimation = null
                    }
                    onEnd()
                }

                override fun onAnimationCancel(p0: Animator?) {
                    // nu
                }

                override fun onAnimationRepeat(p0: Animator?) {
                    // nu
                }
            })
            start()
        }
    }
}
