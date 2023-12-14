package ae.altkamul.signing_sunmi;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** SigningSunmiPlugin */
public class SigningSunmiPlugin implements FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private MethodChannel channel;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "signing_sunmi");
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getSignEncryptedHash")) {
      result.success(sign(call.argument("signStr")));
    } else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
  public String sign(String content) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
    String rsaPrivateKey = "ecf6b5f032f34bd992eb8675445927b6";
    byte[] keyBytes = Base64.getDecoder().decode(rsaPrivateKey.replaceAll("(\\s)|(--.*--)", ""));
    PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
    Signature signature = Signature.getInstance("SHA256withRSA");
    signature.initSign(priKey);
    signature.update(content.getBytes());
    return Base64.getEncoder().encodeToString(signature.sign());
  }
}
