# SK-Tabbar

un composant Skot pour gérer une barre d'onglets en bas de l'écran Pour l'instant seule la version
android "legacy" est disponible

## Utilisation

Pour utiliser la librairie vous devez ajouter la ligne suivante à votre fichier _skot_librairies.properties_ de votre app ou de votre feature

`com.github.skot-framework.sk-tabbar:0.0.1_1.0.0-alpha55,getSkTabbarModule`

dans le cas d'une feature vous devez également vous-même ajouter le module `getSkTabbarModule`
dans votre liste de modules

### ViewContract

ajouter le composant [BottomNavFrameVC](/documentation/gfm/viewcontract/viewcontract/tech.skot.libraries.tabbar/-bottom-nav-frame-v-c/index.md) à votre écran

```kotlin
interface MyScreenVC : SKScreenVC {
    val bottomNav: BottomNavFrameVC
    val loader: SKLoaderVC
}
```

### View Legacy

ajouter à votre layout l'include bottom_nav_frame

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent" android:background="@color/white">

    <include android:id="@+id/bottomNav" layout="@layout/bottom_nav_frame" />

    <include android:id="@+id/loader" layout="@layout/loader" />
</androidx.constraintlayout.widget.ConstraintLayout>
```


vous devez fournir des valeurs pour le theming :

(ici avec juste les valeurs par dafaut)

```xml
<item name="sk_tabbar_bottom_nav_frame_linear">@style/sk_tabbar_bottom_nav_frame_linear_default</item>
<item name="sk_tabbar_simpletab_label">@style/sk_tabbar_simpletab_label_default</item>
<item name="sk_tabbar_simpletab_tvcenter">@style/sk_tabbar_simpletab_tvcenter_default</item>
<item name="sk_tabbar_simpletab_ivicon">@style/sk_tabbar_simpletab_ivicon_default</item>
```

### ViewModel

le constructeur de [BottomNavFrame](/documentation/gfm/viewmodel/viewmodel/tech.skot.libraries.tabbar/-bottom-nav-frame/index.md) prend en paramètre des [BottomNavFrame.TabConf](/documentation/gfm/viewmodel/viewmodel/tech.skot.libraries.tabbar/-bottom-nav-frame/-tab-conf/index.md)

TabConf consiste en un [Tab](/documentation/gfm/viewmodel/viewmodel/tech.skot.libraries.tabbar/-tab/index.md) et un écran racine (nullable si il s'agit d'un faux onglet/bouton)

Vous pouvez ajouter une TabConf avec un Tab de votre fabrication,

la librairie fournie [SimpleTab](/documentation/gfm/viewmodel/viewmodel/tech.skot.libraries.tabbar/-simple-tab/index.md)

ou utiliser

[BottomNavFrame.tabWithStack](/documentation/gfm/viewmodel/viewmodel/tech.skot.libraries.tabbar/-bottom-nav-frame/-companion/tab-with-stack.md) qui va gérer une stack associée à l'onglet,

on lui passe un lambda de création de l'écran racine

Au tap sur le tab, si il est déjà sélectionné, la stack est réinitilisée (le lambda de création de
la racine est ré-appelé)

```kotlin
val tabEShop = BottomNavFrame.tabWithStack(
    tab = SimpleTab(
        label = strings.tabbar_Eshop,
        selectedIcon = icons.icn_tabb_eshop_on,
        unSelectedIcon = icons.icn_tabb_eshop_off,
        translateY = true
    ),
    rootScreen = { EShop() }
)

val basketTab = SimpleTab(
    label = strings.tabbar_Panier,
    unSelectedIcon = icons.icn_tabb_totebag_unselected
).apply {
    onSelect = {
        myActionOnTapBasket()
    }
}

val tabAccount = BottomNavFrame.tabWithStack(
    tab = SimpleTab(
        label = strings.tabbar_Compte,
        selectedIcon = icons.icn_tabb_compte_selected,
        unSelectedIcon = icons.icn_tabb_compte_unselected
    ),
    rootScreen = { Account() }
)



override val bottomNav: BottomNavFrame = BottomNavFrame(
    tabEShop,
    BottomNavFrame.TabConf(
        tab = basketTab,
        screen = null,
    ),
    tabAccount
)

```

[documentation](documentation/gfm/index.md)



