//[viewmodel](../../../index.md)/[tech.skot.libraries.tabbar.di](../index.md)/[TabbarViewInjector](index.md)

# TabbarViewInjector

[common]\
interface [TabbarViewInjector](index.md)

## Functions

| Name | Summary |
|---|---|
| [bottomNavFrame](bottom-nav-frame.md) | [common]<br>abstract fun [bottomNavFrame](bottom-nav-frame.md)(frame: SKFrameVC, tabs: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;SKComponentVC&gt;): [BottomNavFrameVC](../../../../viewcontract/viewcontract/tech.skot.libraries.tabbar/-bottom-nav-frame-v-c/index.md) |
| [simpleTab](simple-tab.md) | [common]<br>abstract fun [simpleTab](simple-tab.md)(label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onTap: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), iconInitial: Icon, labelColorInitial: Color, translateY: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), centerTextInitial: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [SimpleTabVC](../../../../viewcontract/viewcontract/tech.skot.libraries.tabbar/-simple-tab-v-c/index.md) |
| [tabScreen](tab-screen.md) | [common]<br>abstract fun [tabScreen](tab-screen.md)(visibilityListener: SKVisiblityListener, stack: SKStackVC): [TabScreenVC](../../../../viewcontract/viewcontract/tech.skot.libraries.tabbar/-tab-screen-v-c/index.md) |
