//[viewmodel](../../index.md)/[tech.skot.libraries.tabbar](index.md)

# Package tech.skot.libraries.tabbar

## Types

| Name | Summary |
|---|---|
| [BottomNavFrame](-bottom-nav-frame/index.md) | [common]<br>class [BottomNavFrame](-bottom-nav-frame/index.md)(tabs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[BottomNavFrame.TabConf](-bottom-nav-frame/-tab-conf/index.md)&gt;, selectedTab: [BottomNavFrame.TabConf](-bottom-nav-frame/-tab-conf/index.md)) : SKComponent&lt;[BottomNavFrameVC](../../../viewcontract/viewcontract/tech.skot.libraries.tabbar/-bottom-nav-frame-v-c/index.md)&gt; |
| [SimpleTab](-simple-tab/index.md) | [common]<br>class [SimpleTab](-simple-tab/index.md)(label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), selectedIcon: Icon?, unSelectedIcon: Icon, translateY: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) : [Tab](-tab/index.md)&lt;[SimpleTabVC](../../../viewcontract/viewcontract/tech.skot.libraries.tabbar/-simple-tab-v-c/index.md)&gt; |
| [Tab](-tab/index.md) | [common]<br>abstract class [Tab](-tab/index.md)&lt;[VC](-tab/index.md) : [TabVC](../../../viewcontract/viewcontract/tech.skot.libraries.tabbar/-tab-v-c/index.md)&gt; : SKComponent&lt;[VC](-tab/index.md)&gt; |
| [TabScreen](-tab-screen/index.md) | [common]<br>class [TabScreen](-tab-screen/index.md)(initialScreen: SKScreen&lt;*&gt;) : SKScreen&lt;[TabScreenVC](../../../viewcontract/viewcontract/tech.skot.libraries.tabbar/-tab-screen-v-c/index.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [simpleTabSelectedColor](simple-tab-selected-color.md) | [common, android]<br>val [simpleTabSelectedColor](simple-tab-selected-color.md): Color |
| [simpleTabUnSelectedColor](simple-tab-un-selected-color.md) | [common, android]<br>val [simpleTabUnSelectedColor](simple-tab-un-selected-color.md): Color |
