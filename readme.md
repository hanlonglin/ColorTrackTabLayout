# 仿今日头条渐变文字指示器



## 演示：

#### 1. 渐变文字（<kbd>ColorTrackView</kbd>）

![渐变文字](/gif/colorTrackView1.gif)

#### 2. 仿今日头条(滑动模式)(<kbd>ColorTrackTabLayout</kbd>)

![滑动模式](/gif/colorTrackTablayout1.gif)

#### 3. 仿今日头条（填充模式）(<kbd>ColorTrackTabLayout</kbd>)

![填充模式](/gif/colorTrackTabLayout2.gif)

## 使用

### Dependencies:

####  **Step 1.** Add the JitPack repository to your build file 

```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

```css
	}
```

#### **Step 2.** Add the dependency

```groovy
dependencies {
	        implementation 'com.github.hanlonglin:ColorTrackTabLayout:${releaseVersion}'
}
```



### Code:


####  **Step 1.**  write the ColorTrackLayout in xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout 					      xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".demo.TabScrollModeDemo">

     <com.dragonforest.tablayoutlib.tablayout.ColorTrackTabLayout
        android:id="@+id/ct_tablayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:ct_startScrollX="100dp"
        app:ct_tabMode="scroll"
        app:ct_tabPadding="10dp"
        app:ct_tabSelectScale="1.15"
        app:ct_tabSelectTextColor="#ff0000"
        app:ct_tabTextColor="#363636"
        app:ct_tabTextSize="18sp"
        app:ct_tabForeground="@drawable/ripper_colortrackitem"/>

    <androidx.viewpager.widget.ViewPager
        android:id="@+id/viewpager"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constrainedHeight="true"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/ct_tablayout" />

</androidx.constraintlayout.widget.ConstraintLayout>
```



#### **Step 2**. build  your own PageAdapter, here is mine:

```kotlin
class TabPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    var fgs: MutableList<Fragment> = mutableListOf()
    var titles: MutableList<String> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return fgs.get(position)
    }

    override fun getCount(): Int {
        return fgs.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles.get(position)
    }
}
```


#### **Step 3**. put data to your pageAdapter,and set the adapter to ViewPager

```kotlin
var pagerAdapter =
            TabPagerAdapter(supportFragmentManager)
pagerAdapter.fgs = getFragments()
pagerAdapter.titles = getTitles()
viewpager.adapter = pagerAdapter
```



#### **Step 4**. set viewPager to the ColorTrackTabLayout

```kotlin
ct_tablayout.setUpWithViewPager(viewpager)
```

ok, done



## 属性说明

### ColorTrackView

- 颜色渐变的TextView

| 属性                      | 说明                                                         |
| ------------------------- | ------------------------------------------------------------ |
| app:ct_changeColor="#ff0000" | 滑动时渐变的颜色，默认为红色                                 |
| app:ct_progress="0.5"        | 滑动进度，0~1向右滑动 0~-1向左滑动。0为初始状态，1为向右最终状态，-1为向左最终状态 |



### ColorTrackTabLayout

- 仿今日头条文字颜色渐变的TabLayout

| 属性                                                | 说明                                                         |
| --------------------------------------------------- | ------------------------------------------------------------ |
| app:ct_tabTextColor="@android:color/darker_gray"       | tab未选中文字颜色                                            |
| app:ct_tabSelectTextColor="#8A2BE2"                    | tab选中文字的颜色                                            |
| app:ct_tabTextSize="18sp"                              | tab文字大小                                                  |
| app:ct_tabSelectScale="1.1"                            | tab选中文字缩放值，默认为1（即不缩放）                       |
| app:ct_tabPadding="10dp"                               | tab文字的左右内间距                                          |
| app:ct_tabMode="fill"                                  | tab排列模式。fill模式：所有tab铺满整个屏幕，平均占据；scroll模式：所有tab大小由自身决定，从左向右可滑动 |
| app:ct_startScrollX="100dp"                            | tab开始滑动的距离。当viewPager滑动超过此值时，整个tabLayout开始自动滑动 |
| app:ct_tabForeground="@drawable/ripper_colortrackitem" | tab的前景图，可设置点击的前景。比如水波纹（当然，这需要api>=23） |



## 结尾

- 起初看到这个效果觉得不错，出于好奇于是自己撸了。用在项目中也是不错的。也希望各路英豪提出宝贵意见。



