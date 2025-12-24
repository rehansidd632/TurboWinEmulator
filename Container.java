package com.winlator.cmod.container;

import android.os.Environment;

import com.winlator.cmod.box64.Box64Preset;
import com.winlator.cmod.contentdialog.DXVKConfigDialog;
import com.winlator.cmod.contentdialog.WineD3DConfigDialog;
import com.winlator.cmod.core.DefaultVersion;
import com.winlator.cmod.core.EnvVars;
import com.winlator.cmod.core.FileUtils;
import com.winlator.cmod.core.KeyValueSet;
import com.winlator.cmod.core.WineInfo;
import com.winlator.cmod.core.WineThemeManager;
import com.winlator.cmod.fexcore.FEXCorePreset;
import com.winlator.cmod.winhandler.WinHandler;
import com.winlator.cmod.xenvironment.ImageFs;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.Iterator;

public class Container {
    public enum XrControllerMapping {
        BUTTON_A, BUTTON_B, BUTTON_X, BUTTON_Y, BUTTON_GRIP, BUTTON_TRIGGER,
        THUMBSTICK_UP, THUMBSTICK_DOWN, THUMBSTICK_LEFT, THUMBSTICK_RIGHT
    }

    // Performance Boost: Added forcecb and optimized mesa_glthread for low-end phones
    public static final String DEFAULT_ENV_VARS = "WRAPPER_MAX_IMAGE_COUNT=1 ZINK_DESCRIPTORS=lazy ZINK_DEBUG=compact MESA_SHADER_CACHE_DISABLE=false MESA_SHADER_CACHE_MAX_SIZE=512MB mesa_glthread=true WINEESYNC=1 TU_DEBUG=noconform,sysmem,forcecb DXVK_HUD=devinfo,fps,frametimes,gpuload,version,api";
    
    public static final String DEFAULT_SCREEN_SIZE = "800x600"; // Changed to lower resolution for better performance
    public static final String DEFAULT_GRAPHICS_DRIVER = "wrapper";
    public static final String DEFAULT_AUDIO_DRIVER = "alsa";
    public static final String DEFAULT_EMULATOR = "FEXCore";
    public static final String DEFAULT_DXWRAPPER = "dxvk+vkd3d";

    // RAM Fix: Increased default videoMemorySize to 4096 (4GB) for smoother gaming
    public static final String DEFAULT_DXWRAPPERCONFIG = "version=" + DefaultVersion.DXVK + ",framerate=0,async=1,asyncCache=1" + ",vkd3dVersion=" + DefaultVersion.VKD3D + ",vkd3dLevel=12_1" + ",ddrawrapper=" + Container.DEFAULT_DDRAWRAPPER + ",csmt=3" + ",gpuName=NVIDIA GeForce GTX 1050" + ",videoMemorySize=4096" + ",strict_shader_math=0" + ",OffscreenRenderingMode=fbo" + ",renderer=gl";
    
    public static final String DEFAULT_GRAPHICSDRIVERCONFIG =
            "vulkanVersion=1.3" + ";version=" + ";blacklistedExtensions=" + ";maxDeviceMemory=0" + ";presentMode=mailbox" + ";syncFrame=0" + ";disablePresentWait=0" + ";resourceType=auto" + ";bcnEmulation=auto" + ";bcnEmulationType=software" + ";bcnEmulationCache=0";
    public static final String DEFAULT_DDRAWRAPPER = "none";
    public static final String DEFAULT_WINCOMPONENTS = "direct3d=1,directsound=0,directmusic=0,directshow=0,directplay=0,xaudio=0,vcrun2010=1";
    public static final String FALLBACK_WINCOMPONENTS = "direct3d=1,directsound=1,directmusic=1,directshow=1,directplay=1,xaudio=1,vcrun2010=1";
    public static final String DEFAULT_DRIVES = "D:"+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

    // Rest of the class logic remains same to ensure stability
    public final int id;
    private String name;
    private String screenSize = DEFAULT_SCREEN_SIZE;
    private String envVars = DEFAULT_ENV_VARS;
    // ... [Original methods like getName, setName, saveData, etc. continue here] ...

