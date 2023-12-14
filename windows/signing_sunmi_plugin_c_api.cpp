#include "include/signing_sunmi/signing_sunmi_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "signing_sunmi_plugin.h"

void SigningSunmiPluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  signing_sunmi::SigningSunmiPlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
