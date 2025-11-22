AnalikaStore Android App (Kotlin + Jetpack Compose) - Project ZIP

What you get:
 - Android Studio project skeleton (Kotlin, Jetpack Compose)
 - Product listing, product detail, cart, checkout (mocked), service booking screens
 - Retrofit-ready ApiService and NetworkModule pointed at https://www.analikastore.com/
 - MockRepository falls back to local data if your API isn't available
 - Razorpay sample helper class (Razorpay SDK integration sample)
 - Firebase placeholder and instructions
 - Instructions to build APK, add signing keys, and publish

Next steps (what I included for A/B/C/D):
A) Runnable project ZIP:
   - The included code is a full Android project skeleton. Open in Android Studio (File -> Open).
   - If you have real API endpoints, implement ApiService calls in place of MockRepository or call NetworkModule.apiService from viewmodels.
   - Update BASE_URL in NetworkModule if needed.

B) Payment integration (Razorpay sample):
   - I added app/payment/RazorpayHelper.kt showing how to open the Razorpay Checkout.
   - Your backend should create an order with Razorpay Orders API and return 'order_id' and amount.
   - On checkout: call your backend -> get order_id and amount -> call RazorpayHelper.startPayment(activity, amountPaise, orderId)
   - Add your Razorpay Key ID to the helper or secure it in your backend and pass metadata.

C) Firebase (Auth + Analytics) placeholders:
   - Place your google-services.json into app/ and add Firebase Gradle plugin and dependencies in build.gradle to enable Firebase.
   - Implement auth using FirebaseAuthWrapper.kt

D) APK & Publish:
   - This project does NOT include a signed release key. To produce a signed APK:
       1. In Android Studio, Build -> Generate Signed Bundle / APK -> follow prompts.
       2. Supply keystore file, alias, password.
   - I included publishing notes below.

Important files to edit before building:
 - app/build.gradle.kts : add Firebase plugin if you enable Firebase
 - app/src/main/AndroidManifest.xml : change application label/icon as needed
 - app/src/main/java/.../payment/RazorpayHelper.kt : replace YOUR_RAZORPAY_KEY_ID with your key
 - app/src/main/java/.../data/NetworkModule.kt : BASE_URL already points to https://www.analikastore.com/

Sample backend API expectations (recommended):
 - GET /api/products -> JSON array of products
 - GET /api/products/{id} -> product detail
 - GET /api/cart -> cart for session/user
 - POST /api/cart -> update cart items
 - POST /api/orders -> create order (returns order id, amount)
 - POST /api/bookings -> create service booking
 - POST /api/razorpay/order -> (backend) create Razorpay order and return order_id and amount to app

Notes & security:
 - Always create Razorpay orders on your backend to avoid exposing your secret.
 - Use HTTPS for all API calls.
 - Validate totals server-side before capturing payment/confirming order.

How I packaged this:
 - A ZIP file with the project is available next to this message.

If you want:
 - I can (1) replace MockRepository with real network calls to your existing APIs (please provide API docs/keys), (2) add a login screen connected to Firebase or your API, (3) wire the checkout to call your backend to create Razorpay orders, and (4) generate an unsigned debug APK inside the ZIP so you can install & test immediately.


Additional automated wiring completed now:
 - MockRepository now attempts network calls via NetworkModule.apiService and falls back to local mock data.
 - Checkout screen now tries to create an order via the backend (placeOrder endpoint) and then opens Razorpay checkout using RazorpayHelper.
 - MainActivity contains a Firebase initialization note; add google-services.json and Firebase dependencies to enable.

Generating APK:
 - I cannot build a signed APK here without your keystore and a full CI setup.
 - To build an unsigned debug APK locally:
    1) Open the project in Android Studio.
    2) Build -> Build Bundle(s) / APK(s) -> Build APK(s).
    3) The debug APK will be in app/build/outputs/apk/debug/.
 - To create a signed release APK:
    1) Generate or provide keystore file.
    2) Build -> Generate Signed Bundle / APK -> follow prompts.

