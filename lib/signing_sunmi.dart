
import 'signing_sunmi_platform_interface.dart';

class SigningSunmi {
  Future<String?> getSignEncryptedHash(String signStr) {
    return SigningSunmiPlatform.instance.getSignEncryptedHash(signStr);
  }
}
