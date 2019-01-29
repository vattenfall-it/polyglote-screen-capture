# polyglote-screen-capture
An android testing library that will help you create localized screenshots of your app!


In your instrumentation test using ActivityTestRule, simply add additional rule:

    @Rule
    public LocaleRule localeRule = new LocaleRule(Locale.ENGLISH, ...);
    
and in your test, make a screenshot with:

    PolygloteScreenCapture.takeScreenshot("main_activity");
  
The screenshots will be made for all the langugages your set in LocaleRule constructor!
