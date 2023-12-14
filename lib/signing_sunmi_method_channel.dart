import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'signing_sunmi_platform_interface.dart';

/// An implementation of [SigningSunmiPlatform] that uses method channels.
class MethodChannelSigningSunmi extends SigningSunmiPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('signing_sunmi');

  @override
  Future<String?> getSignEncryptedHash(String signStr) async {
    final version = await methodChannel.invokeMethod<String>('getSignEncryptedHash', {'signStr': signStr});
    return version;
  }
}
