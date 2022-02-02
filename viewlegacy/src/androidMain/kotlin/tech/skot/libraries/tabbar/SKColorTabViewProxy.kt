package tech.skot.libraries.tabbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKComponentView
import tech.skot.core.components.SKComponentViewProxy
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.viewlegacy.databinding.SkColorTabBinding
import tech.skot.view.live.MutableSKLiveData

class SKColorTabViewProxy(
    override val icon: Icon,
    iconTintInitial: Color,
    backgroundColorInitial: Color,
    badgeInitial:Boolean,
    override val onTap:()->Unit,
): SKComponentViewProxy<SkColorTabBinding>(), SKColorTabVC {


    private val iconTintLD = MutableSKLiveData(iconTintInitial)
    override var iconTint:Color by iconTintLD

    private val backgroundColorLD = MutableSKLiveData(backgroundColorInitial)
    override var backgroundColor:Color by backgroundColorLD

    private val badgeLD = MutableSKLiveData(badgeInitial)
    override var badge:Boolean by badgeLD


    override fun bindingOf(view: View): SkColorTabBinding {
        return SkColorTabBinding.bind(view)
    }
    override fun inflate(
        layoutInflater: LayoutInflater,
        parent: ViewGroup?,
        attachToParent: Boolean
    ) = SkColorTabBinding.inflate(layoutInflater, parent, attachToParent).also {
        it.root.tag = this.hashCode()
    }

    override fun bindTo(
        activity: SKActivity,
        fragment: Fragment?,
        binding: SkColorTabBinding
    ) = SKColorTabView(this, activity,  fragment, binding).apply {
        onIcon(icon)
        onOnTap(onTap)
        iconTintLD.observe {
            onIconTint(it)
        }
        backgroundColorLD.observe {
            onBackgroundColor(it)
        }
        badgeLD.observe {
            onBadge(it)
        }
    }

}