If you want, I can:
 - Replace the placeOrder backend call with a dedicated /api/razorpay/order endpoint call if your backend exposes it (this is more secure and preferred).
 - Add PaymentResultListener handling in MainActivity to receive success/failure callbacks from Razorpay.
 - Add Firebase dependency entries and a sample login screen (I can implement now; you'll need to supply google-services.json to fully test).



----
Automated CI & Signing

I added a GitHub Actions workflow (.github/workflows/android.yml) that:
 - Builds a debug APK on push (artifact uploaded).
 - Optionally builds & signs a release APK when you run the workflow manually (workflow_dispatch) and provide signing secrets.

To enable signed release builds in CI:
 - Add these repository secrets in GitHub: SIGNING_KEY (base64 of your keystore file), KEYSTORE_PASSWORD, KEY_ALIAS, KEY_PASSWORD.
 - Trigger the 'release-sign' workflow manually from Actions UI.

Security reminders:
 - Do NOT paste keystore passwords or private keys in public chat. Use GitHub Secrets or other secure secret stores.
 - Do NOT commit google-services.json or any secrets to the repository. Add them to CI via protected secret channels.

Files you still need to provide (securely):
 - google-services.json (place in app/ before building locally or add via CI secrets mechanism)
 - Razorpay KEY ID (set in RazorpayHelper.kt) and backend endpoint for order creation (/api/razorpay/order recommended)
 - If you want me to prepare the final signing config, upload your keystore via a secure channel or add to GitHub Secrets as described.


Firebase integration steps completed:
 - I copied your uploaded google-services.json into app/google-services.json.
 - I added the Google Services classpath to the project buildscript and added the google-services plugin in the app module.
 - I added the Firebase BOM and basic analytics/auth dependencies in app/build.gradle.kts.

Next steps to fully enable Firebase:
 - Open the project in Android Studio and sync Gradle. The google-services plugin will configure Firebase automatically.
 - If you prefer, replace the Firebase BOM version or add other Firebase services (Crashlytics, Cloud Messaging) as needed.
 - Do NOT commit google-services.json to a public repo if privacy is a concern; treat it as sensitive.

File added: app/google-services.json (uploaded by you).

---
Firebase features implemented:
 - Email/Password Authentication (Login/Signup) with Jetpack Compose screens.
 - AuthViewModel to manage login state and simple session handling.
 - Protected routes: cart, checkout, and booking will check for authenticated user and should redirect to login if not authenticated (basic guard implemented).
 - Profile screen and auth flows added.

Push Notifications (FCM):
 - MyFirebaseMessagingService added to handle incoming messages and display notifications.
 - TODO: send FCM token to your backend to register users for notifications.

Crashlytics:
 - Crashlytics dependencies added and a 'Test Crash (dev)' button added to Home screen to help verify Crashlytics is working (it logs an event; uncomment the throw to force crash during testing).

Admin UI (stubs):
 - Admin screens added (Products, Orders, Bookings). Implement admin API calls to populate these.

Release & CI:
 - Release signing template added to app/build.gradle.kts (use CI secrets or environment variables to supply keystore and passwords).

To test fully:
 1) Open project in Android Studio and sync Gradle.
 2) Ensure google-services.json is present (already copied).
 3) Run the app; try signing up / signing in via email/password.
 4) Test FCM by sending a message from Firebase console to the app (it will show notifications).
 5) Test Crashlytics by triggering the test crash in Home screen (or uncomment the RuntimeException line while testing).

Security & notes:
 - Do not commit google-services.json and keystore files to public repos.
 - For phone auth, you must configure SHA-1 in Firebase console (instructions in Firebase docs).
 - For production payment flows, ensure your backend securely creates Razorpay orders and you verify payments server-side.

