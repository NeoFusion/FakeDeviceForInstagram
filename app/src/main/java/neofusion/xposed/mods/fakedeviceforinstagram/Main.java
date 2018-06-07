package neofusion.xposed.mods.fakedeviceforinstagram;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Main implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.instagram.android")) {
            return;
        }
        Class<?> classBuild = XposedHelpers.findClass("android.os.Build", lpparam.classLoader);
        XposedHelpers.setStaticObjectField(classBuild, "BRAND", "Sony");
        XposedHelpers.setStaticObjectField(classBuild, "MANUFACTURER", "Sony");
        XposedHelpers.setStaticObjectField(classBuild, "MODEL", "C6903");
        XposedHelpers.setStaticObjectField(classBuild, "DEVICE", "C6903");
        XposedHelpers.setStaticObjectField(classBuild, "PRODUCT", "C6903");
    }
}
