import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'signing_sunmi_method_channel.dart';

abstract class SigningSunmiPlatform extends PlatformInterface {
  /// Constructs a SigningSunmiPlatform.
  SigningSunmiPlatform() : super(token: _token);

  static final Object _token = Object();

  static SigningSunmiPlatform _instance = MethodChannelSigningSunmi();

  /// The default instance of [SigningSunmiPlatform] to use.
  ///
  /// Defaults to [MethodChannelSigningSunmi].
  static SigningSunmiPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [SigningSunmiPlatform] when
  /// they register themselves.
  static set instance(SigningSunmiPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getSignEncryptedHash(String signStr) {
    throw UnimplementedError('getSignEncryptedHash() has not been implemented.');
  }
}
