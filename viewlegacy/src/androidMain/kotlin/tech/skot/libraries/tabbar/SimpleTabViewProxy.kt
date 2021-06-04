package tech.skot.libraries.tabbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.skot.core.components.SKActivity
import tech.skot.core.components.SKComponentViewProxy
import tech.skot.core.view.Color
import tech.skot.core.view.Icon
import tech.skot.libraries.tabbar.viewlegacy.R
import tech.skot.libraries.tabbar.viewlegacy.databinding.SimpleTabBinding
import tech.skot.view.live.MutableSKLiveData

class SimpleTabViewProxy(
        override val label: String,
        override val onTap: Function0<Unit>,
        iconInitial: Icon,
        labelColorInitial: Color,
        override val translateY: Boolean
) : SKComponentViewProxy<SimpleTabBinding>(), SimpleTabVC {
    private val iconLD: MutableSKLiveData<Icon> = MutableSKLiveData(iconInitial)

    override var icon: Icon by iconLD

    private val labelColorLD: MutableSKLiveData<Color> = MutableSKLiveData(labelColorInitial)

    override var labelColor: Color by labelColorLD

    override val layoutId: Int = R.layout.simple_tab

    override fun saveState() {
    }

    override fun bindingOf(view: View): SimpleTabBinding = SimpleTabBinding.bind(view)

    override fun inflate(
            layoutInflater: LayoutInflater,
            parent: ViewGroup?,
            attachToParent: Boolean
    ): SimpleTabBinding = SimpleTabBinding.inflate(layoutInflater, parent, attachToParent)
    override fun bindTo(
            activity: SKActivity,
            fragment: Fragment?,
            binding: SimpleTabBinding,
            collectingObservers: Boolean
    ): SimpleTabView = SimpleTabView(activity, fragment, binding).apply {
        collectObservers = collectingObservers
        onLabel(label)
        onOnTap(onTap)
        onTranslateY(translateY)
        iconLD.observe {
            onIcon(it)
        }
        labelColorLD.observe {
            onLabelColor(it)
        }
    }
}

interface SimpleTabRAI {
    fun onLabel(label: String)

    fun onOnTap(onTap: Function0<Unit>)

    fun onIcon(icon: Icon)

    fun onLabelColor(labelColor: Color)

    fun onTranslateY(value:Boolean)
}
