//[viewmodel](../../../index.md)/[tech.skot.libraries.tabbar](../index.md)/[BottomNavFrame](index.md)

# BottomNavFrame

[common]\
class [BottomNavFrame](index.md)(tabs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[BottomNavFrame.TabConf](-tab-conf/index.md)&gt;, selectedTab: [BottomNavFrame.TabConf](-tab-conf/index.md)) : SKComponent&lt;[BottomNavFrameVC](../../../../viewcontract/viewcontract/tech.skot.libraries.tabbar/-bottom-nav-frame-v-c/index.md)&gt;

## Constructors

| | |
|---|---|
| [BottomNavFrame](-bottom-nav-frame.md) | [common]<br>fun [BottomNavFrame](-bottom-nav-frame.md)(vararg tabs: [BottomNavFrame.TabConf](-tab-conf/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [TabConf](-tab-conf/index.md) | [common]<br>open class [TabConf](-tab-conf/index.md)(tab: [Tab](../-tab/index.md)&lt;*&gt;, screen: SKScreen&lt;*&gt;?, onReSelect: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [selected](selected.md) | [common]<br>var [selected](selected.md): [BottomNavFrame.TabConf](-tab-conf/index.md)? = null |
| [tabs](tabs.md) | [common]<br>val [tabs](tabs.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[BottomNavFrame.TabConf](-tab-conf/index.md)&gt; |
| [view](view.md) | [common]<br>open override val [view](view.md): [BottomNavFrameVC](../../../../viewcontract/viewcontract/tech.skot.libraries.tabbar/-bottom-nav-frame-v-c/index.md) |
