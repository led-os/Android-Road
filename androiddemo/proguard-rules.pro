-dontpreverify
-dontoptimize
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-keepattributes Exceptions,SourceFile,LineNumberTable
#-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class com.android.vending.licensing.ILicensingService

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  	public static final android.os.Parcelable$Creator *;
}

#lib
-keep public class com.jb.util.** { public *; protected *;}

# ShellEngine
-keep public class com.go.gl.** { public *; protected *;}
-keep class com.go.gl.ICleanup { *;}
-keep class com.go.gl.graphics.TextureListener { *;}
-keep class com.go.gl.graphics.TextureLoadedListener { *;}
-keep class com.go.gl.scroller.ScreenScrollerListener { *;}
-keep class com.go.gowidget.core.IGoWidget3D { *;}
-keep class com.go.gowidget.core.IFullScreenNextWidget {*;}

# innerClasses
-keep class com.go.gl.animation.Animation$AnimationListener { *;}
-keep class com.go.gl.view.GLView$On*Listener { *;}
-keep class com.go.gl.view.GLViewGroup$On*Listener { *;}
-keep class com.go.gl.widget.GLAdapterView$On*Listener { *;}
-keep class com.go.gl.widget.GLAbsListView$On*Listener { *;}
-keep class com.go.gl.widget.GLAbsListView$RecyclerListener { *;}
-keep class com.go.gl.view.GLLayoutInflater$Factory { *;}
-keep class com.go.gl.view.GLLayoutInflater$Filter { *;}
-keep class com.go.gl.MemoryManager$MemoryListener { *;}
-keep class com.go.gl.animation.Smoother$SmoothListener { *;}

# keep child extends views
-keep public class * extends com.go.gl.view.GLView
-keep public class * extends com.go.gl.view.GLViewGroup
-keep public class * extends com.sny.tangyong.shellengine.animation.Animation
-keep public class * extends com.go.gl.widget.GLAdapterView
-keep public class * extends com.go.gl.widget.GLAbsListView
-keep public class com.go.gowidget.core.** { *;}

# 3d widget entry
-keepclassmembers class * extends android.app.Activity {
   public ** create3DWidget(android.content.Context, com.go.gl.view.GLLayoutInflater, android.os.Bundle);
}

# ShellEngine4widget
-keep class com.jiubang.gl.GLActivity { public *;}
-keep class * extends com.jiubang.gl.GLActivity { public *; }

# FrontWallpaper
-keep class com.gtp.frontwallpaper.core.** { *;}

# error report and the third libs
-keep class org.acra.** { *;}

# box2d 
-keep class com.badlogic.gdx.** { *;}
-keep class com.gtp.box2d.**{*;}

# ads 
-dontwarn com.google.ads.**
-keep class com.google.ads.** { *;}

# facebook 
-dontwarn com.facebook.**
-keep class com.facebook.** { *;}

# v4 
-dontwarn android.support.v4.**
-keep class android.support.v4.** { *;}

#sort
-keep class com.gtp.data.ItemInfo { public <methods>;}
-keep public class * extends com.gtp.data.ItemInfo { public <methods>;}
-keep class com.gtp.theme.Theme { public <methods>;}
-keep class com.gtp.nextlauncher.themeManager.SpaceCalculator { public <methods>;}

# getjar
-dontwarn com.getjar.sdk.**
-keep class com.getjar.sdk.** { *;}

# ad
-dontwarn com.gau.go.checkutil.uninstallcheck.**
-keep class com.gau.go.checkutil.uninstallcheck.** { *;}

-keep class mp.** { *; }

# GA
-dontwarn com.google.android.gms.**
-keep class com.google.android.gms.** { *; }

-dontwarn com.badlogic.gdx.jnigen.**
-dontwarn net.margaritov.preference.colorpicker.**

-dontwarn net.tsz.afinal.**
-dontwarn com.go.gl.scroller.effector.**